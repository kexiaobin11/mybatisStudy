package com.yunzhi.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yunzhi.mybatis.mapper.UserMapper;
import com.yunzhi.mybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class UserWrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void testSelectList() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "a")
                .between("age", 20, 30).isNotNull("email");

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);

    }

    @Test
    void testSelect() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.orderByDesc("age").orderByAsc("id");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    void testDelete() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int result = userMapper.delete(queryWrapper);
        System.out.println("result:" + result);
    }

    @Test
    void testUpdate() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "a")
                .and(user -> user.gt("age", 20).or().isNull("email"));

        User user = new User();
        user.setName("yunzhi");
        user.setEmail("test@t.com");
        int update = userMapper.update(user, queryWrapper);
        System.out.println(update);
    }

    @Test
    void testSelectFile() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name", "age", "email");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
    }

    @Test
    void testSelectByGeId() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("id", "select id from user where id <= 100");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    void testUpdateByIdAndIdGTOrEmailIsNull() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("name", "yunzhi")
                .and(i -> i.gt("age", 20).or().isNotNull("email"));
        updateWrapper.set("name", "yunzhi.club").set("email", "yunzhi.club@163.com");
        int update = userMapper.update(updateWrapper);
        System.out.println(update + "update");
    }
}
