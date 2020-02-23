package com.video.mapper.mapper;

import com.video.pojo.vo.video.VideoVo;

import java.util.List;

/**
 * @author xzmeasy
 * @since 2020/2/23
 */
@SuppressWarnings("JavadocReference")
public interface VideoVoMapper {

    /**
     * Search {@link VideoVo} by primary key.
     *
     * @param primaryKey {@link VideoVo#id}.
     * @return {@link VideoVo} that with specific primary key.
     */
    VideoVo selectByPrimaryKey(String primaryKey);

    /**
     * Find all {@link VideoVo}s.
     *
     * @return List of {@link VideoVo}.
     */
    List<VideoVo> selectAll();

}
