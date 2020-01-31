package com.video.common.exception;

/**
 * @author xzmeasy
 * @since 1.0
 **/
public class MiniVideoException extends RuntimeException {

    private Integer code;

    public MiniVideoException(String message) {
        super(message);
    }

    public MiniVideoException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
