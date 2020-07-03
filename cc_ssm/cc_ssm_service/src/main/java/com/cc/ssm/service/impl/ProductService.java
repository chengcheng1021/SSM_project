package com.cc.ssm.service.impl;

import com.cc.ssm.dao.IProductDao;
import com.cc.ssm.domain.Product;
import com.cc.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService implements IProductService {

    @Autowired
    private IProductDao productDao;

    /**
     * 查询所有产品
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }
}