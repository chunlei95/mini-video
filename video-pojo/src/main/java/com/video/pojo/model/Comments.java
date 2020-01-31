package com.video.pojo.model;

import lombok.Data;

import java.util.Date;

/**
 * The comments of the specified video.
 *
 * @author xzmeasy
 * @date 2020/1/20
 */
@SuppressWarnings("JavadocReference")
@Data
public class Comments {

    private String id;

    /**
     * @see Video#id
     */
    private String videoId;

    /**
     * The user who comment the specified video.
     *
     * @see User#id
     */
    private String commentsUserId;

    /**
     * Create time.
     */
    private Date createTime;

    /**
     * The detail content of user's comment.
     */
    private String content;

}