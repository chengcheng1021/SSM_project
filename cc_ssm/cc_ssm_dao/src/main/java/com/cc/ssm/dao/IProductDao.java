package com.cc.ssm.dao;

import com.cc.ssm.domain.Product;

import java.util.List;

public interface IProductDao {

    /**
     * 查询所有的产品信息
     * @return
     * @throws Exception
     */
    public List<Product> findAll() throws Exception;
}
