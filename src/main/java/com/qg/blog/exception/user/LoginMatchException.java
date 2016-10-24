package com.qg.blog.exception.user;

/**
 * Created by hunger on 2016/10/24.
 */
public class LoginMatchException extends RuntimeException {


    public LoginMatchException(String message) {
        super(message);
    }

    public LoginMatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
