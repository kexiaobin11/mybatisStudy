package com.yunzhi.mybatis.mapper;

import com.yunzhi.mybatis.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.*;
public interface StudentMapper {

    Student getById(@Param("studentId") Integer studentId);

    List<Student> getByClassesId(@Param("class_id") Integer classId);
}
