package com.qg.blog.web;

import com.qg.blog.dto.RequestResult;
import com.qg.blog.enums.BlogStatEnum;
import com.qg.blog.exception.user.*;
import com.qg.blog.model.User;
import com.qg.blog.service.UserService;
import com.qg.blog.util.Encryption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.Flags;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by hunger on 2016/10/20.
 */
@Controller
@RequestMapping("/ggblog/user")
public class UserController extends BaseController{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/{ciphertext}/form",method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request,@PathVariable("ciphertext") String ciphertext) {
        String text = Encryption.getMD5(request.getParameter("email"));
        if (ciphertext == null || !ciphertext.equals(text)) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("redirect:/index.jsp");
            return  mav;
        }else {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("register");
            mav.addObject("email",request.getParameter("email"));
            mav.addObject("ciphertext",ciphertext);
            logger.info("form  invoke:");
            return mav;
        }

    }

    /**
     * 用于邮箱格式验证并且发送邮件
     * @param user 用户对象
     * @param request 请求对象
     * @return dto对象
     */
    @RequestMapping(value = "/verification",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<String> send(User user, HttpServletRequest request) {
        try {
            verify(request);
            RequestResult<String> result = userService.exportSignUpUrl(user.getEmail());
            logger.info("verification  invoke and email has already been sent.\t"+user.getEmail());
            return result;
        } catch (ValcodeWrongException e) {
            logger.warn("valcode is wrong.\t"+user.getEmail());
            return  new RequestResult<>(BlogStatEnum.VALCODE_WRONG,user.getEmail());
        } catch (SendFormatterException e) {
            logger.warn("wrong email fomatter.\t"+user.getEmail());
            return  new RequestResult<>(BlogStatEnum.SEND_FORMATTER_FAULT,user.getEmail());
        }catch (UserException e) {
            logger.warn("default exception.\t");
            return  new RequestResult<>(BlogStatEnum.SEND_FAULT,user.getEmail());
        }
    }

    /**
     * 验证验证码
     * @param request 请求对象
     * @return  正确返回true ,错误抛出异常
     */
    private boolean verify(HttpServletRequest request) {
        boolean flag = false;
        String valcode = (String)request.getSession().getAttribute("valcode");
        if(valcode == null || !valcode.equalsIgnoreCase(
                request.getParameter("valcode")
        )) {
            throw new ValcodeWrongException("验证码错误");
        }else {
            flag = true;
            logger.info("valcode is right");
            return flag;
        }
    }


    @RequestMapping("/login")
    @ResponseBody
    public RequestResult<User> signIn(HttpServletRequest request,User user) {

        try {
         /*   verify(request);*/
            RequestResult<User> result = userService.login(user);
            return result;
        }catch (ValcodeWrongException e) {
            logger.warn("valcode is wrong.\t"+user.getEmail());
            return  new RequestResult<User>(BlogStatEnum.VALCODE_WRONG,null);
        }catch (LoginNotExitUserException e) {
            logger.warn("not exit user.\t"+user.getEmail());
            return  new RequestResult<User>(BlogStatEnum.LOGIN_NOT_EXIT_USER,null);
        }catch (LoginMatchException e) {
            logger.warn("Incorrect username or password.\t"+user.getEmail());
            return  new RequestResult<User>(BlogStatEnum.LOGIN_USER_MISMATCH,null);
        }
    }

    /**
     * 注册
     * @param request 请求对象
     * @param user 用户对象
     * @return dto对象
     */
    @RequestMapping(value = "/{ciphertext}/register",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<String> register(HttpServletRequest request,User user,
                                          @PathVariable("ciphertext") String ciphertext) {
        String text = Encryption.getMD5(user.getEmail());
        if (ciphertext == null || !ciphertext.equals(text)) {
            logger.warn("wrong acess way");
            RequestResult<String> result = new RequestResult<>(BlogStatEnum.REGISTER_CIPHERTEXT_MISMATCH);
            return result;
        }
        //注册用户
        try {
            verify(request);//验证验证码
            RequestResult<String> result = userService.register(user);
            return result;
        } catch (ValcodeWrongException e) {
            logger.warn("valcode is wrong.\t"+user.getEmail());
            return  new RequestResult<>(BlogStatEnum.VALCODE_WRONG,user.getEmail());
        }catch (RegisterEmptyUserException e) {
            logger.warn("empty user.\t"+user.getEmail());
            return  new RequestResult<>(BlogStatEnum.REGISTER_EMPTY_USER,user.getEmail());
        }catch (RegisterFormatterFaultException e) {
            logger.warn("wrong formatter.\t"+user.getEmail());
            return  new RequestResult<>(BlogStatEnum.REGISTER_FAMMTER_FAULT,user.getEmail());
        }catch (DataIntegrityViolationException e) {//主键重复异常
            logger.warn("user is already exist.\t"+user.getEmail());
            return  new RequestResult<>(BlogStatEnum.REGISTER_ALREADY_EXIST,user.getEmail());
        }
    }
}

