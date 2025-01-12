package com.xa.batch342.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xa.batch342.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    // Native Query
    // @Query(value = "select * from spring.products where is_deleted = false", nativeQuery = true)
    // List<Product> getAllProducts();

    // Hibernate Query
    @Query(value = "select p from Product p")
    List<Product> getAllProducts();

    @Query(value = "select p from Product p where categoryId = :id")
    List<Product> getAllProductsByCategory(@Param("id") Long id);
}
