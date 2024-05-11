package com.yunzhi.mybatisplus.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.yunzhi.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author blur
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-05-12 01:06:53
* @Entity com.yunzhi.mybatisplus.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {
    int insertSelective(User user);

    int deleteById(@Param("id") Long id);

    int deleteByIdAndName(@Param("id") Long id, @Param("name") String name);

    int updateAgeAndNameById(@Param("age") Integer age, @Param("name") String name, @Param("id") Long id);

    List<User> selectAgeAndSexByAgeBetween(@Param("beginAge") Integer beginAge, @Param("endAge") Integer endAge);

    List<User> selectAllOrderByAgeDesc();
}




