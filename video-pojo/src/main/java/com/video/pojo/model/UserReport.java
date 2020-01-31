package com.video.pojo.model;

import lombok.Data;

import java.util.Date;

/**
 * @author xzmeasy
 * @date 2020/1/20
 */
@Data
public class UserReport {

    private String id;

    private String dealUserId;

    private String dealVideoId;

    private String userId;

    private String title;

    private String content;

    private Date createTime;

}