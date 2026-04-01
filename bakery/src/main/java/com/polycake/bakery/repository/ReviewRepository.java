package com.polycake.bakery.repository;

import com.polycake.bakery.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Tự động tìm tất cả bình luận theo ID của cái bánh
    List<Review> findByProductId(Long productId);
}