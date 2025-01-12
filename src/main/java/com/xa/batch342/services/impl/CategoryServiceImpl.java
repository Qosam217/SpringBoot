package com.xa.batch342.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xa.batch342.entities.Category;
import com.xa.batch342.repositories.CategoryRepository;
import com.xa.batch342.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategorys() {
        return categoryRepository.getAllCategorys();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    
    @Override
    public Category getCategoryById(Long id){
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCategoryById(Long id){
        Category category = categoryRepository.findById(id).orElse(null);
        categoryRepository.deleteById(category.getId());
    }
}
