package com.yunzhi.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author kexiaobin
 */
@Data
public class User {
    private Long id;

    private String name;

    private Integer age;

    private String email;
}
