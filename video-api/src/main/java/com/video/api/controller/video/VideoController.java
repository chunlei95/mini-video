package com.video.api.controller.video;

import com.qiniu.autoconfigure.response.av.video.VideoPutRet;
import com.qiniu.autoconfigure.service.QiNiuService;
import com.video.api.transfer.video.VideoTransfer;
import com.video.api.util.user.UserUtil;
import com.video.common.generator.IdGenerator;
import com.video.common.response.ResponseResult;
import com.video.pojo.dto.video.VideoUploadDto;
import com.video.pojo.model.Video;
import com.video.service.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author xzmeasy
 * @since 2020/2/15
 */
@Api(tags = "video", value = "视频管理接口")
@RestController
public class VideoController {

    private final IdGenerator idGenerator;

    private final QiNiuService qiNiuService;

    private final VideoService videoService;

    public VideoController(VideoService videoService,
                           QiNiuService qiNiuService,
                           IdGenerator idGenerator) {
        this.videoService = videoService;
        this.qiNiuService = qiNiuService;
        this.idGenerator = idGenerator;
    }

    @ApiOperation("上传视频")
    @PostMapping("/user/{userId}/video")
    public ResponseResult<Video> upload(@PathVariable String userId,
                                        VideoUploadDto videoUploadDto,
                                        MultipartFile video) {
        UserUtil.checkUserExist(userId);
        VideoPutRet videoPutRet = qiNiuService.videoUpload(video);
        String videoPath = videoPutRet.getPath();
        Video uploadVideo = VideoTransfer.transformFromVideoUploadDto(videoUploadDto);
        uploadVideo.setVideoPath(videoPath);
        uploadVideo.setId(idGenerator.generate());
        uploadVideo.setUserId(userId);
        Video result = videoService.add(uploadVideo);
        return ResponseResult.ok(result);
    }

}
