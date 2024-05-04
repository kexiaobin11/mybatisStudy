package com.yunzhi.mybatis.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String password;
    private String username;
    private String email;
    private Integer age;
}
