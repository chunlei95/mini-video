package com.video.pojo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author xzmeasy
 * @date 2020/1/20
 */
@ApiModel(description = "用户信息实体类")
@Data
public class User {

    @ApiModelProperty(required = true)
    private String id;

    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "昵称")
    private String nickname = "none";

    @ApiModelProperty(value = "头像路径", required = true)
    private String icon = "none";

    @ApiModelProperty(value = "粉丝数量", required = true)
    private Integer fansCount = 0;

    @ApiModelProperty(value = "关注数量", required = true)
    private Integer followCount = 0;

    @ApiModelProperty(value = "被赞数量", required = true)
    private Integer praiseCount = 0;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime = new Date();

    @ApiModelProperty(value = "最近一次更新时间", required = true)
    private Date updateTime = new Date();

}