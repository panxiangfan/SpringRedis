package com.yr;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashMap;
import java.util.Map;


public class RedisTest {


    @Test
    public void set(){

        // 获得spring上下文，
        ApplicationContext ctx = new ClassPathXmlApplicationContext("*applicationContext.xml");
        RedisTemplate redisTemplate = (RedisTemplate) ctx.getBean("redisTemplate");
        redisTemplate.opsForValue().set("name","播哦啵啵啵");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

    /**
     * redis存储字符串
     */
    @Test
    public void testString() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("*applicationContext.xml");
        RedisTemplate redisTemplate = (RedisTemplate) ctx.getBean("redisTemplate");
        //-----添加数据----------
        redisTemplate.opsForValue().set("name","cjp");//向key-->name中放入了value-->
        System.out.println(redisTemplate.opsForValue().get("name"));//执行结果：

        redisTemplate.opsForValue().append("name", " is my lover"); //拼接
        System.out.println(redisTemplate.opsForValue().get("name"));

       // redisTemplate.delete("name");  //删除某个键
      //  System.out.println(redisTemplate.opsForValue().get("name"));
        //设置多个键值对

        redisTemplate.opsForValue().set("age","19");
        redisTemplate.opsForValue().increment("age"); //进行加1操作


        System.out.println(redisTemplate.opsForValue().get("name") + "-" + redisTemplate.opsForValue().get("age"));
    }
}
