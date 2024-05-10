package com.yunzhi.mybatis.mapper;

import com.yunzhi.mybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class UserMapperTest {

    private static final Logger log = LoggerFactory.getLogger(UserMapperTest.class);
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectList() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    void selectOne() {
        System.out.println(("----- selectAll method test ------"));
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    @Test
    void testInsert() {
        User user = new User();
        user.setAge(23);
        user.setName("lisi");
        user.setEmail("lisi@atguigu.com");
        int result = userMapper.insert(user);
        Assert.isTrue(result > 0, "插入失败");
        System.out.println("id:" + user.getId());
    }

    @Test
    void testDelete() {
        int result = userMapper.deleteById(1787101488624033794L);
        Assert.isTrue(result > 0, "删除失败");
    }

    @Test
    void testDeleteMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", null);
        map.put("age", 23);
        int result = userMapper.deleteByMap(map);
        Assert.isTrue(result > 0, "删除失败");
    }

    @Test
    void testDeleteBatchIds() {
        int result = userMapper.deleteBatchIds(Arrays.asList(1787102740003004417L, 1787102777126682626L));
        Assert.isTrue(result > 0, "删除失败");
    }

    @Test
    void testUpdate() {
        User user = this.userMapper.selectById(1L);
        user.setAge(25);
        int result = this.userMapper.updateById(user);
        Assert.isTrue(result > 0, "更新失败");
    }

    @Test
    void testSelect() {
        User user = this.userMapper.selectById(1L);
        Assert.notNull(user, "用户不存在");

        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        Assert.isTrue(users.toArray().length == 3, "查询失败");
    }

    @Test
    void testSelectMapById() {
        Map<String, Object> map = this.userMapper.selectMapById(1L);
        log.info(map.toString());
    }
}