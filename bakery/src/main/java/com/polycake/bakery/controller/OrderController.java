package com.polycake.bakery.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polycake.bakery.dto.OrderRequest;
import com.polycake.bakery.entity.Order;
import com.polycake.bakery.entity.OrderDetail;
import com.polycake.bakery.repository.OrderDetailRepository;
import com.polycake.bakery.repository.OrderRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @PostMapping("/checkout")
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequest request) {
        try {
            // Bước 1: Tạo Đơn hàng chính (Order) và lưu xuống SQL
            Order order = new Order();
            order.setCustomerId(request.getCustomerId());
            order.setOrderDate(LocalDateTime.now());
            order.setTotalAmount(request.getTotalAmount());
            order.setShippingAddress(request.getShippingAddress());
            order.setStatus("Chờ xác nhận"); // Đơn mới luôn ở trạng thái này
            
            Order savedOrder = orderRepository.save(order);

            // Bước 2: Lấy danh sách bánh, lưu từng cái vào Chi tiết (OrderDetails)
            for (OrderRequest.CartItem item : request.getCartItems()) {
                OrderDetail detail = new OrderDetail();
                detail.setOrderId(savedOrder.getOrderId()); // Nối với ID của đơn hàng vừa tạo ở trên
                detail.setProductId(item.getProductId());
                detail.setQuantity(item.getQuantity());
                detail.setPriceAtTime(item.getPrice());
                
                orderDetailRepository.save(detail);
            }

            return ResponseEntity.ok("Đặt hàng thành công! Mã đơn của bạn là: " + savedOrder.getOrderId());

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi khi đặt hàng: " + e.getMessage());
        }
    }
    @GetMapping("/user/{customerId}")
    public ResponseEntity<?> getUserOrders(@PathVariable Long customerId) {
        try {
            // Tìm tất cả đơn hàng của User này, sắp xếp cái mới nhất lên đầu
            List<Order> orders = orderRepository.findByCustomerIdOrderByOrderDateDesc(customerId);
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Không thể lấy danh sách đơn hàng");
        }
    }
 // API Lấy danh sách bánh (Chi tiết) của 1 đơn hàng
    @GetMapping("/{orderId}/details")
    public ResponseEntity<?> getOrderDetails(@PathVariable Long orderId) {
        try {
            // Cần đảm bảo orderDetailRepository có hàm findByOrderId(Long orderId) nhé
            List<OrderDetail> details = orderDetailRepository.findByOrderId(orderId);
            return ResponseEntity.ok(details);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi lấy chi tiết đơn hàng");
        }
    }
 // 1. API lấy TẤT CẢ đơn hàng trong hệ thống (Dành cho Admin)
    @GetMapping("/all")
    public ResponseEntity<?> getAllOrders() {
        try {
            // Em cần thêm hàm findAllByOrderByOrderDateDesc() vào OrderRepository nhé
            List<Order> orders = orderRepository.findAllByOrderByOrderDateDesc();
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi lấy danh sách đơn hàng");
        }
    }

    // 2. API Cập nhật trạng thái đơn hàng (Duyệt đơn)
    @PutMapping("/{orderId}/status")
    public ResponseEntity<?> updateOrderStatus(@PathVariable Long orderId, @RequestBody String newStatus) {
        try {
            Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đơn hàng"));
            
            order.setStatus(newStatus);
            orderRepository.save(order);
            
            return ResponseEntity.ok("Cập nhật trạng thái thành công!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi cập nhật trạng thái");
        }
    }
}