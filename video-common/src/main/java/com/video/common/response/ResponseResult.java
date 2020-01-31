package com.video.common.response;

import lombok.Data;

/**
 * Define global response data structure
 *
 * @author xzmeasy
 * @since 1.0
 **/
@Data
public class ResponseResult {

    private Integer code;

    private String message;

    private Object data;

    private ResponseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private ResponseResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResponseResult ok() {
        return new ResponseResult(200, "success");
    }

    public static ResponseResult ok(Object data) {
        return new ResponseResult(200, "success", data);
    }

}
