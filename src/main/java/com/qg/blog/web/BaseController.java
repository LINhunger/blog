package com.qg.blog.web;

import com.qg.blog.model.User;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hunger on 2016/10/21.
 */
public class BaseController {
    public static final String ERROR_MSG_KEY = "errorMsg";

    //1.获取保存在session中的用户对象
    public User getSesstionUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute("user");
    }
    //2.将用户保存到session中
    public void setSessionUser(HttpServletRequest request,User user) {
        request.getSession().setAttribute("user",user);
    }
    //3.获取基于应用程序的url绝对路径
    public final String getAppbaseUrl(HttpServletRequest request,String url) {
        Assert.hasLength(url,"url is null");
        Assert.isTrue(url.startsWith("/"),"url must start with '/'");
        return  request.getContextPath()+url;
    }

}
