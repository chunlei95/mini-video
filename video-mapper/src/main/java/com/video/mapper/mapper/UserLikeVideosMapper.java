package com.video.mapper.mapper;

import com.video.pojo.model.UserLikeVideos;

import java.util.List;

/**
 * @author xzmeasy
 * @date 2020/1/20
 */
@SuppressWarnings("JavadocReference")
public interface UserLikeVideosMapper {

    /**
     * Delete a record with specified primary key.
     *
     * @param id {@link UserLikeVideos#id}
     * @return The count of delete successfully.
     */
    int deleteByPrimaryKey(String id);

    /**
     * Insert a record.
     *
     * @param record The record need to be inserted.
     * @return The count of insert successfully.
     */
    int insert(UserLikeVideos record);

    /**
     * Search by primary key and return search result.
     *
     * @param id {@link UserLikeVideos#id}
     * @return The record with the specified primary key.
     */
    UserLikeVideos selectByPrimaryKey(String id);

    /**
     * Select all records.
     *
     * @return All records of {@link UserLikeVideos}.
     */
    List<UserLikeVideos> selectAll();

    /**
     * Update record of the specified primary key.
     *
     * @param record New {@link UserLikeVideos} information
     * @return The count of updated record.
     */
    int updateByPrimaryKey(UserLikeVideos record);

}