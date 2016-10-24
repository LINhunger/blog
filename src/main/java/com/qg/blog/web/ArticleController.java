package com.qg.blog.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hunger on 2016/10/24.
 */
@Controller
@RequestMapping("ggblog/article")
public class ArticleController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/article",method = RequestMethod.GET)
    public ModelAndView findArticle(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("article");
        return  mav;
    }
}
