package com.video.mapper.mapper;

import com.video.pojo.model.Comments;

import java.util.List;

/**
 * @author xzmeasy
 * @date 2020/1/20
 */
@SuppressWarnings("JavadocReference")
public interface CommentsMapper {

    /**
     * Delete a record with specified primary key.
     *
     * @param id {@link Comments#id}
     * @return The count of delete successfully.
     */
    int deleteByPrimaryKey(String id);

    /**
     * Insert a record.
     *
     * @param record The record need to be inserted.
     * @return The count of insert successfully.
     */
    int insert(Comments record);

    /**
     * Search by primary key and return search result.
     *
     * @param id {@link Comments#id}
     * @return The record with the specified primary key.
     */
    Comments selectByPrimaryKey(String id);

    /**
     * Select all records.
     *
     * @return All records of {@link Comments}.
     */
    List<Comments> selectAll();

    /**
     * Update record of the specified primary key.
     *
     * @param record New {@link Comments} information
     * @return The count of updated record.
     */
    int updateByPrimaryKey(Comments record);

}