package com.yunzhi.mybatis.mapper;

import com.yunzhi.mybatis.MybatisTApplication;
import com.yunzhi.mybatis.MybatisTApplicationTests;
import com.yunzhi.mybatis.entity.Student;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class DynamicSQLMapperTest {

    @Test
    void test() {
        DynamicSQLMapper mapper = MybatisTApplicationTests.getByMapper(DynamicSQLMapper.class);
        Student student = new Student();
        student.setStudentId(1);
        List<Student> byStudentCondition = mapper.getByStudentCondition(student);
        System.out.println(byStudentCondition);

    }

}