package com.video.common.generator;

import java.util.UUID;

/**
 * @author xzmeasy
 * @since 1.0
 **/
public class UidGenerator implements IdGenerator {
    @Override
    public synchronized String generate() {
        String s = UUID.randomUUID().toString();
        String replace = s.replace("-", "");
        return replace.toUpperCase() + System.currentTimeMillis();
    }

    public static String generateId() {
        IdGenerator idGenerator = new UidGenerator();
        return idGenerator.generate();
    }

    public static void main(String[] args) {
        System.out.println(UidGenerator.generateId());
    }

}
