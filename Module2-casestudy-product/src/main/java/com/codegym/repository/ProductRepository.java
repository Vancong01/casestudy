package com.codegym.repository;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.model.Supplier;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
    Iterable<Product> findAllByCategory(Category category);

    Iterable<Product> findAllBySupplier(Supplier supplier);

//    Page<Product> findAllByNameContaining(String name, Pageable pageable);
    Page<Product> findAll(Pageable pageable);
}
