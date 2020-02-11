package com.video.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * View object used to deliver user information to front end.
 *
 * @author xzmeasy
 * @date 2020/2/4
 */
@Data
public class UserVo {

    private String id;

    private String username;

    private String icon;

    private String nickname;

    private Integer fansCount;

    private Integer praiseCount;

    private Integer followCount;

    private Date createTime;

    private Date updateTime;

}
