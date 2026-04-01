package com.polycake.bakery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.polycake.bakery.entity.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    // Hàm tìm tất cả chi tiết của 1 đơn hàng cụ thể
    List<OrderDetail> findByOrderId(Long orderId);
 // 3. Tính tổng số lượng bánh đã bán ra
    @Query("SELECT COALESCE(SUM(od.quantity), 0) FROM OrderDetail od")
    Long countTotalItemsSold();
}