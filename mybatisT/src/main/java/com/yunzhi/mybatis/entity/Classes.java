package com.yunzhi.mybatis.entity;

import lombok.Data;

import java.util.List;

@Data
public class Classes {
    private Integer classId;
    private String className;
    private List<Student> students;
}
