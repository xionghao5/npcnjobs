package com.gua.npcnjobs.redis;

import com.gua.npcnjobs.dao.SysUser;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RedisControllerTest {


    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void test1() {
        ResponseEntity<SysUser> responseEntity = testRestTemplate.getForEntity("/redis/test", SysUser.class);
        SysUser sysUser = responseEntity.getBody();
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(sysUser.getUsername(), "spring boot");
    }

    @Test
    void getList() {
        SysUser[] sysUserArray = testRestTemplate.getForObject("/redis/getList", SysUser[].class);
        Assert.assertEquals(sysUserArray.length, 2);
        List<SysUser> sysUserList = Arrays.asList(sysUserArray);
        Assert.assertEquals(sysUserList.get(0).getUsername(),"spring boot");
    }
}