package com.video.common.generator;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author xzmeasy
 * @since 1.0
 **/
@Component
public class UidGenerator implements IdGenerator {

    @Override
    public synchronized String generate() {
        String s = UUID.randomUUID().toString();
        String replace = s.replace("-", "");
        return replace.toUpperCase() + System.currentTimeMillis();
    }

}
