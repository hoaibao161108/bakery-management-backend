package com.polycake.bakery.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "OrderDetails")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderDetailID")
    private Long orderDetailId;

    @Column(name = "OrderID")
    private Long orderId; // Chi tiết này thuộc về hóa đơn nào?

    @Column(name = "ProductID")
    private Long productId; // Khách mua bánh gì?

    @Column(name = "Quantity")
    private Integer quantity; // Số lượng bao nhiêu?

    @Column(name = "PriceAtTime", precision = 18, scale = 2)
    private BigDecimal priceAtTime; // Giá bánh ngay tại thời điểm mua

    // --- GETTER & SETTER --- //
    public OrderDetail() {}

    public Long getOrderDetailId() { return orderDetailId; }
    public void setOrderDetailId(Long orderDetailId) { this.orderDetailId = orderDetailId; }

    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public BigDecimal getPriceAtTime() { return priceAtTime; }
    public void setPriceAtTime(BigDecimal priceAtTime) { this.priceAtTime = priceAtTime; }
}