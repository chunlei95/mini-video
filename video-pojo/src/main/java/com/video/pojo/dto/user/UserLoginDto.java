package com.video.pojo.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Data transfer object of user login request.
 *
 * @author xzmeasy
 * @date 2020/2/2
 */
@Data
@ApiModel(description = "用户登录请求的数据传输对象")
public class UserLoginDto {

    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @ApiModelProperty(value = "用户密码", required = true)
    private String password;

}
