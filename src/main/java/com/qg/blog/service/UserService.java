package com.qg.blog.service;

import com.qg.blog.dao.UserDao;
import com.qg.blog.dto.RequestResult;
import com.qg.blog.enums.BlogStatEnum;
import com.qg.blog.exception.user.*;
import com.qg.blog.model.User;
import com.qg.blog.util.Encryption;
import com.qg.blog.util.SendCommonPostMail;
import com.sun.deploy.nativesandbox.comm.Request;
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


    /**
     *  根据email地址发送邮件
     * @param email
     * @return  包装了返回信息的dto对象
     */
    public RequestResult<String> exportSignUpUrl(String email) {

        if(email == null || !email.matches("\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}")){
            //抛出异常，邮箱格式错误
            throw new SendFormatterException("邮箱格式错误");

        } else {
            int result = SendCommonPostMail.Send(email);
            if (result != 200) {
                throw new UserException("邮件发送失败");
            }else {
                return  new RequestResult(BlogStatEnum.SEND_SUCCESS,email);
            }
        }
    }

    /**
     * 注册用户
     * @param user 用户对象
     * @return 包含用户名的dto对象
     */
    public RequestResult<String> register(User user) {
        if (user == null) {
            throw new RegisterEmptyUserException("空用户对象");
        }
        else if(
                !user.getEmail().matches("\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}") ||
                !user.getName().matches("[a-z0-9A-Z\\u4e00-\\u9fa5]{1,15}") ||
                !user.getPassword().matches("\\w{6,15}") ||
                !user.getIntroduction().matches("\\w+")
                ) {
            throw new RegisterFormatterFaultException("注册信息格式错误");
        }else {
            //加密密码项
            user.setPassword(Encryption.getMD5(user.getPassword()));
            userDao.insertUser(user,"");
            return new RequestResult<String>(BlogStatEnum.REGISTER_SUCESS,user.getEmail());
        }

    }

    /**
     * 用户登录
     * @param user 用户名和密码的集合
     * @return 成功dto,失败抛出异常
     */
    public RequestResult<User> login(User user) {
        if (user == null) {
           throw new LoginMatchException("空用户对象");
        }
        User dbUser = userDao.seclectUser(user.getEmail());
        if (dbUser == null) {
            //不存在的用户
            throw new LoginNotExitUserException("不存在的用户");
        }else if (!dbUser.getPassword().equals(
                Encryption.getMD5(user.getPassword())
        )){
            //用户名或密码错误
            throw new LoginMatchException("错误的用户名或密码");
        }else {
            //登录成功
            return new RequestResult<User>(BlogStatEnum.LOGIN_SUCCESS,dbUser);
        }
    }

}
