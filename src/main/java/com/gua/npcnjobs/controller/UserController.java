package com.gua.npcnjobs.controller;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @RequestMapping("/login")
    public String login(String username, String password) {
        if ("root".equals(username) && "root".equals(password)) {

            StpUtil.login(username);
            return "登录成功";
        } else {
            return "登录失败";
        }

    }

    @GetMapping("/isLogin")
    public Boolean isLogin() {
        return StpUtil.isLogin();
    }


}
