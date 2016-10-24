package com.qg.blog.exception.user;

/**
 * Created by hunger on 2016/10/21.
 */
public class RegisterEmptyUserException extends RuntimeException{
    public RegisterEmptyUserException(String message) { super(message); }

    public RegisterEmptyUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
