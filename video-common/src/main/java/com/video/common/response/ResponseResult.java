package com.video.common.response;

import lombok.Data;

/**
 * Define global response data structure
 *
 * @author xzmeasy
 * @since 1.0
 **/
@Data
public class ResponseResult<T> {

    private Integer code;

    private String message;

    private T data;

    private ResponseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private ResponseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseResult<T> ok() {
        return new ResponseResult<T>(200, "请求成功");
    }

    public static <T> ResponseResult<T> ok(T data) {
        return new ResponseResult<T>(200, "请求成功", data);
    }

    public static <T> ResponseResult<T> error(Integer code, String message) {
        return new ResponseResult<T>(code, message);
    }

    public static <T> ResponseResult<T> error(Integer code, String message, T data) {
        return new ResponseResult<T>(code, message, data);
    }

}
