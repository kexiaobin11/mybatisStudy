package com.yunzhi.mybatis.pojo;

import javax.persistence.*;

/**
 * 表名：classes
*/
@Table(name = "classes")
public class Classes {
    @Id
    @Column(name = "class_id")
    private Integer classId;

    @Column(name = "class_name")
    private String className;

    /**
     * @return classId
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * @param classId
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * @return className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className
     */
    public void setClassName(String className) {
        this.className = className;
    }
}