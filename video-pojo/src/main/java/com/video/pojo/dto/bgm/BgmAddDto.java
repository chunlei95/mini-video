package com.video.pojo.dto.bgm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xzmeasy
 */
@ApiModel("添加背景音乐的数据传输对象")
@Data
public class BgmAddDto {

    @ApiModelProperty("背景音乐的名称")
    private String name;

    @ApiModelProperty("音频的作者(谁唱的歌)")
    private String author;

}
