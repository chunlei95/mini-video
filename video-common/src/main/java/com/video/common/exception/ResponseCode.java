package com.video.common.exception;

/**
 * @author xzmeasy
 * @date 2020/2/2
 * @see ExceptionInfo
 * @deprecated
 */
public class ResponseCode {

    /**
     * Status code fo system error.
     */
    public static final Integer SYSTEM_ERROR = 1000;

    /**
     * Status code of key is null.
     */
    public static final Integer CAN_NOT_BE_NULL = 1001;

    /**
     * Status code of delete failed.
     */
    public static final Integer DELETE_FAILED = 1002;

    /**
     * Status code of username or password is not correct.
     */
    public static final Integer USERNAME_OR_PASSWORD_IS_NOT_CORRECT = 1003;

    /**
     * Status code of user is not exist.
     */
    public static final Integer USER_IS_NOT_EXIST = 1004;

}
