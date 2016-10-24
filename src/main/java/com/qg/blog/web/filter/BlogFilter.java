package com.qg.blog.web.filter;

import com.mysql.jdbc.StringUtils;
import com.qg.blog.model.User;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by hunger on 2016/10/21.
 */
public class BlogFilter implements Filter {

    private static final String FILTERED_REQUEST = "@@session_context_filtered_request";
    //1.不需要登录即可以访问的URI资源
    private  static final String[] ENTER_ESCAPE_URIS ={
        "/index.jsp",
        "index.html",

    };


    //2.执行过滤
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException,ServletException {
        //2.1 保证该过滤器在一次请求中只被调用一次
        if (request != null && request.getAttribute(FILTERED_REQUEST) != null) {
            chain.doFilter(request,response);
        }else {
            //2.2 设置过滤标识，防止一次请求多次过滤
            request.setAttribute(FILTERED_REQUEST,Boolean.TRUE);
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            User userContext = (User)httpServletRequest.getSession().getAttribute("user");//user可能需要用常量定义

            //2.3 用户未登录，且当前URI资源需要登录才能访问
            if (userContext == null && isURILogin(httpServletRequest.getRequestURI(),httpServletRequest)) {
                String toUrl = httpServletRequest.getRequestURL().toString();
                if(!StringUtils.isEmptyOrWhitespaceOnly(httpServletRequest.getQueryString())) {
                    toUrl += "?"+httpServletRequest.getQueryString();
                }
                //2.4 将用户的请求URL保存到session中，用于登录成功之后，跳到目标URL
                httpServletRequest.getSession().setAttribute("toUrl",toUrl);//LOGIN_TO_URL
                //2.5转发跳转到登录界面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
                return;
            }
            chain.doFilter(request,response);
        }
    }


    //3 当前URI资源是否需要登录才能访问
    private boolean isURILogin(String requestURI,HttpServletRequest request) {
        if (request.getContextPath().equalsIgnoreCase(requestURI)
                || (request.getContextPath()+"/").equalsIgnoreCase(requestURI)) {
            return  true;
        }
        for (String uri : ENTER_ESCAPE_URIS) {
            if (requestURI != null && requestURI.indexOf(uri)>=0) {
                return  true ;
            }
        }
        return false;
    }





    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void destroy() {

    }
}
