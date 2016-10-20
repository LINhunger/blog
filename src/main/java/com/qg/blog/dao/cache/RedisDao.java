package com.qg.blog.dao.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisPool;

/**
 * Created by hunger on 2016/10/17.
 */
public class RedisDao {
    private JedisPool jedisPool;
    private  final Logger logger = LoggerFactory.getLogger(this.getClass());

    public  RedisDao(String ip,int port){

        jedisPool = new JedisPool(ip,port);
    }
}
