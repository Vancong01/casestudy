package com.codegym.controller;

import com.codegym.model.Order;
import com.codegym.model.Product;
import com.codegym.service.CustomerService;
import com.codegym.service.OrderDetailService;
import com.codegym.service.OrderService;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class OrderDetailController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    ProductService productService;


    @ModelAttribute("orders")
    public Iterable<Order> orders(){

        return orderService.findAll();
    }

    @ModelAttribute("products")
    public Iterable<Product> products(){
        return productService.findAll();
    }


    /*
    @GetMapping("/orderdetails")
    public ModelAndView listOrder(){
        Iterable<Order> orders = orderService.findAll();
        ModelAndView modelAndView = new ModelAndView("/order/list");
        modelAndView.addObject("orders",orders);
        return  modelAndView;
    }
    @GetMapping("/create-order")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/order/create");
        modelAndView.addObject("order", new Order());
        return modelAndView;
    }
    @PostMapping("/create-order")
    public ModelAndView saveOrder(@ModelAttribute("order") Order order, RedirectAttributes redirectAttributes){
        orderService.save(order);
        ModelAndView modelAndView = new ModelAndView("redirect:orders");
        redirectAttributes.addFlashAttribute("message","New order create successfully!");
        return modelAndView;
    }
    @GetMapping("/edit-order/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Order order = orderService.findById(id);
        if(order != null) {
            ModelAndView modelAndView = new ModelAndView("/order/edit");
            modelAndView.addObject("order", order);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-order")
    public ModelAndView updateOrder(@ModelAttribute("order") Order order,RedirectAttributes redirectAttributes){
        orderService.save(order);
        ModelAndView modelAndView = new ModelAndView("redirect: orders");
        redirectAttributes.addFlashAttribute("message", "order updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-order/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Order order = orderService.findById(id);
        if(order != null) {
            ModelAndView modelAndView = new ModelAndView("/order/delete");
            modelAndView.addObject("order", order);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-order")
    public String deleteorder(@ModelAttribute("order") Order order,RedirectAttributes redirectAttributes){
        orderService.remove(order.getId());
        redirectAttributes.addFlashAttribute("message", "order delete successfully");
        return "redirect:orders";
    }
    @GetMapping("/view-order")
    public String viewOrder(){
        return "/order/view";
    }
     */
}
