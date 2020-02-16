package com.video.api.util.user;

import com.video.common.exception.ExceptionInfo;
import com.video.common.exception.MiniVideoException;
import com.video.common.util.SpringUtil;
import com.video.pojo.model.User;
import com.video.service.service.UserService;
import org.springframework.lang.NonNull;

import java.util.Objects;
import java.util.UUID;

/**
 * @author xzmeasy
 * @date 2020/2/2
 */
@SuppressWarnings("JavadocReference")
public class UserUtil {

    /**
     * Generate the value of {@link com.video.pojo.vo.UserLoginVo#userToken userToken}
     *
     * @return Generated value of {@code userToken}
     */
    public static String createUserTokenValue() {
        return UUID.randomUUID().toString();
    }

    /**
     * Create redis key to store user token.
     *
     * @param userId {@link com.video.pojo.model.User#id}.
     * @return A string redis key.
     */
    public static String createUserSessionKey(String userId) {
        return "user-redis-session:" + userId;
    }

    /**
     * Check user that with specified id whether exist.
     *
     * @param userId User id.
     */
    public static void checkUserExist(@NonNull String userId) {
        UserService userService = SpringUtil.getBean(UserService.class);
        User user = userService.findUserById(userId);
        if (Objects.isNull(user)) {
            throw new MiniVideoException(ExceptionInfo.USER_NOT_EXIST);
        }
    }

}
