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
import com.xa.batch342.services.CategoryService;


@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    
    @GetMapping("")
    public ModelAndView getCategory() {
        ModelAndView view = new ModelAndView("category/index");
        List<Category> categories = categoryService.getAllCategorys();
        view.addObject("categories", categories);
        view.addObject("title", "Master Category");
        return view;
    }

    @GetMapping("/form")
    public ModelAndView form() {
        ModelAndView view = new ModelAndView("category/form");
        Category category = new Category();
        view.addObject("category", category);
        return view;
    }
    
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Category category, BindingResult result) {
        if (!result.hasErrors()) {
            categoryService.saveCategory(category);
        }
        return new ModelAndView("redirect:/category");
    }
    
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        ModelAndView view = new ModelAndView("category/form");
        Category category = categoryService.getCategoryById(id);
        view.addObject("category", category);
        return view;
    }
    
    @GetMapping("/deleteForm/{id}")
    public ModelAndView deleteForm(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView("category/deleteForm");
        Category category = categoryService.getCategoryById(id);
        view.addObject("category", category);
        return view;
    }
    
    @GetMapping("/delete/{id}")
    public ModelAndView deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategoryById(id);;
        return new ModelAndView("redirect:/category");
    }
    
}
