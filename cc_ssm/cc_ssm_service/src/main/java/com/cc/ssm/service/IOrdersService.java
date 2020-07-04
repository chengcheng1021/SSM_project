package com.cc.ssm.service;

import com.cc.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {

    /**
     * 查找所有订单
     * @return
     * @throws Exception
     */
    List<Orders> findAll() throws Exception;
}
