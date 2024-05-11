package com.yunzhi.mybatis;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunzhi.mybatis.mapper.UserMapper;
import com.yunzhi.mybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisPlusPluginsTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void testPage() {
        Page<User> page = new Page<>();
        page.setSize(2);
        page.setPages(0);
        userMapper.selectPage(page, null);
        System.out.println(page);
    }

    @Test
    void testPageDetail() {
        Page<User> page = new Page<>(1, 3);
        userMapper.selectPage(page, null);
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }

    @Test
    void testPageVo() {
        Page<User> page = new Page<>(1, 2);
        userMapper.selectPageVo(page, 20);
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }
}
