# **RoleController**

## **Mô tả**
`RoleController` cung cấp các API để quản lý các vai trò (roles) trong hệ thống, bao gồm các tính năng: tạo, lấy chi tiết, cập nhật, xóa và liệt kê tất cả các vai trò.

---

## **Các Endpoint**

### **1. Lấy tất cả các vai trò**
- **URL**: `/api/v1/roles`
- **Phương thức**: `GET`
- **Mô tả**: Lấy danh sách tất cả các vai trò trong hệ thống.
- **Response**:
  ```json
  [
    {
      "id": "1",
      "name": "Admin",
      "description": "Quản trị viên hệ thống"
    },
    {
      "id": "2",
      "name": "User",
      "description": "Người dùng thường"
    }
  ]
### 2. **Lấy vai trò theo ID**
- **URL**: `/api/v1/roles/{id}`
- **Phương thức**: `GET`
- **Mô tả**: Lấy thông tin chi tiết của vai trò theo ID.
- **Request**:
- `id`: ID của vai trò cần lấy.
- **Response**:
    ```json
    {
      "id": "1",
      "name": "Admin",
      "description": "Quản trị viên hệ thống"
    }
### 3. **Tạo mới một vai trò**
- **URL**: `/api/v1/roles`
- **Phương thức**: POST
- **Mô tả**: Tạo mới một vai trò trong hệ thống.
- **Request**:
    ```json
    {
      "name": "Manager",
      "description": "Quản lý hệ thống"
    }
- **Response**:
    ```json
    {
      "id": "3",
      "name": "Manager",
      "description": "Quản lý hệ thống"
    }
### 4. **Cập nhật vai trò**
- **URL**: `/api/v1/roles/{id}`
- **Phương thức**: `PUT`
- **Mô tả**: Cập nhật thông tin vai trò theo ID.
- **Request**:
    ```json
    {
      "name": "SuperAdmin",
      "description": "Quản trị viên cao cấp"
    }
- **Response**:
    ```json
    {
      "id": "1",
      "name": "SuperAdmin",
      "description": "Quản trị viên cao cấp"
    }
### 5. **Xóa vai trò**
- **URL**: `/api/v1/roles/{id}`
- **Phương thức**: `DELETE`
- **Mô tả**: Xóa vai trò theo ID.
- **Request**:
- `id`: ID của vai trò cần xóa.
- **Response**:
    ```json
    {
      "message": "Vai trò đã được xóa thành công"
    }
### **Lưu ý**
- **Validation**: Đảm bảo dữ liệu đầu vào hợp lệ trước khi xử lý.
- **Xử lý lỗi**:
  - Trả về mã lỗi phù hợp (ví dụ: `404 Not Found` nếu vai trò không tồn tại).
  - Sử dụng thông báo lỗi chi tiết trong Response.