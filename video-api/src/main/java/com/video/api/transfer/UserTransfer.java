package com.video.api.transfer;

import com.video.pojo.dto.UserRegisterDto;
import com.video.pojo.model.User;
import com.video.pojo.vo.UserLoginVo;
import com.video.pojo.vo.UserVo;
import org.springframework.beans.BeanUtils;

/**
 * Used to transform a dto info {@link User} object.
 *
 * @author xzmeasy
 * @since 1.0
 **/
public class UserTransfer {

    /**
     * Transform {@link UserRegisterDto} to {@link User}.
     *
     * @param registerDTO {@link UserRegisterDto}
     * @return {@link User}
     */
    public static User transformToUser(UserRegisterDto registerDTO) {
        User user = new User();
        BeanUtils.copyProperties(registerDTO, user);
        return user;
    }

    /**
     * Transform {@link User} to {@link UserLoginVo}
     *
     * @param user {@link User user}
     * @return {@link UserLoginVo}
     */
    public static UserLoginVo transformUserToUserLoginVo(User user) {
        UserLoginVo userLoginVo = new UserLoginVo();
        BeanUtils.copyProperties(user, userLoginVo);
        return userLoginVo;
    }

    /**
     * Transfer {@link User} to {@link UserVo}.
     *
     * @param user {@link User}.
     * @return {@link UserVo}.
     */
    public static UserVo transforUserToUserVo(User user) {
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        return userVo;
    }
}
