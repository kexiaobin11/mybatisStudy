package com.yunzhi.mybatis.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunzhi.mybatis.mapper.ProductMapper;
import com.yunzhi.mybatis.mapper.UserMapper;
import com.yunzhi.mybatis.pojo.Product;
import com.yunzhi.mybatis.pojo.User;
import org.springframework.stereotype.Service;

@DS("")
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
