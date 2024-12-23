# **StatusController**

## **Mô tả**
`StatusController` cung cấp các API để quản lý trạng thái trong hệ thống, bao gồm các tính năng: tạo, lấy chi tiết, cập nhật, xóa và liệt kê tất cả các trạng thái.

---

## **Các Endpoint**

### **1. Lấy tất cả các trạng thái**
- **URL**: `/api/v1/statuses`
- **Phương thức**: `GET`
- **Mô tả**: Lấy danh sách tất cả các trạng thái trong hệ thống.
- **Response**:
  ```json
  [
    {
      "id": "1",
      "name": "Pending",
      "description": "Đang chờ xử lý"
    },
    {
      "id": "2",
      "name": "Completed",
      "description": "Đã hoàn thành"
    }
  ]
### 2. **Lấy trạng thái theo ID**
- **URL**: `/api/v1/statuses/{id}`
- **Phương thức**: `GET`
- **Mô tả**: Lấy thông tin chi tiết của trạng thái theo ID.
- **Request**:
- `id`: ID của trạng thái cần lấy.
- **Response**:
    ```json
    {
      "id": "1",
      "name": "Pending",
      "description": "Đang chờ xử lý"
    }
3. Tạo mới một trạng thái
- **URL**: `/api/v1/statuses`
- **Phương thức**: `POST`
- **Mô tả**: Tạo mới một trạng thái trong hệ thống.
- **Request**:
    ```json
    {
      "name": "In Progress",
      "description": "Đang xử lý"
    }
- **Response**:
    ```json
    {
      "id": "3",
      "name": "In Progress",
      "description": "Đang xử lý"
    }
### 4. **Cập nhật trạng thái**
- **URL**: `/api/v1/statuses/{id}`
- **Phương thức**: `PUT`
- **Mô tả**: Cập nhật thông tin trạng thái theo ID.
- **Request**:
    ```json
    {
      "name": "Shipped",
      "description": "Đã gửi hàng"
    }
- **Response**:
    ```json
    {
      "id": "1",
      "name": "Shipped",
      "description": "Đã gửi hàng"
    }
### 5. **Xóa trạng thái**
- **URL**: `/api/v1/statuses/{id}`
- **Phương thức**: `DELETE`
- **Mô tả**: Xóa trạng thái theo ID.
- **Request**:
- `id`: ID của trạng thái cần xóa.
- **Response**:
    ```json
    {
      "message": "Trạng thái đã được xóa thành công"
    }
### **Lưu ý**
- **Validation**: Đảm bảo dữ liệu đầu vào hợp lệ trước khi xử lý.
- **Xử lý lỗi**:
  - Trả về mã lỗi phù hợp (ví dụ: 404 Not Found nếu trạng thái không tồn tại).
  - Sử dụng thông báo lỗi chi tiết trong Response.





