package com.video.api.transfer;

import com.video.pojo.UserRegisterDto;
import com.video.pojo.model.User;
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

}
