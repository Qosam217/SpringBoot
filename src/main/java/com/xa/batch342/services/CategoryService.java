package com.xa.batch342.services;

import java.util.List;

import com.xa.batch342.entities.Category;


public interface CategoryService {
    List<Category> getAllCategorys();
    Category saveCategory(Category category);
    Category getCategoryById(Long id);
    void deleteCategoryById(Long id);
}
