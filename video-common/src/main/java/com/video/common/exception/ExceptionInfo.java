package com.video.common.exception;

/**
 * @author xzmeasy
 * @date 2020/2/14
 */
public enum ExceptionInfo {

    /**
     * Exception info of add bgm failed
     */
    ADD_BGM_FAILED(1005, "bgm add failed", "背景音乐添加失败");

    private Integer code;

    private String message;

    private String zhMessage;

    ExceptionInfo(int code, String message, String zhMessage) {
        this.code = code;
        this.message = message;
        this.zhMessage = zhMessage;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getZhMessage() {
        return zhMessage;
    }

}
