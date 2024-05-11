package com.yunzhi.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunzhi.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author kexiaobin
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    Map<String, Object> selectMapById(Long id);

    Page<User> selectPageVo(@Param("page") Page<User> page,@Param("age") Integer age);
}
