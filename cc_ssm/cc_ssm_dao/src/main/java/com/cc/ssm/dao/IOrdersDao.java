package com.cc.ssm.dao;

import com.cc.ssm.domain.Orders;

import java.util.List;

public interface IOrdersDao {

    /**
     * 查询所有订单
     * @return
     */
    List<Orders> findAll() throws Exception;
}
