# API Documentation - PaymentMethodController

## Base URL: `/api/v1/payment-methods`

---

### 1. Create Payment Method

- **Endpoint**: `/`  
- **Method**: `POST`  
- **Description**: Tạo một phương thức thanh toán mới.

- **Request Body**:
    ```json
    {
      "name": "Credit Card",
      "description": "Pay using Visa, MasterCard, or other credit cards."
    }
- **Response**:

  - **200 OK**:
      ```json
      {
        "id": "1",
        "name": "Credit Card",
        "description": "Pay using Visa, MasterCard, or other credit cards."
      }
### 2. **Get Payment Method by ID**
- **Endpoint**: `/{id}`
- **Method**: `GET`
- **Description**: Lấy thông tin chi tiết của một phương thức thanh toán theo ID.

- **Path Parameters**:

- `id` (String): ID của phương thức thanh toán cần tìm.
- **Response**:

  - **200 OK**:
    ```json
      {
        "id": "1",
        "name": "Credit Card",
        "description": "Pay using Visa, MasterCard, or other credit cards."
      }
  - **404 Not Found**:
    ```json
      {
        "error": "PaymentMethod with ID {id} not found."
      }
### 3. **Get All Payment Methods**
- **Endpoint**: `/`
- **Method**: `GET`
- **Description**: Lấy danh sách tất cả các phương thức thanh toán.

- **Response**:

  - **200 OK**:
    ```json
    [
      {
        "id": "1",
        "name": "Credit Card",
        "description": "Pay using Visa, MasterCard, or other credit cards."
      },
      {
        "id": "2",
        "name": "PayPal",
        "description": "Secure online payments."
      }
    ]
### 4. **Update Payment Method by ID**
- **Endpoint**: `/{id}`
- **Method**: `PUT`
- **Description**: Cập nhật thông tin của một phương thức thanh toán theo ID.

- **Path Parameters**:

- `id` (String): ID của phương thức thanh toán cần cập nhật.
- **Request Body**:
  ```json
  {
    "name": "Bank Transfer",
    "description": "Direct transfer to our bank account."
  }
- **Response**:

  - **200 OK**:
    ```json
    {
      "id": "1",
      "name": "Bank Transfer",
      "description": "Direct transfer to our bank account."
    }
  - **404 Not Found**:
    ```json
    {
      "error": "PaymentMethod with ID {id} not found."
    }
### 5. **Delete Payment Method by ID**
- **Endpoint**: `/{id}`
- **Method**: `DELETE`
- **Description**: Xóa một phương thức thanh toán theo ID.

- **Path Parameters**:

- `id` (String): ID của phương thức thanh toán cần xóa.
- **Response**:

  - **204 No Content**: Phương thức thanh toán đã được xóa thành công.
  - **404 Not Found**:
    ```json
    {
      "error": "PaymentMethod with ID {id} not found."
    }
### **Notes**
- **Validation**: Các lỗi liên quan đến đầu vào không hợp lệ sẽ được trả về với mã lỗi HTTP tương ứng.
- **HTTP Status Codes**:
- `200 OK`: Thành công lấy hoặc cập nhật thông tin phương thức thanh toán.
- `201 Created`: Thành công tạo phương thức thanh toán mới.
- `204 No Content`: Thành công xóa phương thức thanh toán.
- `404 Not Found`: Không tìm thấy phương thức thanh toán với ID tương ứng.