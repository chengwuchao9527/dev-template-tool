package com.cheng.controller;

import com.cheng.dao.UserDAO;
import com.cheng.domain.UserDO;
import com.cheng.exception.BadRequestException;
import com.cheng.exception.EntityExistException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试服务接口
 * @author chengwuchao
 * @date 2022/3/18
 */
@RestController
@RequestMapping("/test/api")
@Api(value = "测试服务", tags = "测试服务")
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/redis-serialize")
    public void testRedisSerialize(){
        UserDO user = new UserDO();
        user.setId(1L);
        user.setName("张三");
        redisTemplate.opsForHash().put(1, "user", user);

        UserDO user1 = (UserDO) redisTemplate.opsForHash().get(1, "user");
        System.out.println(user1);

        redisTemplate.opsForValue().set("test-key", "测试");
        String test = (String)redisTemplate.opsForValue().get("test-key");
        System.out.println(test);
    }

    @GetMapping("/test-exception")
    public void testGlobalException(Integer test){
        throw new EntityExistException(UserDO.class, "id", "23");
    }

    @GetMapping("/test-mysql")
    public void testMysql(){
        for (int i = 1; i < 10000; i++) {
            UserDO user = new UserDO();
            user.setName("张" + i);
            user.setAge(i);
            user.initCreateParam(1L);
            userDAO.save(user);
        }
    }
}
