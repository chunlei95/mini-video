package com.video.pojo.model;

import lombok.Data;

import java.util.Date;

/**
 * @author xzmeasy
 * @date 2020/1/20
 */
@Data
public class Video {

    private String id;

    private String userId;

    private String audioId;

    private String videoDesc;

    private Float videoSeconds;

    private String videoPath;

    private Integer videoWidth;

    private Integer videoHeight;

    private String coverPath;

    private Long likeCounts;

    private Integer status;

    private Date createTime;

    private Date updateTime;

}