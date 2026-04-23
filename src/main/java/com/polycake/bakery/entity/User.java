package com.polycake.bakery.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Long userId;

    // Đã đổi từ roleId (Long) sang role (String) để khớp với code xử lý role "USER"/"ADMIN"
    @Column(name = "RoleId", length = 20)
    private Long roleId;
    
    @Column(name = "FullName", columnDefinition = "NVARCHAR(100)")
    private String fullName;

    // Thêm trường username để dùng làm tên đăng nhập (khớp với code login/register)
    @Column(name = "Username", length = 50, unique = true)
    private String username;

    @Column(name = "Phone", length = 20)
    private String phone;

    @Column(name = "Email", length = 100)
    private String email;

    // Lưu ý: Biến này em gọi là passwordHash, thầy sẽ tạo thêm setPassword để code Controller dễ gọi
    @Column(name = "PasswordHash", length = 255)
    private String passwordHash;

    @Column(name = "Address", columnDefinition = "NVARCHAR(255)")
    private String address;

    @Column(name = "IsActive")
    private Boolean isActive;

    // --- CONSTRUCTOR ---
    public User() {
    }

    // --- GETTER / SETTER ---

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    
    // Thêm hàm này để Controller gọi .setPassword() cho tiện
    public void setPassword(String password) {
        this.passwordHash = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}