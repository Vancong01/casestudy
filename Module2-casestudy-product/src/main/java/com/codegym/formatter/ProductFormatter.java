package com.codegym.formatter;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class ProductFormatter implements Formatter<Product> {

    private ProductService productService;

    @Autowired
    public ProductFormatter(ProductService productService){
        this.productService = productService;
    }

    @Override
    public Product parse(String text, Locale locale) throws ParseException {
        return productService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Product object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
