package com.video.pojo.dto.video;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xzmeasy
 * @since 2020/2/15
 */
@ApiModel("视频上传用的数据传输对象")
@Data
public class VideoUploadDto {

    @ApiModelProperty("背景音乐的id")
    private String audioId;

    @ApiModelProperty("视频描述")
    private String videoDesc;

    @ApiModelProperty("视频时长")
    private Float videoSeconds;

    @ApiModelProperty("视频宽度")
    private Integer videoWidth;

    @ApiModelProperty("视频高度")
    private Integer videoHeight;

    @ApiModelProperty("视频大小")
    private Long videoSize;

    @ApiModelProperty("封面的路径")
    private String coverPath;

}
