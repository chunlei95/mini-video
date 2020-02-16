package com.video.api.controller.bgm;

import com.qiniu.autoconfigure.response.av.audio.AudioPutRet;
import com.qiniu.autoconfigure.service.QiNiuService;
import com.video.api.transfer.bgm.BgmTransfer;
import com.video.common.generator.IdGenerator;
import com.video.common.response.ResponseResult;
import com.video.pojo.dto.bgm.BgmAddDto;
import com.video.pojo.model.Bgm;
import com.video.service.service.BgmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author xzmeasy
 * @date 2020/2/14
 */
@Api(tags = "bgm", value = "背景音乐管理接口")
@RestController
public class BgmController {

    private final IdGenerator idGenerator;

    private final QiNiuService qiNiuService;

    private final BgmService bgmService;

    public BgmController(BgmService bgmService,
                         QiNiuService qiNiuService,
                         IdGenerator idGenerator) {
        this.bgmService = bgmService;
        this.qiNiuService = qiNiuService;
        this.idGenerator = idGenerator;
    }

    @ApiOperation("查询所有的背景音乐")
    @GetMapping("/bgm/list")
    public ResponseResult<List<Bgm>> findAll() {
        List<Bgm> bgms = bgmService.bgmList();
        return ResponseResult.ok(bgms);
    }


    @ApiOperation("添加背景音乐")
    @PostMapping(value = "/bgm")
    public ResponseResult<Bgm> add(BgmAddDto bgmAddDto,
                                   MultipartFile audio) {
        AudioPutRet audioPutRet = qiNiuService.uploadAudio(audio);
        String audioPath = audioPutRet.getPath();
        Bgm bgm = BgmTransfer.transformFromBgmAddDto(bgmAddDto);
        bgm.setId(idGenerator.generate());
        bgm.setPath(audioPath);
        Bgm result = bgmService.add(bgm);
        return ResponseResult.ok(result);
    }

}
