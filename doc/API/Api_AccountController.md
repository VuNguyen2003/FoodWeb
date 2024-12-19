# API Documentation - AccountController

## Base URL: `/api/v1/account`

---

### 1. **Register a new account**
- **Endpoint**: `/register`
- **Method**: POST
- **Description**: Đăng ký tài khoản mới.
- **Request Body**:
  ```json
  {
  "username": "john_doe",
  "password": "securePassword123",
  "fullName": "John Doe",
  "email": "john.doe@example.com",
  "address": "123 Main Street"
  }
- **Response**
  - 200 Ok
    ```json
    "message": "Tài khoản đã được đăng ký thành công."
  - 401 bad request
    ```json
    "message": "Tài khoản đã được đăng ký thành công."
### 2. **Login to an account**
- **Endpoint**: `/login`
- **Method**: POST
- **Description**: Đăng nhập tài khoản và tạo token.
- **Request Body**:
   ```json
   {
   "username": "john_doe",
   "password": "securePassword123"
   }
- **Response**:
  - 200 OK:
      ```json
    Đăng nhập thành công! Token của bạn: [token_value]
  - 401 Unauthorized:
      ```json
    Tên người dùng hoặc mật khẩu không đúng!
### 3. **Update account information**
- **Endpoint**: `/{username}`
- **Method**: PUT
- **Description**: Cập nhật thông tin tài khoản.
- **Headers**:
- **Authorization**: Bearer token
- **Path Parameter**:
- **username (String)**: Tên người dùng của tài khoản cần cập nhật.
- **Request Body**:
    ```json
    {
    "fullName": "Johnathan Doe",
    "email": "johnathan.doe@example.com",
    "address": "456 Elm Street",
    "password": "newPassword123"
    }
- **Response**:
  - **200 OK**:
      ```json
      Cập nhật thông tin thành công!
  - **401 Unauthorized**:
      ```json
      Token không hợp lệ hoặc đã hết hạn!
  - **404 Not Found**:
      ```json
      Tài khoản không tìm thấy!
  - **500 Internal Server Error**:
      ```json
      Cập nhật không thành công!
### **4. Error Codes**
- **400 Bad Request**: Lỗi liên quan đến đầu vào không hợp lệ.
- **401 Unauthorized**: Xác thực thất bại (sai token, sai thông tin đăng nhập).
- **404 Not Found**: Tài khoản hoặc tài nguyên không tồn tại.
- **500 Internal Server Error**: Lỗi máy chủ.
### **5. Notes**
- Tất cả các API cần tuân thủ chuẩn RESTful.
- Đảm bảo token được truyền đúng định dạng trong header cho các API cần xác thực.
- Đặt base URL cố định để dễ quản lý và truy cập.