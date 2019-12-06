package com.codegym.controller;


import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.model.Supplier;
import com.codegym.service.CategoryService;
import com.codegym.service.ProductService;
import com.codegym.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    SupplierService supplierService;

    @Autowired
    CategoryService categoryService;

    @ModelAttribute("suppliers")
    public Iterable<Supplier> suppliers(){
        return supplierService.findAll();
    }
    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/products")
    public ModelAndView listProduct(){
        //Page<Product> products = productService.findAll(pageable);

        Iterable<Product> products = productService.findAll();
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products",products);
        return  modelAndView;
    }

//    @GetMapping("/products")
//    public ModelAndView listProduct(){
//        Iterable<Product> products = productService.findAll();
//        ModelAndView modelAndView = new ModelAndView("/product/list");
//        modelAndView.addObject("products",products);
//        return  modelAndView;
//    }

    @GetMapping("/create-product")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }
    @PostMapping("/create-product")
    public ModelAndView saveProduct(@ModelAttribute("product") Product product,RedirectAttributes redirectAttributes){
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("redirect:products");
        redirectAttributes.addFlashAttribute("message","New product create successfully!");
        return modelAndView;
    }
    @GetMapping("/edit-product/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Product product = productService.findById(id);
        if(product != null) {
            ModelAndView modelAndView = new ModelAndView("/product/edit");
            modelAndView.addObject("product", product);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-product")
    public String updateProduct(@ModelAttribute("product") Product product,RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "product updated successfully");
        return "redirect: products";
    }
    @GetMapping("/delete-product/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Product product = productService.findById(id);
        if(product != null) {
            ModelAndView modelAndView = new ModelAndView("/product/delete");
            modelAndView.addObject("product", product);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-product")
    public String deleteProduct(@ModelAttribute("product") Product product,RedirectAttributes redirectAttributes){
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("message", "product delete successfully");
        return "redirect:products";
    }
    @GetMapping("/view-product")
    public String viewProduct(){
        return "/product/view";
    }

}
