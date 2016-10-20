package com.qg.blog.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by hunger on 2016/10/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit Spring 配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class UserServiceTest {
    private  final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private  UserService userService;
    @Test
    public void exportSignUpUrl() throws Exception {
        userService.exportSignUpUrl("983214067@qq.com");
    }

}