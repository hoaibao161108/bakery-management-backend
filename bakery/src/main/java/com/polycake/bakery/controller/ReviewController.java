package com.polycake.bakery.controller;

import com.polycake.bakery.entity.Review;
import com.polycake.bakery.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    // Lấy danh sách đánh giá của 1 sản phẩm
    @GetMapping("/product/{productId}")
    public List<Review> getReviewsByProduct(@PathVariable Long productId) {
        return reviewRepository.findByProductId(productId);
    }

    // Thêm đánh giá mới
    @PostMapping
    public ResponseEntity<?> addReview(@RequestBody Review newReview) {
        newReview.setCreatedAt(LocalDateTime.now());
        Review savedReview = reviewRepository.save(newReview);
        return ResponseEntity.ok(savedReview);
    }
}