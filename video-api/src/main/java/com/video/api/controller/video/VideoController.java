package com.video.api.controller.video;

import com.ffmpeg.autoconfigure.service.FFMpegService;
import com.qiniu.autoconfigure.response.av.video.VideoPutRet;
import com.qiniu.autoconfigure.response.image.ImagePutRet;
import com.qiniu.autoconfigure.service.QiNiuService;
import com.video.api.transfer.video.VideoTransfer;
import com.video.api.util.user.UserUtil;
import com.video.common.generator.IdGenerator;
import com.video.common.response.ResponseResult;
import com.video.pojo.dto.video.VideoUploadDto;
import com.video.pojo.model.Bgm;
import com.video.pojo.model.Video;
import com.video.service.service.BgmService;
import com.video.service.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Objects;

/**
 * @author xzmeasy
 * @since 2020/2/15
 */
@Api(tags = "video", value = "视频管理接口")
@RestController
public class VideoController {

    private Logger logger = LoggerFactory.getLogger(VideoController.class);

    private final FFMpegService ffMpegService;

    private final BgmService bgmService;

    private final IdGenerator idGenerator;

    private final QiNiuService qiNiuService;

    private final VideoService videoService;

    public VideoController(VideoService videoService,
                           QiNiuService qiNiuService,
                           IdGenerator idGenerator,
                           BgmService bgmService, FFMpegService ffMpegService) {
        this.videoService = videoService;
        this.qiNiuService = qiNiuService;
        this.idGenerator = idGenerator;
        this.bgmService = bgmService;
        this.ffMpegService = ffMpegService;
    }

    @ApiOperation("上传视频")
    @PostMapping("/user/{userId}/video")
    public ResponseResult<Video> upload(@PathVariable String userId,
                                        VideoUploadDto videoUploadDto,
                                        MultipartFile video) {
        UserUtil.checkUserExist(userId);
        Video uploadVideo = VideoTransfer.transformFromVideoUploadDto(videoUploadDto);
        VideoPutRet videoPutRet = new VideoPutRet();
        String videoPathToCreateCover = "";
        // 如果传了bgmId，则合并视频和音频再上传
        if (StringUtils.isNoneBlank(uploadVideo.getAudioId())) {
            // 获取要合并的bgm的路径(文件服务器上的路径，目前是保存在七牛云上)
            String bgmId = uploadVideo.getAudioId();
            Bgm bgm = bgmService.findById(bgmId);
            String bgmPath = bgm.getPath();
            // 设置用来临时保存文件的目录
            String tempFilePath = System.getProperty("user.dir");
            try {
                // 上传到本地临时文件位置(当前工作目录)
                video.transferTo(Path.of(tempFilePath, video.getOriginalFilename()));
                File tempFile = new File(tempFilePath, Objects.requireNonNull(video.getOriginalFilename()));
                videoPathToCreateCover = tempFile.getPath();
                // 合并音频和视频
                String mergedVideoPath = ffMpegService.mergeAudioAndVideo(tempFile.getPath(), bgmPath);
                File mergedVideo = new File(mergedVideoPath);
                videoPutRet = qiNiuService.uploadVideo(mergedVideo);
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        } else {
            videoPutRet = qiNiuService.uploadVideo(video);
            videoPathToCreateCover = videoPutRet.getPath();
        }
        // 视频上传成功后生成视频的封面信息，并上传到文件服务器
        String videoPath = videoPutRet.getPath();
        String videoCover = ffMpegService.createVideoCover(videoPathToCreateCover);
        File videoCoverFile = new File(videoCover);
        // 上传视频封面到文件服务器
        ImagePutRet imagePutRet = qiNiuService.uploadImage(videoCoverFile);
        // 完善要保存到数据库中的video的信息
        uploadVideo.setCoverPath(imagePutRet.getImageUrl());
        uploadVideo.setVideoPath(videoPath);
        uploadVideo.setId(idGenerator.generate());
        uploadVideo.setUserId(userId);
        // 上传视频信息到数据库
        Video result = videoService.add(uploadVideo);
        return ResponseResult.ok(result);
    }

}
