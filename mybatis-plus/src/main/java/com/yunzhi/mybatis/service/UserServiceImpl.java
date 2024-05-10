package com.yunzhi.mybatis.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunzhi.mybatis.mapper.UserMapper;
import com.yunzhi.mybatis.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
