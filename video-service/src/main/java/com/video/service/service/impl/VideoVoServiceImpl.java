package com.video.service.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.video.common.page.PageResult;
import com.video.mapper.mapper.VideoVoMapper;
import com.video.pojo.vo.video.VideoVo;
import com.video.service.service.VideoVoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xzmeasy
 * @since 2020/2/23
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class VideoVoServiceImpl implements VideoVoService {

    private final VideoVoMapper videoVoMapper;

    public VideoVoServiceImpl(VideoVoMapper videoVoMapper) {
        this.videoVoMapper = videoVoMapper;
    }

    @Override
    public PageResult<VideoVo> findAllByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<VideoVo> videoVoList = videoVoMapper.selectAll();
        PageInfo<VideoVo> pageInfo = new PageInfo<>(videoVoList);
        return PageResult.from(pageInfo);
    }
}
