package com.yunzhi.mybatis.mapper;

import com.yunzhi.mybatis.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class  ProductMapperTest {
    @Autowired
    private ProductMapper productMapper;

    @Test
    void testProduct() {
        Product product = productMapper.selectById(1L);
        System.out.println("小李查询的商品价格：" + product.getPrice());
        Product productWang = productMapper.selectById(1L);
        System.out.println("小王查询的商品价格：" + productWang.getPrice());
        product.setPrice(product.getPrice() + 50);
        productMapper.updateById(product);
        productWang.setPrice(productWang.getPrice() - 30);
        int result = productMapper.updateById(productWang);
        if (result == 0) {
            // 操作失败，重试
           Product productNew = productMapper.selectById(1L);
           productNew.setPrice(productNew.getPrice() - 30);
           productMapper.updateById(productNew);
        }
        Product productBoss =  productMapper.selectById(1L);
        System.out.println("boss查询的商品价格：" + productBoss.getPrice());
    }

    @Test
    void testProduct02() {
    }
}