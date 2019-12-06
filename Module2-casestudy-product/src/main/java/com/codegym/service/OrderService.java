package com.codegym.service;

import com.codegym.model.Order;

public interface OrderService {
    Iterable<Order> findAll();
    Order findById(Long id);
    void save(Order order);
    void remove(Long id);
}
