package com.video.pojo.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * @author xzmeasy
 * @date 2020/2/1
 */
@Data
@ApiModel("用户注册逻辑的返回数据")
public class UserLoginVo {

    private String id;

    private String username;

    private String icon;

    private String nickname;

    private Integer fansCount;

    private Integer praiseCount;

    private Integer followCount;

    private String userToken;

    private Date createTime;

    private Date updateTime;

}
