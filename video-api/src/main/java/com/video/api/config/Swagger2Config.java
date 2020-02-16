package com.video.api.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.ant;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

/**
 * @author xzmeasy
 * @since 1.0
 **/
@SuppressWarnings("Guava")
@Configuration
public class Swagger2Config {

    @Bean
    public Docket userDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("user-api")
                .select()
                .apis(userApi())
                .paths(userApiPath())
                .build();
    }

    @Bean
    public Docket bgmDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("bgm-api")
                .select()
                .apis(bgmApi())
                .paths(bgmApiPath())
                .build();
    }

    @Bean
    public Docket videoDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("video-api")
                .select()
                .apis(videoApi())
                .paths(videoApiPath())
                .build();
    }

    private Predicate<RequestHandler> videoApi() {
        return basePackage("com.video.api.controller.video");
    }

    private Predicate<RequestHandler> bgmApi() {
        return basePackage("com.video.api.controller.bgm");
    }

    private Predicate<RequestHandler> userApi() {
        return basePackage("com.video.api.controller.user");
    }

    private Predicate<String> videoApiPath() {
        return ant("/**/video/**");
    }

    private Predicate<String> bgmApiPath() {
        return ant("/bgm/**");
    }

    private Predicate<String> userApiPath() {
        return ant("/user/**");
    }

}
