package com.yunzhi.mybatis.service;

import com.yunzhi.mybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.*;


@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    /**
     * 查询总数
     */
    @Test
    void testCount() {
        long count = this.userService.count();
        System.out.println("count = " + count);
    }

    @Test
    void testSaveBatch() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("yunzhi" + i);
            user.setAge(20 + i);
            list.add(user);
        }
        boolean b = userService.saveBatch(list);
        Assert.isTrue(b, "添加失败");
    }
}