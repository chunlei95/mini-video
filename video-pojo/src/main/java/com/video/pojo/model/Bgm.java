package com.video.pojo.model;

import lombok.Data;

/**
 * @author xzmeasy
 * @date 2020/1/20
 */
@Data
public class Bgm {

    private String id;

    /**
     * The author of background music.
     */
    private String author;

    /**
     * The name of background music.
     */
    private String name;

    /**
     * The access path of background music.
     */
    private String path;

}