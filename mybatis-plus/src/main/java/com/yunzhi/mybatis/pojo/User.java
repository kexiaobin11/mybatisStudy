package com.yunzhi.mybatis.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yunzhi.mybatis.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author kexiaobin
 */
@Data
@TableName("t_user")
public class User {
    private Long id;

    private String name;

    private Integer age;

    private String email;

    // 逻辑删除
    @TableLogic
    private Integer isDeleted;

    private SexEnum sex;
}
