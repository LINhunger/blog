package com.qg.blog.exception.user;

/**
 * 验证码异常
 * Created by hunger on 2016/10/24.
 */
public class ValcodeWrongException extends RuntimeException{

    public ValcodeWrongException(String message) {
        super(message);
    }

    public ValcodeWrongException(String message, Throwable cause) {
        super(message, cause);
    }

}
