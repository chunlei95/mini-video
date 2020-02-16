package com.video.service.service;

import com.video.pojo.dto.user.UserLoginDto;
import com.video.pojo.model.User;

/**
 * @author xzmeasy
 * @since 2020/1/20
 **/
public interface UserService {

    /**
     * Create user.
     *
     * @param user The user information need to be created.
     */
    void createUser(User user);

    /**
     * User login service method.
     *
     * @param loginUser Include two property at the present, {@code username} and {@code password}.
     * @return User with the specified {@code username} and {@code password}.
     */
    User login(UserLoginDto loginUser);

    /**
     * Search {@link User} with the specified {@code userId}.
     *
     * @param userId User id.
     * @return User that with specified {@code userId}.
     */
    User findUserById(String userId);

    /**
     * Update user.
     *
     * @param user User information need to be updated.
     * @return Updated record count.
     */
    int updateUser(User user);

}
