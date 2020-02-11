package com.video.mapper.mapper;

import com.video.pojo.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xzmeasy
 * @date 2020/1/20
 */
@SuppressWarnings("JavadocReference")
public interface UserMapper {

    /**
     * Insert a record.
     *
     * @param record The record need to be inserted.
     * @return The count of insert successfully.
     */
    int insert(User record);

    /**
     * Select all records.
     *
     * @return All records of {@link User}.
     */
    List<User> selectAll();

    /**
     * Search user by username.
     *
     * @param username username
     * @return User with specified username.
     */
    User selectUserByUsername(String username);

    /**
     * Search user by username and password.
     *
     * @param username {@link User#username}
     * @param password {@link User#password}
     * @return {@link User}
     */
    User selectUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    /**
     * Search user by primary key.
     *
     * @param userId user id
     * @return {@link User} that with specified {@code userId}.
     */
    User selectUserByPrimaryKey(String userId);

    /**
     * Update user information.
     *
     * @param user User information need to be updated.
     * @return Updated count.
     */
    int updateByPrimaryKey(User user);

}