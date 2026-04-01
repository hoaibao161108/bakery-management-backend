package com.polycake.bakery.repository;

import com.polycake.bakery.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Để trống trơn như thế này thôi! 
    // Spring Boot đã tự động viết sẵn cho em hàm Thêm, Sửa, Xóa, Tìm kiếm ngầm bên dưới rồi.
}