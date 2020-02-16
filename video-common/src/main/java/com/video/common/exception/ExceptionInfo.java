package com.video.common.exception;

/**
 * @author xzmeasy
 * @date 2020/2/14
 */
public enum ExceptionInfo {

    /**
     * Exception info that user is not exist.
     */
    USER_NOT_EXIST(1004, "user is not exist", "不存在该用户"),

    /**
     * Exception info that upload bgm fail.
     */
    ADD_BGM_FAILED(1005, "bgm add failed", "背景音乐添加失败"),

    /**
     * Exception info that upload video fail.
     */
    VIDEO_UPLOAD_FAILED(1006, "video upload failed", "视频上传失败"),

    /**
     * Exception info that file size limit.
     */
    FILE_SIZE_LIMIT(1007, "file size limit", "文件大小超过限制");


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

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setZhMessage(String zhMessage) {
        this.zhMessage = zhMessage;
    }
}
