package com.video.pojo.vo.video;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author xzmeasy
 * @since 2020/2/23
 */
@Api("首页视频展示用")
@Data
public class VideoVo {

    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("上传人的id")
    private String userId;

    @ApiModelProperty("上传人的昵称")
    private String nickname;

    @ApiModelProperty("上传人的头像")
    private String icon;

    @ApiModelProperty("背景音乐的id")
    private String audioId;

    @ApiModelProperty("视频描述")
    private String videoDesc;

    @ApiModelProperty("视频时长")
    private Float videoSeconds;

    @ApiModelProperty("视频访问路径")
    private String videoPath;

    @ApiModelProperty("视频宽度")
    private Integer videoWidth;

    @ApiModelProperty("视频高度")
    private Integer videoHeight;

    @ApiModelProperty("视频大小")
    private Long videoSize;

    @ApiModelProperty("封面的路径")
    private String coverPath;

    @ApiModelProperty("点赞数")
    private Long likeCounts;

    @ApiModelProperty("状态")
    private Integer status;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("最后一次更新的时间")
    private Date updateTime;

}
