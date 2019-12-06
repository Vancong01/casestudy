package com.codegym.repository;


import com.codegym.model.Customer;
import com.codegym.model.Order;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order,Long> {
    Iterable<Order> findAllByCustomer(Customer customer);
}
