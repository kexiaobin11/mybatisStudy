package com.yunzhi.mybatis.mapper;

import com.yunzhi.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    int insertUser();

    User getUserById();

    List<User> getAll();

    User getUserByUsername(String username);

    User login(@Param("username") String username, @Param("password") String password);

    int saveUser(User user);
}
