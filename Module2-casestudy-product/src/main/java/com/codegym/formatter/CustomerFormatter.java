package com.codegym.formatter;


import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;


@Component
public class CustomerFormatter implements Formatter<Customer> {

    private CustomerService customerService;
    @Autowired
    public CustomerFormatter(CustomerService customerService){
        this.customerService = customerService;
    }

    @Override
    public Customer parse(String text, Locale locale) throws ParseException {
        return customerService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Customer object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
