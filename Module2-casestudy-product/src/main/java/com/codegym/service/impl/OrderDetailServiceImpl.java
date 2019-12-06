package com.codegym.service.impl;

import com.codegym.model.Order;
import com.codegym.model.Orderdetail;
import com.codegym.model.Product;
import com.codegym.repository.OrderDetailRepository;
import com.codegym.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailRepository  orderDetailRepository;

    @Override
    public Iterable<Orderdetail> findAllByOrder(Order order) {
        return orderDetailRepository.findAllByOrder(order);
    }

    @Override
    public Iterable<Product> findAllByProduct(Product product) {
        return orderDetailRepository.findAllByProduct(product);
    }
}
