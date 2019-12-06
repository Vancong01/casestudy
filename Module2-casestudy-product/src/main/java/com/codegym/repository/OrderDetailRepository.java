package com.codegym.repository;


import com.codegym.model.Order;
import com.codegym.model.Orderdetail;
import com.codegym.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderDetailRepository extends PagingAndSortingRepository<Orderdetail,Long> {
    Iterable<Orderdetail> findAllByOrder(Order order);

    Iterable<Product> findAllByProduct(Product product);
}
