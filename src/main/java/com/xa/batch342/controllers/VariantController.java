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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xa.batch342.entities.Category;
import com.xa.batch342.entities.Product;
import com.xa.batch342.entities.Variant;
import com.xa.batch342.services.CategoryService;
import com.xa.batch342.services.ProductService;
import com.xa.batch342.services.VariantService;



@Controller
@RequestMapping("/variant")
public class VariantController {
    
    @Autowired
    VariantService variantService;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public ModelAndView getVariant() {
        ModelAndView view = new ModelAndView("variant/index");
        List<Variant> variants = variantService.getAllVariants();
        view.addObject("title", "Variant");
        view.addObject("variants", variants);
        return view;
    }

    @GetMapping("/form")
    public ModelAndView form() {
        ModelAndView view = new ModelAndView("variant/form");
        List<Category> categorys = categoryService.getAllCategorys();
        Variant variant = new Variant();
        view.addObject("categorys", categorys);
        view.addObject("variant", variant);
        return view;
    }

    @GetMapping("/products-by-category/{categoryId}")
    @ResponseBody
    public List<Product> getProductsByCategory(@PathVariable Long categoryId) {
        return productService.getProductsByCategotyId(categoryId);
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Variant variant, BindingResult result) {
        if(!result.hasErrors()){
            variantService.saveVariant(variant);
        }
        return new ModelAndView("redirect:/variant");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView("variant/form");
        Variant variant = variantService.getVariantById(id);
        List<Category> categorys = categoryService.getAllCategorys();
        view.addObject("categorys", categorys);
        view.addObject("variant", variant);
        return view;
    }

    @GetMapping("/deleteForm/{id}")
    public ModelAndView deleteForm(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView("variant/deleteForm");
        Variant variant = variantService.getVariantById(id);
        view.addObject("variant", variant);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteVariant(@PathVariable("id") Long id) {
        variantService.deleteVariantById(id);
        return new ModelAndView("redirect:/variant");
    } 
}
