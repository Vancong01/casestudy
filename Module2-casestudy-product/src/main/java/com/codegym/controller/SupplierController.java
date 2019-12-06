package com.codegym.controller;


import com.codegym.model.Supplier;
import com.codegym.service.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SupplierController {
    @Autowired
    SupplierService  supplierService;
    @GetMapping("/suppliers")
    public ModelAndView listSupplier(){
        Iterable<Supplier> suppliers = supplierService.findAll();
        ModelAndView modelAndView = new ModelAndView("/supplier/list");
        modelAndView.addObject("suppliers",suppliers);
        return  modelAndView;
    }
    @GetMapping("/create-supplier")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/supplier/create");
        modelAndView.addObject("supplier", new Supplier());
        return modelAndView;
    }
    @PostMapping("/create-supplier")
    public String saveSupplier(@ModelAttribute("supplier") Supplier supplier, RedirectAttributes redirectAttributes){
        supplierService.save(supplier);
        redirectAttributes.addFlashAttribute("message","New supplier create successfully!");
        return ("redirect:suppliers");
    }
    @GetMapping("/edit-supplier/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Supplier supplier = supplierService.findById(id);
        if(supplier != null) {
            ModelAndView modelAndView = new ModelAndView("/supplier/edit");
            modelAndView.addObject("supplier", supplier);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-supplier")
    public String updateSupplier(@ModelAttribute("supplier") Supplier supplier,RedirectAttributes redirectAttributes){
        supplierService.save(supplier);
        redirectAttributes.addFlashAttribute("message", "supplier updated successfully");
        return ("redirect: suppliers");
    }
    @GetMapping("/delete-supplier/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Supplier supplier = supplierService.findById(id);
        if(supplier != null) {
            ModelAndView modelAndView = new ModelAndView("/supplier/delete");
            modelAndView.addObject("supplier", supplier);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-supplier")
    public String deleteSupplier(@ModelAttribute("supplier") Supplier supplier,RedirectAttributes redirectAttributes){
        supplierService.remove(supplier.getId());
        redirectAttributes.addFlashAttribute("message", "supplier delete successfully");
        return "redirect:suppliers";
    }
    @GetMapping("/view-supplier")
    public String viewSupplier(){
        return "/supplier/view";
    }
}
