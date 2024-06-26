package com.yunzhi.mybatis.mapper;

import com.yunzhi.mybatis.entity.Classes;
import org.apache.ibatis.annotations.Param;

public interface ClassesMapper {

    Classes getById(@Param("class_id") Integer classId);

    Classes getByIdClasses(@Param("class_id") Integer classId);

    Classes getByIdClassesAndStudent(@Param("class_id") Integer classId);
}
