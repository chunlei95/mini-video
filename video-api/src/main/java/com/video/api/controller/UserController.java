package com.video.api.controller;

import com.video.api.transfer.UserTransfer;
import com.video.common.response.ResponseResult;
import com.video.pojo.UserRegisterDto;
import com.video.pojo.model.User;
import com.video.service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xzmeasy
 * @since 1.0
 **/
@Api(value = "用户管理", tags = "user")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("用户注册")
    @PostMapping("/user/register")
    public ResponseResult register(@RequestBody UserRegisterDto userRegisterDto) {
        User user = UserTransfer.transformToUser(userRegisterDto);
        userService.createUser(user);
        return ResponseResult.ok();
    }

}
