package com.polycake.bakery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.polycake.bakery.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Hàm tìm tất cả đơn hàng của 1 khách hàng cụ thể
	// EM DÁN DÒNG NÀY VÀO ĐÂY ĐỂ GIẢI CỨU LỖI ĐỎ:
    List<Order> findByCustomerIdOrderByOrderDateDesc(Long customerId);
    List<Order> findAllByOrderByOrderDateDesc();
 // 1. Tính tổng doanh thu (Chỉ cộng tiền những đơn 'Đã hoàn thành')
    @Query("SELECT COALESCE(SUM(o.totalAmount), 0) FROM Order o WHERE o.status = 'Đã hoàn thành'")
    Double calculateTotalRevenue();

    // 2. Đếm số lượng khách hàng thực tế (Mỗi người chỉ đếm 1 lần)
    @Query("SELECT COUNT(DISTINCT o.customerId) FROM Order o")
    Long countTotalCustomers();
}