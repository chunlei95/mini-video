package com.video.pojo.model;

import lombok.Data;

import java.util.Date;

/**
 * A model used to collect user's search records.
 *
 * @author xzmeasy
 * @date 2020/1/20
 */
@Data
public class SearchRecord {

    private String id;

    /**
     * The content of user's search record.
     */
    private String content;

    /**
     * The time that user run search operation.
     */
    private Date searchTime;

}