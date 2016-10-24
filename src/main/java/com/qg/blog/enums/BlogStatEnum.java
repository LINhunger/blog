package com.qg.blog.enums;

/**
 * Created by hunger on 2016/10/19.
 */
public enum BlogStatEnum {

    /**
     * 通用板块
     */
    VALCODE_WRONG(0,"验证码错误"),
    DEFAULT_WRONG(-1,"其他错误"),
    /**
     * 邮箱验证板块
     * */
    SEND_SUCCESS(101,"邮件发送成功"),
    SEND_FORMATTER_FAULT(102,"邮箱格式错误"),
    SEND_FAULT(103,"邮件发送失败"),

    /**
     * 注册板块
     */
    REGISTER_SUCESS(111,"注册成功"),
    REGISTER_EMPTY_USER(112,"空用户对象"),
    REGISTER_FAMMTER_FAULT(113,"注册信息格式错误"),
    REGISTER_CIPHERTEXT_MISMATCH(114,"密文信息不匹配"),
    REGISTER_ALREADY_EXIST(115,"已存在的用户"),

    /**
     * 登录板块
     */
    LOGIN_SUCCESS(121,"登录成功"),
    LOGIN_NOT_EXIT_USER(122,"不存在的用户"),
    LOGIN_USER_MISMATCH(123,"用户名或密码错误");








    private  int state;
    private  String stateInfo;

    BlogStatEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
    public  static  BlogStatEnum statOf(int index) {
        for (BlogStatEnum state : values()) {
            if (state.getState() == index) {
                return  state;
            }
        }
        return  null;
    }
}
