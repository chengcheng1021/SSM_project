package com.cc.ssm.service;

import com.cc.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {

    /**
     * 查找所有订单
     * @return
     * @throws Exception
     */
    List<Orders> findAll(int page, int size) throws Exception;

    /**
     * 根据ID查询
     * @param ordersId
     * @return
     */
    Orders findById(String ordersId) throws Exception;
}
