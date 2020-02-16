package com.video.common;

/**
 * @author xzmeasy
 * @since 2020/2/15
 */
public enum VideoStatus {

    /**
     * Status of upload video success.
     */
    UPLOAD_SUCCESS(1),

    /**
     * Status of prohibit play.
     */
    PROHIBIT_PLAY(2);

    private int code;

    VideoStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
