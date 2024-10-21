package com.xa.batch342.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xa.batch342.entities.Category;
import com.xa.batch342.entities.Product;
import com.xa.batch342.services.CategoryService;
import com.xa.batch342.services.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    ProductService productService;
    
    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public ModelAndView getProduct() {
        ModelAndView view = new ModelAndView("product/index");
        List<Product> products = productService.getAllProducts();
        view.addObject("products", products);
        view.addObject("title", "All Product");
        return view;
    }

    @GetMapping("/form")
    public ModelAndView form() {
        ModelAndView view = new ModelAndView("product/form");
        Product product = new Product();
        List<Category> categorys = categoryService.getAllCategorys();
        view.addObject("product", product);
        view.addObject("categorys", categorys);
        return view;
    }
    
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Product product, BindingResult result) {
        if (!result.hasErrors()) {
            productService.saveProduct(product);
        }
        return new ModelAndView("redirect:/product");
    }
    
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        ModelAndView view = new ModelAndView("product/form");
        Product product = productService.getProductById(id);
        List<Category> categorys = categoryService.getAllCategorys();
        view.addObject("product", product);
        view.addObject("categorys", categorys);
        return view;
    }
    
    @GetMapping("/deleteForm/{id}")
    public ModelAndView deleteForm(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView("product/deleteForm");
        Product product = productService.getProductById(id);
        view.addObject("product", product);
        return view;
    }
    
    @GetMapping("/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProductById(id);;
        return new ModelAndView("redirect:/product");
    }
}
