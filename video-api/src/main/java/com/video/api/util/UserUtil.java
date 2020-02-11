package com.video.api.util;

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

}
