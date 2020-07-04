package com.cc.ssm.service.impl;

import com.cc.ssm.dao.IProductDao;
import com.cc.ssm.domain.Product;
import com.cc.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

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

    /**
     * 保存产品
     * @param product
     * @throws Exception
     */
    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }
}
