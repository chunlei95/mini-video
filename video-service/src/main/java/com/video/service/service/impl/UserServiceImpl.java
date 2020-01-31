package com.video.service.service.impl;

import com.video.common.exception.MiniVideoException;
import com.video.common.generator.UidGenerator;
import com.video.mapper.mapper.UserMapper;
import com.video.pojo.model.User;
import com.video.service.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @author xzmeasy
 * @date 2020/1/20
 **/
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * Register user
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createUser(User user) {
        String username = user.getUsername();
        User userByName = this.searchUserByName(username);
        if (Objects.nonNull(userByName)) {
            throw new MiniVideoException(1000, "username is already in use");
        }
        user.setId(UidGenerator.generateId());
        userMapper.insert(user);
    }


    /**
     * Search user by username.
     *
     * @param username username
     * @return The user with specified username.
     */
    private User searchUserByName(String username) {
        return userMapper.selectUserByUsername(username);
    }

}
