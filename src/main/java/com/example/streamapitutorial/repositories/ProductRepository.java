package com.example.streamapitutorial.repositories;

import com.example.streamapitutorial.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

//    Product findProductByName(String name);
//
//    Product findProductById(Long id);
}
