# **ProductOptionController**

## **Mô tả**
`ProductOptionController` cung cấp các API để quản lý các tùy chọn sản phẩm trong hệ thống, bao gồm các tính năng: tạo, lấy chi tiết, cập nhật, xóa và liệt kê tất cả các tùy chọn sản phẩm.

---

## **Các Endpoint**

### **1. Lấy tất cả các tùy chọn sản phẩm**
- **URL**: `/api/product-options`
- **Phương thức**: `GET`
- **Mô tả**: Lấy danh sách tất cả các tùy chọn sản phẩm.
- **Response**:
  ```json
  [
    {
      "id": "12345",
      "name": "Tùy chọn 1",
      "description": "Mô tả tùy chọn 1"
    },
    {
      "id": "67890",
      "name": "Tùy chọn 2",
      "description": "Mô tả tùy chọn 2"
    }
  ]
### 2. **Lấy tùy chọn sản phẩm theo ID**
- **URL**: `/api/product-options/{id}`
- **Phương thức**: `GET`
- **Mô tả**: Lấy chi tiết tùy chọn sản phẩm theo ID.
- **Request**:
- `id`: ID của tùy chọn sản phẩm.
- **Response**:
    ```json
    {
      "id": "12345",
      "name": "Tùy chọn 1",
      "description": "Mô tả tùy chọn 1"
    }
    
### 3. **Tạo mới một tùy chọn sản phẩm**
- **URL**: `/api/product-options`
- **Phương thức**: `POST`
- **Mô tả**: Tạo mới một tùy chọn sản phẩm.
- **Request**:
    ```json
    {
      "name": "Tùy chọn mới",
      "description": "Mô tả tùy chọn mới"
    }
- **Response**:
    ```json
    {
      "id": "12345",
      "name": "Tùy chọn mới",
      "description": "Mô tả tùy chọn mới"
    }
### 4. **Cập nhật tùy chọn sản phẩm**
- **URL**: `/api/product-options/{id}`
- **Phương thức**: `PUT`
- **Mô tả**: Cập nhật thông tin tùy chọn sản phẩm theo ID.
- **Request**:
    ```json
    {
      "name": "Tùy chọn đã cập nhật",
      "description": "Mô tả tùy chọn đã cập nhật"
    }
- **Response**:
    ```json
    {
      "id": "12345",
      "name": "Tùy chọn đã cập nhật",
      "description": "Mô tả tùy chọn đã cập nhật"
    }
### 5. **Xóa tùy chọn sản phẩm**
- **URL**: `/api/product-options/{id}`
- **Phương thức**: `DELETE`
- **Mô tả**: Xóa tùy chọn sản phẩm theo ID.
- **Request**:
- `id`: ID của tùy chọn sản phẩm cần xóa.
- **Response**:
    ```json
    {
      "message": "Tùy chọn sản phẩm đã được xóa thành công"
    }
### **Lưu ý**
- **Validation**: Đảm bảo dữ liệu đầu vào hợp lệ trước khi xử lý.
- **Xử lý lỗi**:
  - Trả về mã lỗi phù hợp (ví dụ: `404 Not Found` nếu tùy chọn sản phẩm không tồn tại).
  - Sử dụng thông báo lỗi chi tiết trong Response.
