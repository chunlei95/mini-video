package com.video.service.service.impl;

import com.video.common.exception.MiniVideoException;
import com.video.common.exception.ResponseCode;
import com.video.common.generator.UidGenerator;
import com.video.mapper.mapper.UserMapper;
import com.video.pojo.dto.UserLoginDto;
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
     * {@inheritDoc}
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createUser(User user) throws MiniVideoException {
        String username = user.getUsername();
        User userByName = this.searchUserByName(username);
        if (Objects.nonNull(userByName)) {
            throw new MiniVideoException(1000, "username is already in use", "用户名已经被使用");
        }
        user.setId(UidGenerator.generateId());
        // TODO: 2020/2/2 MD5密码加密
        userMapper.insert(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User login(UserLoginDto loginUser) throws MiniVideoException {
        // TODO: 2020/2/2 用户登录业务逻辑
        String username = loginUser.getUsername();
        String password = loginUser.getPassword();
        // TODO: 2020/2/2 密码需加密之后在与数据库中的密码比较
        User user = userMapper.selectUserByUsernameAndPassword(username, password);
        if (Objects.isNull(user)) {
            throw new MiniVideoException(ResponseCode.USERNAME_OR_PASSWORD_IS_NOT_CORRECT, "username or password is not correct", "用户名或密码错误");
        }
        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User findUserById(String userId) {
        return userMapper.selectUserByPrimaryKey(userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
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
