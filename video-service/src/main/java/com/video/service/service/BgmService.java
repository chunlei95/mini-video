package com.video.service.service;

import com.video.pojo.model.Bgm;

import java.util.List;

/**
 * @author xzmeasy
 * @date 2020/2/14
 */
public interface BgmService {

    /**
     * Find all {@link Bgm}.
     *
     * @return If exist, return bgm list, otherwise, return a empty list.
     */
    List<Bgm> bgmList();

    /**
     * Add a {@link Bgm}
     *
     * @param bgm {@link Bgm}
     * @return {@link Bgm} added.
     */
    Bgm add(Bgm bgm);

    /**
     * Find {@link Bgm} by id.
     *
     * @param bgmId Bgm id.
     * @return {@link Bgm} that has specified id.
     */
    Bgm findById(String bgmId);
}
