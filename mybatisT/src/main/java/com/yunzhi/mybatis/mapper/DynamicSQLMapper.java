package com.yunzhi.mybatis.mapper;

import com.yunzhi.mybatis.entity.Student;

import java.util.List;

public interface DynamicSQLMapper {

    List<Student> getByStudentCondition(Student student);
}
