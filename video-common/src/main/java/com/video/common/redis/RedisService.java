package com.video.common.redis;

import com.video.common.exception.MiniVideoException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author xzmeasy
 * @date 2020/2/2
 */
@Service
public class RedisService {

    private final StringRedisTemplate redisTemplate;

    public RedisService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void set(String key, String value) {
        if (StringUtils.isEmpty(key)) {
            MiniVideoException.canNotBeNull(key);
        }
        if (StringUtils.isEmpty(value)) {
            MiniVideoException.canNotBeNull(value);
        }
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set(key, value);
    }

    public void delete(String key) {
        Boolean delete = redisTemplate.delete(key);
        //noinspection ConstantConditions
        if (!delete) {
            throw new MiniVideoException(1002, "delete failed");
        }
    }
}
