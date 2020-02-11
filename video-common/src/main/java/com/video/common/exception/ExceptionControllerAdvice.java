package com.video.common.exception;

import com.video.common.response.ResponseResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler.
 *
 * @author xzmeasy
 * @since 1.0
 **/
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler
    public ResponseResult<Object> resolver(MiniVideoException e) {
        Integer code = e.getCode();
        String message = e.getZhMessage();
        if (StringUtils.isBlank(message)) {
            message = e.getMessage();
        }
        return ResponseResult.error(code, message);
    }

    @ExceptionHandler
    public ResponseResult<Object> resolveOthers(Exception e) {
        return ResponseResult.error(1000, "系统异常");
    }

}
