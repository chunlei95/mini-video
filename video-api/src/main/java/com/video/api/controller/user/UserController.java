package com.video.api.controller.user;

import com.qiniu.autoconfigure.response.image.ImagePutRet;
import com.qiniu.autoconfigure.service.QiNiuService;
import com.video.api.transfer.user.UserTransfer;
import com.video.api.util.user.UserUtil;
import com.video.common.exception.MiniVideoException;
import com.video.common.exception.ResponseCode;
import com.video.common.generator.IdGenerator;
import com.video.common.redis.RedisService;
import com.video.common.response.ResponseResult;
import com.video.pojo.dto.user.UserLoginDto;
import com.video.pojo.dto.user.UserRegisterDto;
import com.video.pojo.model.User;
import com.video.pojo.vo.user.ImageUploadVo;
import com.video.pojo.vo.user.UserLoginVo;
import com.video.pojo.vo.user.UserVo;
import com.video.service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Objects;

/**
 * Controller of user model.
 *
 * @author xzmeasy
 * @since 1.0
 **/
@Api(value = "用户管理", tags = "user")
@RestController
public class UserController {

    private final IdGenerator idGenerator;

    private final QiNiuService qiNiuService;

    private final UserService userService;

    private final RedisService redisService;

    public UserController(UserService userService,
                          RedisService redisService,
                          QiNiuService qiNiuService,
                          IdGenerator idGenerator) {
        this.userService = userService;
        this.redisService = redisService;
        this.qiNiuService = qiNiuService;
        this.idGenerator = idGenerator;
    }

    @ApiOperation("用户注册")
    @PostMapping("/user/register")
    public ResponseResult<User> register(@RequestBody UserRegisterDto userRegisterDto) {
        User user = UserTransfer.transformToUser(userRegisterDto);
        user.setId(idGenerator.generate());
        userService.createUser(user);
        return ResponseResult.ok();
    }

    @ApiOperation("用户登录")
    @GetMapping("/user/login")
    public ResponseResult<UserLoginVo> login(UserLoginDto user) {
        // 用户名密码登录
        User loginUser = userService.login(user);
        UserLoginVo userLoginVo = UserTransfer.transformUserToUserLoginVo(loginUser);
        // 生成redis的key和value
        String userSessionKey = UserUtil.createUserSessionKey(userLoginVo.getId());
        String userTokenValue = UserUtil.createUserTokenValue();
        // 保存到redis中
        redisService.set(userSessionKey, userTokenValue);
        userLoginVo.setUserToken(userTokenValue);
        return ResponseResult.ok(userLoginVo);
    }

    @ApiOperation("退出登录")
    @GetMapping("/user/logout")
    public ResponseResult<Void> logout(String userId) {
        String userSessionKey = UserUtil.createUserSessionKey(userId);
        // 删除redis中对应的用户登录的session key
        redisService.delete(userSessionKey);
        return ResponseResult.ok();
    }

    @ApiOperation("根据用户id查询用户详情")
    @GetMapping("/user/{userId}")
    public ResponseResult<UserVo> getUserInfo(@PathVariable String userId) {
        User user = userService.findUserById(userId);
        if (Objects.isNull(user)) {
            throw new MiniVideoException(ResponseCode.USER_IS_NOT_EXIST, "user is not exist", "不存在该用户");
        }
        UserVo userVo = UserTransfer.transforUserToUserVo(user);
        return ResponseResult.ok(userVo);
    }

    @ApiOperation("上传头像")
    @PostMapping("/user/{userId}/icon")
    public ResponseResult<ImageUploadVo> uploadIcon(@PathVariable String userId, @RequestParam("file") MultipartFile file) {
        // 验证用户是否存在
        User user = userService.findUserById(userId);
        if (Objects.isNull(user)) {
            throw new MiniVideoException(ResponseCode.USER_IS_NOT_EXIST, "user is not exist", "不存在该用户");
        }
        // 获取用户头像路径
        ImagePutRet imagePutRet = qiNiuService.uploadImage(file);
        String imageUrl = imagePutRet.getImageUrl();
        // 保存用户头像路径到数据库
        user.setIcon(imageUrl);
        user.setUpdateTime(new Date());
        userService.updateUser(user);
        ImageUploadVo vo = new ImageUploadVo();
        vo.setImageUrl(imageUrl);
        return ResponseResult.ok(vo);
    }

}
