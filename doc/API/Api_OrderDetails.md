# API Documentation - OrderDetailsController

## Base URL: `/api/v1/order-details`

---

### 1. Get All Order Details

- **Endpoint**: `/`  
- **Method**: `GET`  
- **Description**: Lấy danh sách tất cả chi tiết đơn hàng.

- **Response**:
    - **200 OK**:
      ```json
      [
        {
          "id": "1",
          "orderId": "12345",
          "productId": "67890",
          "quantity": 2,
          "price": 150.00
        },
        {
          "id": "2",
          "orderId": "12346",
          "productId": "67891",
          "quantity": 1,
          "price": 75.00
        }
      ]
### 2. Get Order Detail by ID
- **Endpoint**: `/{id}`
- **Method**: `GET`
- **Description**: Lấy thông tin chi tiết đơn hàng theo ID.

- **Path Parameters**:

- `id` (String): ID của chi tiết đơn hàng cần lấy.
- **Response**:
  - **200 Ok**:
      ```json
      {
        "id": "1",
        "orderId": "12345",
        "productId": "67890",
        "quantity": 2,
        "price": 150.00
      }
  - **404 Not Found**:
      ```json
      {
        "error": "OrderDetail not found with ID: {id}"
      }
### 3. **Create Order Detail**
- **Endpoint**: `/`
- **Method**: `POST`
- **Description**: Tạo mới một chi tiết đơn hàng.

- **Request Body**:
    ```json
    {
      "orderId": "12345",
      "productId": "67890",
      "quantity": 2,
      "price": 150.00
    }
- **Response**:
  - **201 Created**:
      ```json
      {
        "id": "3",
        "orderId": "12345",
        "productId": "67890",
        "quantity": 2,
        "price": 150.00
      }
### 4. **Update Order Detail**
- **Endpoint**: `/{id}`
- **Method**: `PUT`
- **Description**: Cập nhật thông tin chi tiết đơn hàng theo ID.

- **Path Parameters**:

- `id` (String): ID của chi tiết đơn hàng cần cập nhật.
- **Request Body**:
    ```json
    {
      "orderId": "12345",
      "productId": "67890",
      "quantity": 3,
      "price": 225.00
    }
- **Response**:
  - **200 Ok**:
      ```json
      {
        "id": "1",
        "orderId": "12345",
        "productId": "67890",
        "quantity": 3,
        "price": 225.00
      }
  - **404 Not Found**:
      ```json
      {
        "error": "OrderDetail not found with ID: {id}"
      }
### 5. **Delete Order Detail**
- **Endpoint**: `/{id}`
- **Method**: `DELETE`
- **Description**: Xóa một chi tiết đơn hàng theo ID.

- **Path Parameters**:

- `id` (String): ID của chi tiết đơn hàng cần xóa.
- **Response**:

  - **204 No Content**: Chi tiết đơn hàng đã được xóa thành công.
  - **404 Not Found**:
      ```json
      {
        "error": "OrderDetail not found with ID: {id}"
      }
### **Notes**
- **Validation**: Các lỗi liên quan đến đầu vào hoặc logic sẽ trả về mã lỗi HTTP tương ứng.
- **HTTP Status Codes**:
  - **`200 OK`**: Thành công lấy hoặc cập nhật chi tiết đơn hàng.
  - **`201 Created`**: Thành công tạo mới chi tiết đơn hàng.
  - **`204 No Content`**: Thành công xóa chi tiết đơn hàng.
  - **`404 Not Found`**: Không tìm thấy chi tiết đơn hàng tương ứng.