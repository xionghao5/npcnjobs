package com.gua.npcnjobs.dao;

import lombok.Data;

import java.util.Date;

@Data
public class SysUser {
    private Long id;
    private String username;
    private String password;
    private boolean deleted;
    private Date registTime;
}
