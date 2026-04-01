# 🍰 Polycake Artisan Patisserie - Backend API

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![SQL Server](https://img.shields.io/badge/SQL_Server-CC292B?style=for-the-badge&logo=microsoft-sql-server&logoColor=white)

## 📖 Giới thiệu dự án
Đây là hệ thống Backend (RESTful API) được xây dựng cho dự án website thương mại điện tử tiệm bánh cao cấp **Polycake**. Hệ thống cung cấp toàn bộ nền tảng dữ liệu và xử lý logic nghiệp vụ cho phía giao diện (Frontend Vue.js), từ quản lý sản phẩm, giỏ hàng, cho đến quy trình thanh toán và phân quyền người dùng.

Dự án được thiết kế theo kiến trúc **MVC (Model-View-Controller)** chuẩn, áp dụng triệt để **DTO Pattern** (Data Transfer Object) để tối ưu hóa luồng dữ liệu truyền tải.
Hệ thống này hoạt động song song với phía giao diện người dùng. Bạn có thể xem mã nguồn Frontend và bản chạy thử tại đây:
* **🖥️ Frontend Repository (Vue.js):** [(https://github.com/hoaibao161108/bakery-management-backend]

## 🚀 Công nghệ sử dụng
* **Ngôn ngữ:** Java 17
* **Framework:** Spring Boot, Spring Web
* **ORM:** Spring Data JPA (Hibernate)
* **Cơ sở dữ liệu:** Microsoft SQL Server
* **Build Tool:** Maven

## 🗄️ Cấu trúc Cơ sở dữ liệu
Hệ thống được thiết kế với 8 bảng quan hệ chặt chẽ:
1. `Roles`: Phân quyền (Admin, Customer).
2. `Users`: Quản lý tài khoản và thông tin khách hàng.
3. `Categories`: Danh mục bánh (Bánh kem, Bánh mì, Đồ uống...).
4. `Products`: Thông tin chi tiết các loại bánh.
5. `Orders`: Hóa đơn tổng quát của khách hàng.
6. `OrderDetails`: Chi tiết từng món bánh trong một hóa đơn.
7. `Reviews`: Hệ thống đánh giá, chấm sao sản phẩm.
8. `Vouchers`: Quản lý mã giảm giá và thời hạn.

## 🔌 Các API Endpoints nổi bật

### 1. Người dùng (Users)
| Method | Endpoint | Mô tả |
| :--- | :--- | :--- |
| `POST` | `/api/users/login` | Xác thực đăng nhập |
| `POST` | `/api/users/register` | Đăng ký tài khoản mới (Check trùng email) |

### 2. Sản phẩm & Danh mục (Products & Categories)
| Method | Endpoint | Mô tả |
| :--- | :--- | :--- |
| `GET` | `/api/categories` | Lấy danh sách toàn bộ danh mục |
| `GET` | `/api/products` | Lấy danh sách toàn bộ sản phẩm (bánh) |

### 3. Đặt hàng & Thanh toán (Orders)
| Method | Endpoint | Mô tả |
| :--- | :--- | :--- |
| `POST` | `/api/orders/checkout` | Nhận DTO Giỏ hàng, lưu đồng thời vào Orders & OrderDetails |

### 4. Đánh giá & Khuyến mãi (Reviews & Vouchers)
| Method | Endpoint | Mô tả |
| :--- | :--- | :--- |
| `GET` | `/api/reviews/product/{id}` | Lấy danh sách bình luận của một sản phẩm |
| `GET` | `/api/vouchers/check/{code}`| Kiểm tra tính hợp lệ và hạn sử dụng của mã giảm giá |

