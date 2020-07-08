package com.cc.ssm.controller;

import com.cc.ssm.domain.Product;
import com.cc.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    /**
     * 产品添加
     * @param product
     */
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        System.out.println(product);
        productService.save(product);
        return "redirect:findAll.do";
    }

    /**
     * 查询全部产品
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        //System.out.println(ps);
        mv.addObject("productList", ps);
        mv.setViewName("product-list1");

        return mv;
    }
}
