package com.video.api.transfer.bgm;

import com.video.pojo.dto.bgm.BgmAddDto;
import com.video.pojo.model.Bgm;
import org.springframework.beans.BeanUtils;

/**
 * Transform other objects to {@link Bgm} or
 * transform {@link Bgm}
 * to other objects.
 *
 * @author xzmeasy
 * @since 2020/2/15
 */
public class BgmTransfer {

    /**
     * Transform {@link BgmAddDto} to {@link Bgm}.
     *
     * @param bgmAddDto {@link BgmAddDto}
     * @return {@link Bgm}
     */
    public static Bgm transformFromBgmAddDto(BgmAddDto bgmAddDto) {
        Bgm bgm = new Bgm();
        BeanUtils.copyProperties(bgmAddDto, bgm);
        return bgm;
    }

}
