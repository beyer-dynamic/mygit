package com.beyer.test;

import com.beyer.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Demo {
    public static void main(String[] args)throws Exception {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        User user = new User();
        user.setName("闪电");
        user.setPassword("f35");
        sqlSession.insert("insertUser",user);
        sqlSession.commit();
        sqlSession.close();
    }
}
