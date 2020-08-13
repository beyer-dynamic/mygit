package com.beyer.test;

import com.beyer.domain.User;
import com.beyer.utils.SessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Demo2 {
    @Test
    public void test1(){
        SqlSession sqlSession = SessionUtils.getSession();
        User user = new User();
        user.setName("飞鲨");
        user.setPassword("j15");
        sqlSession.insert("insertUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = SessionUtils.getSession();
        List<User> list = sqlSession.selectList("queryAllUser");
        for (User user : list) {
            System.out.println(user.getName());
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3(){
        SqlSession sqlSession = SessionUtils.getSession();
        User user = sqlSession.selectOne("queryUserById", 3);
        System.out.println(user.getName());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test4(){
        SqlSession sqlSession = SessionUtils.getSession();
        sqlSession.delete("deleteUser",2);
        sqlSession.commit();
        sqlSession.close();
    }
}
