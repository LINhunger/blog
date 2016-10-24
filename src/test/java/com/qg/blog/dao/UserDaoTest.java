package com.qg.blog.dao;

import com.qg.blog.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by hunger on 2016/10/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit Spring 配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {


    @Resource
    private UserDao userDao;
    @Test
    public void insertUser() throws Exception {
        User user = new User("linhunger","466400960@qq.com","livid",0,"wo xuan ni");
        int insertCount = userDao.insertUser(user,"livid");
        System.out.println("insertCount=  "+insertCount);
    }
    @Test
    public void seclectUser() throws Exception {
        User user =userDao.seclectUser("983214067@qq.com");
        System.out.println("insertCount=  "+user);
    }

}