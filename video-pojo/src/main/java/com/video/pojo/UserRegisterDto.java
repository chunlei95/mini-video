package com.video.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author xzmeasy
 * @since 1.0
 **/
@ApiModel("用户注册对象")
public class UserRegisterDto {

    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

}
