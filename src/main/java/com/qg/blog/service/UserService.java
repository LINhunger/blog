package com.qg.blog.service;

import com.qg.blog.dao.UserDao;
import com.qg.blog.dto.AjaxResult;
import com.qg.blog.dto.RequestResult;
import com.qg.blog.enums.BlogStatEnum;
import com.qg.blog.util.SendCommonPostMail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hunger on 2016/10/19.
 */
@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserDao userDao;

    //md5盐值字符串
    private  final String slat = "livid";

    /**
     *  根据email地址发送邮件
     * @param email
     * @return  包装了返回信息的dto对象
     */
    public RequestResult<String> exportSignUpUrl(String email) {

        if(email == null){
            //抛出异常，邮箱格式错误

        } else {
            int result = SendCommonPostMail.Send(email);
            if (result != 200) {
                //邮件发送失败
            }else {
                return  new RequestResult(BlogStatEnum.SEND_SUCCESS,email);
            }
        }
        return null;
    }

}
