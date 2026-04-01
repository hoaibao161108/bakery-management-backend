package com.polycake.bakery.controller;

import com.polycake.bakery.repository.OrderDetailRepository;
import com.polycake.bakery.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @GetMapping("/overview")
    public ResponseEntity<?> getOverview() {
        Map<String, Object> stats = new HashMap<>();
        
        try {
            // Lấy dữ liệu từ các hàm em vừa viết
            stats.put("totalRevenue", orderRepository.calculateTotalRevenue());
            stats.put("totalOrders", orderRepository.count()); // count() là hàm có sẵn của JPA
            stats.put("totalItems", orderDetailRepository.countTotalItemsSold());
            stats.put("totalCustomers", orderRepository.countTotalCustomers());
            
            return ResponseEntity.ok(stats);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi tính toán thống kê");
        }
    }
}