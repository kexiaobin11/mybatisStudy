package com.yunzhi.mybatis.entity;

import lombok.Data;

@Data
public class Student {
    private Integer studentId;
    private String studentName;
    private Classes classes;
}
