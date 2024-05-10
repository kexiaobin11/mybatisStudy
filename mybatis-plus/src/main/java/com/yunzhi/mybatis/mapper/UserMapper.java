package com.yunzhi.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yunzhi.mybatis.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author kexiaobin
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    Map<String, Object> selectMapById(Long id);
}
