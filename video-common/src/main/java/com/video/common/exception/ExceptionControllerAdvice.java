package com.video.common.exception;

import com.video.common.response.ResponseResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.naming.SizeLimitExceededException;

/**
 * Global exception handler.
 *
 * @author xzmeasy
 * @since 1.0
 **/
@RestControllerAdvice
public class ExceptionControllerAdvice {

    private final Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ExceptionHandler
    public ResponseResult<Object> resolver(MiniVideoException e) {
        Integer code = e.getCode();
        String message = e.getZhMessage();
        if (StringUtils.isBlank(message)) {
            message = e.getMessage();
        }
        logger.error(e.getMessage(), e);
        return ResponseResult.error(code, message);
    }

    @ExceptionHandler(value = {SizeLimitExceededException.class, MaxUploadSizeExceededException.class})
    public ResponseResult<Object> resolveFileUpload(Exception e) {
        logger.error(e.getLocalizedMessage(), e);
        String message = "文件大小不能超过50MB";
        ExceptionInfo fileSizeLimit = ExceptionInfo.FILE_SIZE_LIMIT;
        fileSizeLimit.setZhMessage(message);
        return ResponseResult.error(fileSizeLimit);
    }

    @ExceptionHandler
    public ResponseResult<Object> resolveOthers(Exception e) {
        logger.error(e.getMessage(), e);
        return ResponseResult.error(1000, "系统异常");
    }

}
