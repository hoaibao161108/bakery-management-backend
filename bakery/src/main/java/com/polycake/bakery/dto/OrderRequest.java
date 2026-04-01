package com.polycake.bakery.dto;

import java.math.BigDecimal;
import java.util.List;

public class OrderRequest {
    
    // --- 1. Thông tin chung của đơn hàng ---
    private Long customerId;
    private String shippingAddress;
    private BigDecimal totalAmount;
    
    // --- 2. Danh sách các món bánh trong giỏ ---
    private List<CartItem> cartItems;

    // --- GETTER & SETTER ---
    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public String getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }

    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }

    public List<CartItem> getCartItems() { return cartItems; }
    public void setCartItems(List<CartItem> cartItems) { this.cartItems = cartItems; }

    // ========================================================= //
    // Class con mô tả từng món bánh trong giỏ
    public static class CartItem {
        private Long productId;
        private Integer quantity;
        private BigDecimal price;

        public Long getProductId() { return productId; }
        public void setProductId(Long productId) { this.productId = productId; }

        public Integer getQuantity() { return quantity; }
        public void setQuantity(Integer quantity) { this.quantity = quantity; }

        public BigDecimal getPrice() { return price; }
        public void setPrice(BigDecimal price) { this.price = price; }
    }
}