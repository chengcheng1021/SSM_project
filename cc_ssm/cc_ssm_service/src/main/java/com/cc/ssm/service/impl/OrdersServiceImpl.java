package com.cc.ssm.service.impl;

import com.cc.ssm.dao.IOrdersDao;
import com.cc.ssm.domain.Orders;
import com.cc.ssm.service.IOrdersService;
import com.github.pagehelper.PageHelper;
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
    public List<Orders> findAll(int page, int size) throws Exception {
        // 参数 pageNum 是页码值，参数 pageSize 代表是每页显示条数
        PageHelper.startPage(page, size);
        return ordersDao.findAll();
    }

    /**
     * 根据ID查询
     *
     * @param ordersId
     * @return
     */
    @Override
    public Orders findById(String ordersId) throws Exception {
        return ordersDao.findById(ordersId);
    }
}
