package com.polycake.bakery.repository;

import com.polycake.bakery.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {
    // Tìm mã giảm giá theo tên Code khách nhập vào (VD: "GIAM20K")
    Voucher findByVoucherCode(String voucherCode);
}