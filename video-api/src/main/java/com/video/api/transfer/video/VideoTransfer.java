package com.video.api.transfer.video;

import com.video.pojo.dto.video.VideoUploadDto;
import com.video.pojo.model.Video;
import org.springframework.beans.BeanUtils;

/**
 * Transform other objects to {@link Video} or
 * transform {@link Video}
 * to other objects.
 *
 * @author xzmeasy
 * @since 2020/2/15
 */
public class VideoTransfer {

    /**
     * Transform {@link VideoUploadDto} to {@link Video}.
     *
     * @param videoUploadDto {@link VideoUploadDto}.
     * @return {@link Video}.
     */
    public static Video transformFromVideoUploadDto(VideoUploadDto videoUploadDto) {
        Video video = new Video();
        BeanUtils.copyProperties(videoUploadDto, video);
        return video;
    }


}
