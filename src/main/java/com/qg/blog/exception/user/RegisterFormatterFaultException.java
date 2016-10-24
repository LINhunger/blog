package com.qg.blog.exception.user;

/**
 * Created by hunger on 2016/10/21.
 */
public class RegisterFormatterFaultException extends  RuntimeException {
    public RegisterFormatterFaultException(String message) { super(message); }

    public RegisterFormatterFaultException(String message, Throwable cause) {
        super(message, cause);
    }
}
