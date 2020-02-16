package com.video.service.service;

import com.video.pojo.model.Video;

/**
 * @author xzmeasy
 * @since 2020/2/15
 */
public interface VideoService {

    /**
     * Upload video
     *
     * @param uploadVideo {@link Video}.
     * @return {@link Video}.
     */
    Video add(Video uploadVideo);
}
