package com.qg.blog.dao;

import com.qg.blog.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by hunger on 2016/10/17.
 */
public interface UserDao {

        /**
         * 查找用户
         * @param user
         * @param invcode
         * @return
         */
        int insertUser(@Param("user") User user,@Param("invcode") String invcode);

        /**
         * 根据邮箱查找用户
         * @param emailOrName 邮箱或用户名
         * @return  用户对象
         */
        User seclectUser(@Param("emailOrName")String emailOrName);


}
