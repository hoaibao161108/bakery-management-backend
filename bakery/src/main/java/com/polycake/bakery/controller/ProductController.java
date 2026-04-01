package com.polycake.bakery.controller;

import com.polycake.bakery.entity.Product;
import com.polycake.bakery.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // API này tương đương với câu lệnh: SELECT * FROM Products
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}