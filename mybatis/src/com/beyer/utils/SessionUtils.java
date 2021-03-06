package com.beyer.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SessionUtils {
    private static SqlSessionFactoryBuilder builder;
    private static SqlSessionFactory factory;
    static {
        builder = new SqlSessionFactoryBuilder();
        try {
            InputStream stream = Resources.getResourceAsStream("sqlMapConfig.xml");
            factory = builder.build(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession(){
        return factory.openSession();
    }
}
