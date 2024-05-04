package com.yunzhi.mybatis.mapper;

import com.yunzhi.mybatis.entity.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {

    Student getById(@Param("studentId") Integer studentId);
}
