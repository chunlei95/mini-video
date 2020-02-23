package com.video.service.service;

import com.video.common.page.PageResult;
import com.video.pojo.vo.video.VideoVo;

/**
 * @author xzmeasy
 * @since 2020/2/23
 */
public interface VideoVoService {

    /**
     * Find {@link VideoVo} by paging pattern.
     *
     * @param pageNum  Which page to search.
     * @param pageSize Count of {@link VideoVo} each page.
     * @return Paging result of {@link VideoVo}.
     */
    PageResult<VideoVo> findAllByPage(int pageNum, int pageSize);
}
