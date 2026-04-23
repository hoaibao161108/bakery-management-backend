package com.polycake.bakery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polycake.bakery.entity.User;
import com.polycake.bakery.repository.UserRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ================= API ĐĂNG KÝ ================= //
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User newUser) {
        // Kiểm tra xem email đã bị trùng chưa
        if (userRepository.existsByEmail(newUser.getEmail())) {
            return ResponseEntity.badRequest().body("Email này đã được sử dụng!");
        }
        
        // Thiết lập mặc định cho người mới
        newUser.setRoleId(2L); // 2 là mã của Khách hàng (theo Database của em)
        newUser.setIsActive(true);
        
        // Lưu xuống SQL Server
        userRepository.save(newUser);
        return ResponseEntity.ok("Đăng ký thành công!");
    }

    // ================= API ĐĂNG NHẬP ================= //
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginUser) {
        // Xuống Database tìm người khớp email và password
        User user = userRepository.findByEmailAndPasswordHash(loginUser.getEmail(), loginUser.getPasswordHash());
        
        if (user != null) {
            return ResponseEntity.ok(user); // Thành công thì trả về thông tin người đó
        } else {
            return ResponseEntity.badRequest().body("Sai email hoặc mật khẩu!");
        }
    }

    }