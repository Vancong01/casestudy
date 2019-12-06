package com.codegym.service.impl;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.model.Supplier;
import com.codegym.repository.ProductRepository;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.delete(id);
    }

    @Override
    public Iterable<Product> findAllByCategory(Category category) {
        return productRepository.findAllByCategory(category);
    }

    @Override
    public Iterable<Product> findAllBySupplier(Supplier supplier) {
        return productRepository.findAllBySupplier(supplier);
    }

//    @Override
//    public Page<Product> findAllByNameContaining(String name, Pageable pageable) {
//        return productRepository.findAllByNameContaining(name,pageable);
//    }

//    @Override
//    public Page<Product> findAll(Pageable pageable) {
//        return productRepository.findAll(pageable);
//    }
}
