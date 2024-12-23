# API Documentation - OrderDetailsOptionController

## Base URL: `/api/order-details-options`

---

### 1. Get All Order Details Options

- **Endpoint**: `/`  
- **Method**: `GET`  
- **Description**: Lấy danh sách tất cả các tùy chọn chi tiết đơn hàng.

- **Response**:
  - **200 OK**:
    ```json
    [
      {
        "id": "1",
        "orderDetailsId": "12345",
        "optionId": "opt123",
        "optionValue": "Extra Cheese"
      },
      {
        "id": "2",
        "orderDetailsId": "12346",
        "optionId": "opt124",
        "optionValue": "No Onions"
      }
    ]
### 2. **Get Order Details Option by ID**
- **Endpoint**: `/{id}`
- **Method**: `GET`
- **Description**: Lấy thông tin tùy chọn chi tiết đơn hàng theo ID.

- **Path Parameters**:

- `id` (String): ID của tùy chọn chi tiết đơn hàng.
- **Response**:

  - **200 OK**:
      ```json
      {
        "id": "1",
        "orderDetailsId": "12345",
        "optionId": "opt123",
        "optionValue": "Extra Cheese"
      }
  - **404 Not Found**:
      ```json
      {
        "error": "OrderDetailsOption not found with ID: {id}"
      }
### 3. **Create Order Details Option**
- **Endpoint**: `/`
- **Method**: `POST`
- **Description**: Tạo mới một tùy chọn chi tiết đơn hàng.

- **Request Body**:
    ```json
    {
      "orderDetailsId": "12345",
      "optionId": "opt123",
      "optionValue": "Extra Cheese"
    }
- **Resonse**:
  - **200 Ok**:
      ```json
      {
        "id": "3",
        "orderDetailsId": "12345",
        "optionId": "opt123",
        "optionValue": "Extra Cheese"
      }
### 4. **Update Order Details Option**
- **Endpoint**: `/{id}`
- **Method**: `PUT`
- **Description**: Cập nhật thông tin tùy chọn chi tiết đơn hàng theo ID.

- **Path Parameters**:

- `id` (String): ID của tùy chọn chi tiết đơn hàng cần cập nhật.
- **Request Body**:
    ```json
    {
      "orderDetailsId": "12345",
      "optionId": "opt123",
      "optionValue": "No Cheese"
    }
- **Response**:
  - **200 Ok**:
      ```json
      {
        "id": "1",
        "orderDetailsId": "12345",
        "optionId": "opt123",
        "optionValue": "No Cheese"
      }
  - **404 Not Found**:
      ```json
      {
        "error": "OrderDetailsOption not found with ID: {id}"
      }
### 5. **Delete Order Details Option**
- **Endpoint**: `/{id}`
- **Method**: `DELETE`
- **Description**: Xóa một tùy chọn chi tiết đơn hàng theo ID.

- **Path Parameters**:

- `id` (String): ID của tùy chọn chi tiết đơn hàng cần xóa.
- **Response**:

  - **204 No Content**: Tùy chọn đã được xóa thành công.
  - **404 Not Found**:
      ```json
      {
        "error": "OrderDetailsOption not found with ID: {id}"
      }
### **Notes**
- **Validation**: Các lỗi liên quan đến đầu vào hoặc logic sẽ trả về mã lỗi HTTP tương ứng.
- **HTTP Status Codes**:
  - `200 OK`: Thành công lấy hoặc cập nhật tùy chọn.
  - `204 No Content`: Thành công xóa tùy chọn.
  - `404 Not Found`: Không tìm thấy tùy chọn tương ứng.