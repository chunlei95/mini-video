create database `mini-video`;
USE `mini-video`;

## 用户信息表
create table `user`
(
    `id`           varchar(64)  not null,
    `username`     varchar(20)  not null comment '用户名',
    `password`     varchar(64)  not null comment '密码',
    `nickname`     varchar(20)  not null comment '昵称',
    `icon`         varchar(255) not null comment '头像路径',
    `fans_count`   int(11)      not null default 0 comment '粉丝数量',
    `follow_count` int(11)      not null default 0 comment '关注数量',
    `praise_count` int(11)      not null default 0 comment '获赞数',
    `create_time`  datetime     not null default current_timestamp comment '创建日期',
    `update_time`  datetime     not null default current_timestamp comment '最后一次更新日期',
    primary key (`id`),
    unique key `username` (`username`)
) engine = InnoDB
  default charset UTF8MB4 comment '用户信息表';

# 背景音乐表
create table `bgm`
(
    `id`     varchar(64)  not null,
    `author` varchar(20)  not null comment '创作人',
    `name`   varchar(255) not null comment '名称',
    `path`   varchar(255) not null comment '播放地址',
    primary key (`id`)
) engine = InnoDB
  default charset UTF8MB4 comment '背景音乐表';


## 视频表
create table `video`
(
    `id`            varchar(64)  not null,
    `user_id`       varchar(64)  not null comment '视频所属人',
    `audio_id`      varchar(64)  not null comment '使用的音频ID',
    `video_desc`    varchar(128) default null comment '视频描述',
    `video_seconds` float(6, 2)  default 0 comment '视频播放的秒数',
    `video-path`    varchar(255) not null comment '视频路径',
    `video-width`   int(6)       not null comment '视频宽度',
    `video_height`  int(6)       not null comment '视频高度',
    `cover_path`    varchar(255) not null comment '视频展示时的封面图片的路径',
    `like_counts`   bigint(20)   default 0 comment '被人喜欢或点赞数',
    `status`        int(1)       default 1 comment '视频状态：1：发布成功 2：禁止播放，管理员操作',
    `create_time`   datetime     default current_timestamp comment '创建时间',
    `update_time`   datetime     default current_timestamp comment '最后一次修改的时间',
    primary key (`id`)
) engine = InnoDB
  default charset UTF8MB4 comment '视频信息表';

## 评论表
create table `comments`
(
    `id`               varchar(64) not null,
    `video_id`         varchar(64) not null comment '评论的视频ID',
    `comments_user_id` varchar(64) not null comment '评论人',
    `content`          text        not null comment '评论内容',
    `create_time`      datetime    not null default current_timestamp comment '评论时间',
    primary key (`id`),
    unique key `user_fans` (`comments_user_id`, video_id)
) engine = InnoDB
  default charset UTF8MB4 comment '留言/背景音乐表';

## 用户-粉丝中间表
create table `user_fans`
(
    `id`      varchar(64) not null,
    `user_id` varchar(64) not null,
    `fans_id` varchar(64) not null,
    primary key (`id`),
    unique key `user_fans_unique` (`user_id`, `fans_id`)
) engine = InnoDB
  default charset UTF8MB4;

## 用户喜欢/收藏的视频中间表
create table `user_like_videos`
(
    `id`       varchar(64) not null,
    `user_id`  varchar(64) not null,
    `video_id` varchar(64) not null,
    primary key (`id`)
) engine = InnoDB
  default charset UTF8MB4 comment '用户喜欢/收藏的视频中间表';

## 用户举报表
create table `user_report`
(
    `id`            varchar(64)  not null,
    `deal_user_id`  varchar(64)  not null comment '被举报人的ID',
    `deal_video_id` varchar(64)  not null comment '被举报的视频ID',
    `user_id`       varchar(64)  not null comment '举报人的ID',
    `title`         varchar(128) not null comment '举报内容的标题',
    `content`       varchar(255) not null comment '举报内容',
    `create_time`   datetime     not null default current_timestamp comment '举报时间',
    primary key (`id`),
    unique key `user_report_video` (`deal_video_id`, `user_id`)
) engine = InnoDB
  default charset UTF8MB4 comment '用户举报视频表';

## 用户搜索记录表，用于创建热搜词，最近搜索词
create table `search_record`
(
    `id`          varchar(64)  not null,
    `content`     varchar(255) not null comment '搜索内容',
    `search_time` datetime     not null default current_timestamp comment '搜索记录产生的时间',
    primary key (`id`)
) engine = InnoDB
  default charset UTF8MB4 comment '用户搜索记录表';
