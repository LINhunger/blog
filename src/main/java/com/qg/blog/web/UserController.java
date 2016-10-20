package com.qg.blog.web;

import com.qg.blog.dto.RequestResult;
import com.qg.blog.model.User;
import com.qg.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hunger on 2016/10/20.
 */
@Controller
@RequestMapping("/ggblog/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String send(Model model) {
        logger.info("form  invoke:");
        return  "emailSend";
    }
    @RequestMapping(value = "/verification",method = RequestMethod.POST)
    public String verify(User user,Model model) {
        if (user.getEmail() == null) {
            logger.warn("verification  fail");
            return "redirect:/index.jsp";
        }else {
            RequestResult<String> result = userService.exportSignUpUrl(user.getEmail());
            model.addAttribute("result", result);
            logger.info("verification  invoke"+user.getEmail());
            return "emailReact";
        }

    }
}
