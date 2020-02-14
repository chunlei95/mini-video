package com.video.pojo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author xzmeasy
 * @date 2020/1/20
 */
@Data
@ApiModel("背景音乐实体类")
public class Bgm {

    @ApiModelProperty("唯一标识符")
    private String id;

    @ApiModelProperty("背景音乐的作者")
    private String author;

    @ApiModelProperty("背景音乐的名称")
    private String name;

    @ApiModelProperty("背景音乐的保存路径")
    private String path;

    @ApiModelProperty("背景音乐添加时间")
    private Date createTime = new Date();

}