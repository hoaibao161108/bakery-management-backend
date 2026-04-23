package com.polycake.bakery.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Vouchers")
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VoucherID")
    private Long voucherId;

    @Column(name = "VoucherCode", length = 50)
    private String voucherCode;

    @Column(name = "DiscountValue", precision = 18, scale = 2)
    private BigDecimal discountValue;

    @Column(name = "ExpiryDate")
    private LocalDate expiryDate;

    @Column(name = "MinOrderValue", precision = 18, scale = 2)
    private BigDecimal minOrderValue;

    // --- GETTER & SETTER --- //
    public Voucher() {}

    public Long getVoucherId() { return voucherId; }
    public void setVoucherId(Long voucherId) { this.voucherId = voucherId; }

    public String getVoucherCode() { return voucherCode; }
    public void setVoucherCode(String voucherCode) { this.voucherCode = voucherCode; }

    public BigDecimal getDiscountValue() { return discountValue; }
    public void setDiscountValue(BigDecimal discountValue) { this.discountValue = discountValue; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    public BigDecimal getMinOrderValue() { return minOrderValue; }
    public void setMinOrderValue(BigDecimal minOrderValue) { this.minOrderValue = minOrderValue; }
}