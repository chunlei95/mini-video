package com.video.service.service;

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

}
