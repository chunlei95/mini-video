package com.video.mapper.mapper;

import com.video.pojo.model.UserReport;

import java.util.List;

/**
 * @author xzmeasy
 * @date 2020/1/20
 */
@SuppressWarnings("JavadocReference")
public interface UserReportMapper {

    /**
     * Delete a record with specified primary key.
     *
     * @param id {@link UserReport#id}
     * @return The count of delete successfully.
     */
    int deleteByPrimaryKey(String id);

    /**
     * Insert a record.
     *
     * @param record The record need to be inserted.
     * @return The count of insert successfully.
     */
    int insert(UserReport record);

    /**
     * Search by primary key and return search result.
     *
     * @param id {@link UserReport#id}
     * @return The record with the specified primary key.
     */
    UserReport selectByPrimaryKey(String id);

    /**
     * Select all records.
     *
     * @return All records of {@link UserReport}.
     */
    List<UserReport> selectAll();

    /**
     * Update record of the specified primary key.
     *
     * @param record New {@link UserReport} information
     * @return The count of updated record.
     */
    int updateByPrimaryKey(UserReport record);

}