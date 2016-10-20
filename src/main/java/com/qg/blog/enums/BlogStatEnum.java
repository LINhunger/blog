package com.qg.blog.enums;

/**
 * Created by hunger on 2016/10/19.
 */
public enum BlogStatEnum {

    /**
     * 邮箱验证板块
     * */
    SEND_SUCCESS(101,"邮件发送成功"),
    EMAIL_FORMATTER_FAULT(102,"邮箱格式错误"),
    SEND_FAULT(103,"邮件发送失败");



/*    INNER_ERROR(-2,"系统异常"),
    DATA_REWRITE(-3,"数据篡改");*/




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
