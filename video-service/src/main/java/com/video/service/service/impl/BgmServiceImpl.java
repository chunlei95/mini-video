package com.video.service.service.impl;

import com.video.common.exception.ExceptionInfo;
import com.video.common.exception.MiniVideoException;
import com.video.mapper.mapper.BgmMapper;
import com.video.pojo.model.Bgm;
import com.video.service.service.BgmService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author xzmeasy
 * @date 2020/2/14
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class BgmServiceImpl implements BgmService {

    private final BgmMapper bgmMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public BgmServiceImpl(BgmMapper bgmMapper) {
        this.bgmMapper = bgmMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public List<Bgm> bgmList() {
        return bgmMapper.selectAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Bgm add(Bgm bgm) {
        int insert = bgmMapper.insert(bgm);
        if (insert != 1) {
            throw new MiniVideoException(ExceptionInfo.ADD_BGM_FAILED);
        }
        return bgm;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Bgm findById(String bgmId) {
        Bgm bgm = bgmMapper.selectByPrimaryKey(bgmId);
        if (Objects.isNull(bgm)) {
            MiniVideoException.canNotBeNull(bgmId);
        }
        return bgm;
    }

}
