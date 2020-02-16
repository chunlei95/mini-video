package com.video.service.service.impl;

import com.video.common.exception.ExceptionInfo;
import com.video.common.exception.MiniVideoException;
import com.video.mapper.mapper.VideoMapper;
import com.video.pojo.model.Video;
import com.video.service.service.VideoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xzmeasy
 * @since 2020/2/15
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class VideoServiceImpl implements VideoService {

    private final VideoMapper videoMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public VideoServiceImpl(VideoMapper videoMapper) {
        this.videoMapper = videoMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Video add(Video uploadVideo) {
        int insert = videoMapper.insert(uploadVideo);
        if (insert != 1) {
            throw new MiniVideoException(ExceptionInfo.VIDEO_UPLOAD_FAILED);
        }
        return videoMapper.selectByPrimaryKey(uploadVideo.getId());
    }
}
