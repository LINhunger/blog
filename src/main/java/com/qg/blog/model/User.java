package com.qg.blog.model;

import java.util.Date;

/**
 * Created by hunger on 2016/10/19.
 */
public class User {

    //昵称
    private String name;
    //邮箱
    private String email;
    //密码
    private String password;
    //角色
    private int role;
    //个人简介
    private String introduction;
    //注册时间
    private Date createtime;

    public User(){};
    public User(String name, String email, String password, int role, String introduction) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.introduction = introduction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", introduction='" + introduction + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
