package com.codegym.service;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Iterable<Product> findAll();
    Product findById(Long id);
    void save(Product product);
    void remove(Long id);

    Iterable<Product> findAllByCategory(Category category);

    Iterable<Product> findAllBySupplier(Supplier supplier);

//    Page<Product> findAllByNameContaining(String name, Pageable pageable);
    //Page<Product> findAll(Pageable pageable);

}
