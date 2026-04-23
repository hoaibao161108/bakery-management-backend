package com.polycake.bakery.controller;

import com.polycake.bakery.entity.Voucher;
import com.polycake.bakery.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/vouchers")
public class VoucherController {

    @Autowired
    private VoucherRepository voucherRepository;

    // API Kiểm tra mã giảm giá có hợp lệ không
    @GetMapping("/check/{code}")
    public ResponseEntity<?> checkVoucher(@PathVariable String code) {
        Voucher voucher = voucherRepository.findByVoucherCode(code);
        
        if (voucher == null) {
            return ResponseEntity.badRequest().body("Mã giảm giá không tồn tại!");
        }
        
        // Kiểm tra xem mã đã hết hạn chưa
        if (voucher.getExpiryDate().isBefore(LocalDate.now())) {
            return ResponseEntity.badRequest().body("Mã giảm giá đã hết hạn!");
        }
        
        return ResponseEntity.ok(voucher);
    }
}