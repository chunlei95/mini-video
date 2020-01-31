package com.video.mapper.mapper;

import com.video.pojo.model.User;

import java.util.List;

/**
 * @author xzmeasy
 * @date 2020/1/20
 */
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

}