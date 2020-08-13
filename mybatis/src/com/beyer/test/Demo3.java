package com.beyer.test;

import com.beyer.dao.CustomerDao;
import com.beyer.domain.Customer;
import com.beyer.utils.SessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Demo3 {
    @Test
    public void test1(){
        Customer customer = new Customer();
        customer.setName("curry");
        customer.setAge(32);
        customer.setGender("男");
        SqlSession sqlSession = SessionUtils.getSession();
        CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
        dao.saveCustomer(customer);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = SessionUtils.getSession();
        CustomerDao dao = sqlSession.getMapper(CustomerDao.class);
        Customer customer = dao.queryCustomerById(1);
        System.out.println(customer.getName());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3(){
        SqlSession sqlSession = SessionUtils.getSession();
        CustomerDao mapper = sqlSession.getMapper(CustomerDao.class);
        mapper.deleteCustomer(3);
        sqlSession.commit();
        sqlSession.close();
    }
}
