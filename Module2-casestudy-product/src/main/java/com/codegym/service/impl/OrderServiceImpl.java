package com.codegym.service.impl;

import com.codegym.model.Order;
import com.codegym.repository.OrderRepository;
import com.codegym.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findOne(id);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void remove(Long id) {
        orderRepository.delete(id);
    }
}
