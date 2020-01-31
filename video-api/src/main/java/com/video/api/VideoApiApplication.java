package com.video.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author xzmeasy
 */
@EnableSwagger2
@SpringBootApplication(scanBasePackages = "com.video")
@MapperScan("com.video.mapper.mapper")
public class VideoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoApiApplication.class, args);
    }

}
