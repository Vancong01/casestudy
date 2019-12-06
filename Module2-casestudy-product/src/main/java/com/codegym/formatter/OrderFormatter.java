package com.codegym.formatter;

import com.codegym.model.Order;
import com.codegym.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class OrderFormatter implements Formatter<Order> {
    private OrderService orderService;

    @Autowired
    public OrderFormatter(OrderService orderService){
        this.orderService = orderService;
    }


    @Override
    public Order parse(String text, Locale locale) throws ParseException {
        return orderService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Order object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
