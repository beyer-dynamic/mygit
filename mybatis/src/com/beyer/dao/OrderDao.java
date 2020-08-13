package com.beyer.dao;

import com.beyer.domain.Order;

import java.util.List;

public interface OrderDao {
    public List<Order> queryOrderUserResultMap();
}
