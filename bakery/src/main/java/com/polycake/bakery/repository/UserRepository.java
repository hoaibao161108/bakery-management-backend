package com.polycake.bakery.repository;

import com.polycake.bakery.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // 1. Dùng cho Đăng nhập: Tìm người có đúng Email và Mật khẩu này không?
    User findByEmailAndPasswordHash(String email, String passwordHash);
    User findByUsername(String username);
    // 2. Dùng cho Đăng ký: Kiểm tra xem Email này đã có ai xài chưa?
    boolean existsByEmail(String email);
   
}