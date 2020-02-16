package com.video.pojo.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xzmeasy
 * @since 1.0
 **/
@Data
@ApiModel("用户注册对象")
public class UserRegisterDto {

    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

}
