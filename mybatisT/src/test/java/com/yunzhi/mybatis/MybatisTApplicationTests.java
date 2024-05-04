package com.yunzhi.mybatis;

import com.yunzhi.mybatis.entity.Student;
import com.yunzhi.mybatis.entity.User;
import com.yunzhi.mybatis.mapper.StudentMapper;
import com.yunzhi.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootTest
class MybatisTApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.insertUser();
        System.out.println(result);
    }

    @Test
    void getAll() throws IOException {
        UserMapper mapper = this.getMapper();
        List<User> all = mapper.getAll();
        all.forEach(System.out::println);
    }

    @Test
    void getByUsername() throws IOException {
        UserMapper mapper = this.getMapper();
        User user = mapper.getUserByUsername("user1");
        System.out.println(user);
    }

    @Test
    void login() throws IOException {
        UserMapper mapper = this.getMapper();
        User user = mapper.login("user1", "password1");
        System.out.println(user);
    }

    @Test
    void saveUser() {
        UserMapper mapper = this.getMapper();
        User user = new User();
        user.setUsername("yunzhi");
        user.setPassword("yunzhi");
        user.setEmail("14@163.com");
        user.setAge(20);
        mapper.saveUser(user);
    }

    @Test
    void testStudent() {
        StudentMapper studentMapper = this.getMapperAll(StudentMapper.class);

        Student byId = studentMapper.getById(1);
        System.out.println(byId);
    }

    UserMapper getMapper() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
            SqlSession sqlSession = build.openSession(true);
            return sqlSession.getMapper(UserMapper.class);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    <T> T getMapperAll(Class<T> t) {
         try {
             InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
             SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
             SqlSession sqlSession = build.openSession(true);
             return sqlSession.getMapper(t);
         } catch (Exception e) {
             throw new RuntimeException(e);
         }
    }
}
