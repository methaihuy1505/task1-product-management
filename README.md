# Product Management System (Spring Boot CRUD)

Dự án xây dựng hệ thống quản lý sản phẩm cơ bản, áp dụng kiến trúc phân tầng (Layered Architecture) của **Spring Framework**. Hệ thống hỗ trợ quản lý toàn bộ vòng đời của sản phẩm từ lúc khởi tạo đến khi lưu trữ vào cơ sở dữ liệu MySQL.

---

## Chức năng chính (Core Functions)

Ứng dụng cung cấp các tác vụ quản lý dữ liệu (CRUD) thiết yếu với giao diện trực quan:

* **Xem danh sách**: Liệt kê toàn bộ sản phẩm hiện có trong hệ thống với đầy đủ thông tin.
* **Thêm mới**: Giao diện form nhập liệu linh hoạt, hỗ trợ mapping dữ liệu thông qua DTO.
* **Chỉnh sửa**: Cập nhật thông tin sản phẩm dựa trên định danh duy nhất (ID) qua Path Variable.
* **Xóa sản phẩm**: Loại bỏ dữ liệu khỏi hệ thống kèm theo thông báo xác nhận từ phía người dùng.

---

## Tech-stack

* **Backend:** Java 17, Spring Boot 4.0.4, Spring Data JPA (Hibernate)
* **Database:** MySQL 8.0
* **Frontend:** Thymeleaf (Template Engine)
* **UI Framework:** Bootstrap 5 (Responsive Design)
* **Build Tool:** Maven

---

## Cấu trúc dự án (Project Structure)

Dự án được tổ chức theo mô hình phân lớp để đảm bảo tính minh bạch và dễ bảo trì:

* `controller`: Tiếp nhận request từ Client và điều hướng giao diện.
* `service`: Xử lý logic nghiệp vụ và chuyển đổi dữ liệu giữa DTO và Entity.
* `repository`: Tầng trừu tượng giao tiếp với cơ sở dữ liệu qua JPA.
* `model`: Định nghĩa thực thể (Entity) ánh xạ trực tiếp với bảng `product`.
* `request`: Chứa các Data Transfer Objects (DTO) để tối ưu hóa và bảo mật dữ liệu truyền tải.

---

## Giao diện ứng dụng (Screenshots)

| Product Management Page |
| :---: |
| ![Homepage](https://github.com/methaihuy1505/task1-product-management/raw/main/images/producManagementPage.png) |

---

## Hướng dẫn cài đặt và Khởi chạy

### 1. Chuẩn bị Cơ sở dữ liệu
* Tạo một database mới trong MySQL với tên: `vti`
* Hệ thống sử dụng chế độ `update`, tự động khởi tạo bảng dữ liệu khi ứng dụng khởi chạy.

### 2. Cấu hình ứng dụng
Mở file `src/main/resources/application.properties` và điều chỉnh các thông số kết nối:

```properties
spring.application.name=product-management
spring.datasource.url=jdbc:mysql://localhost:3306/vti
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update

# Đảm bảo mapping chính xác tên cột (productId, proName...)
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
