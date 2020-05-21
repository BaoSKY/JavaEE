package com.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MybatisUtil {

    public static SqlSessionFactory sessionFactory;
    static {
        try{
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static SqlSession getSession(){
        return sessionFactory.openSession();
    }
}
