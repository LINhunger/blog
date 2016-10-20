package com.qg.blog.dao;

import com.qg.blog.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by hunger on 2016/10/17.
 */
public interface UserDao {

        /**
         * 添加用户
        * */
        int insertUser(@Param("user") User user,@Param("invcode") String invcode);
}
