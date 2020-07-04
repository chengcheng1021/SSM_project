package com.cc.ssm.service.impl;

import com.cc.ssm.dao.IOrdersDao;
import com.cc.ssm.domain.Orders;
import com.cc.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    /**
     * 查找所有订单
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Orders> findAll() throws Exception {
        return ordersDao.findAll();
    }
}
