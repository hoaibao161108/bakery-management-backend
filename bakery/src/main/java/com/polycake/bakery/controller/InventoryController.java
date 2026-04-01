package com.polycake.bakery.controller;

import com.polycake.bakery.entity.Product;
import com.polycake.bakery.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private ProductRepository productRepository;

    // API: Lấy toàn bộ sản phẩm để hiển thị trong Kho Hàng
    @GetMapping
    public ResponseEntity<?> getAllInventory() {
        try {
            List<Product> products = productRepository.findAll();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi lấy danh sách kho hàng");
        }
    }
}