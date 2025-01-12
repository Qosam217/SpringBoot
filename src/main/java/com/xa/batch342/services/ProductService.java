package com.xa.batch342.services;

import java.util.List;

import com.xa.batch342.entities.Product;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getProductsByCategotyId(Long id);
    Product saveProduct(Product product);
    Product getProductById(Long id);
    void deleteProductById(Long id);
}
