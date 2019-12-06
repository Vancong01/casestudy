package com.codegym.service;

import com.codegym.model.Order;
import com.codegym.model.Orderdetail;
import com.codegym.model.Product;

public interface OrderDetailService {
    Iterable<Orderdetail> findAllByOrder(Order order);

    Iterable<Product> findAllByProduct(Product product);
}
