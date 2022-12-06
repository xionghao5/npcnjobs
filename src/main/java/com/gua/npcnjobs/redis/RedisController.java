package com.gua.npcnjobs.redis;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.gua.npcnjobs.dao.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate strRedis;

    @Autowired
    private StringRedisOperator redis;

    @RequestMapping("/test")
    public SysUser test() {
        SysUser user = new SysUser();
        user.setId(100111L);
        user.setUsername("spring boot");
        user.setPassword("abc123");
        user.setDeleted(false);
        user.setRegistTime(new Date());
        strRedis.opsForValue().set("json:user",JSON.toJSONString(user));
        String s = redis.get("json:user");
        return JSON.parseObject(s,SysUser.class);
    }

    @RequestMapping("/getList")
    public List<SysUser> getList() {

        SysUser user = new SysUser();
        user.setId(100111L);
        user.setUsername("spring boot");
        user.setPassword("abc123");
        user.setDeleted(false);
        user.setRegistTime(new Date());

        SysUser u1 = new SysUser();
        u1.setId(2L);
        u1.setUsername("fuck");
        u1.setPassword("fuck you");
        u1.setDeleted(false);
        u1.setRegistTime(new Date());

        List<SysUser> userList = new ArrayList<>();
        userList.add(user);
        userList.add(u1);

        redis.set("json:info:userlist", JSON.toJSONString(userList), 5);

        String userListJson = redis.get("json:info:userlist");

        return JSON.parseArray(userListJson,SysUser.class);
    }
}