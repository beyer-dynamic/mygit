package com.beyer.dao;

import com.beyer.domain.Customer;

public interface CustomerDao {
    /*保存用户数据*/
    public void saveCustomer(Customer customer);

    /*根据id查询用户信息*/
    public Customer queryCustomerById(Integer id);

    /*根据id删除用户*/
    public void deleteCustomer(Integer id);

}
