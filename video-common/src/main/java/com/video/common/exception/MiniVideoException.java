package com.video.common.exception;

/**
 * Global exception type.
 *
 * @author xzmeasy
 * @since 1.0
 **/
@SuppressWarnings("unused")
public class MiniVideoException extends RuntimeException {

    /**
     * Error code.
     */
    Integer code;

    /**
     * Error message displayed in Chinese.
     */
    String zhMessage;

    /**
     * Constructor only has a message in English.
     *
     * @param message English message.
     */
    public MiniVideoException(String message) {
        super(message);
    }

    public MiniVideoException(String message, String zhMessage) {
        super(message);
        this.zhMessage = zhMessage;
    }

    public MiniVideoException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public MiniVideoException(Integer code, String message, String zhMessage) {
        super(message);
        this.code = code;
        this.zhMessage = zhMessage;
    }

    public static void canNotBeNull(String key) {
        String message = key + " can't be null";
        String zhMessage = key + "不能为空";
        throw new MiniVideoException(ResponseCode.CAN_NOT_BE_NULL, message, zhMessage);
    }

    public static void deleteFailed() {
        String message = "delete failed";
        String zhMessage = "删除失败";
        throw new MiniVideoException(ResponseCode.DELETE_FAILED, message, zhMessage);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getZhMessage() {
        return zhMessage;
    }

    public void setZhMessage(String zhMessage) {
        this.zhMessage = zhMessage;
    }
}
