# API Documentation - OrdersController

## Base URL: `/api/v1/orders`

---

### 1. Get All Orders

- **Endpoint**: `/`  
- **Method**: `GET`  
- **Description**: Lấy danh sách tất cả các đơn hàng.

- **Response**:
  - **200 OK**:
    ```json
    [
      {
        "id": "1",
        "customerId": "cus123",
        "orderDate": "2024-12-21T15:30:00",
        "totalAmount": 150.5,
        "status": "Pending"
      },
      {
        "id": "2",
        "customerId": "cus124",
        "orderDate": "2024-12-20T10:00:00",
        "totalAmount": 200.75,
        "status": "Completed"
      }
    ]
### 2. **Get Order by ID**
- **Endpoint**: `/{id}`
- **Method**: `GET`
- **escription**: Lấy thông tin chi tiết của một đơn hàng theo ID.

- **Path Parameters**:

- `id` (String): ID của đơn hàng cần tìm.
- **Response**:
  - **200 Ok**:
      ```json
      {
        "id": "1",
        "customerId": "cus123",
        "orderDate": "2024-12-21T15:30:00",
        "totalAmount": 150.5,
        "status": "Pending"
      }
  - **404 Not Found**:
      ```json
      {
        "error": "Order not found with ID: {id}"
      }
### 3. Create a New Order
- **Endpoint**: `/`
- **Method**: `POST`
- **Description**: Tạo mới một đơn hàng.

- **Request Body**:
    ```json
    {
      "customerId": "cus123",đầu 
      "orderDate": "2024-12-21T15:30:00",
      "totalAmount": 150.5,
      "status": "Pending"
    }
- **Response**:
  - **200 Created**:
      ```json
      {
        "id": "3",
        "customerId": "cus123",
        "orderDate": "2024-12-21T15:30:00",
        "totalAmount": 150.5,
        "status": "Pending"
      }
### 4. **Update Order by ID**
- **Endpoint**: `/{id}`
- **Method**: `PUT`
- **Description**: Cập nhật thông tin của một đơn hàng theo ID.

- **Path Parameters**:

- `id` (String): ID của đơn hàng cần cập nhật.
- **Request Body**:
    ```json
    {
      "customerId": "cus123",
      "orderDate": "2024-12-21T16:00:00",
      "totalAmount": 160.5,
      "status": "Processing"
    }
- **Response**
  - **200 Ok**:
      ```json
      {
        "id": "1",
        "customerId": "cus123",
        "orderDate": "2024-12-21T16:00:00",
        "totalAmount": 160.5,
        "status": "Processing"
      }
  - **404 Not Found**:
      ```json
      {
        "error": "Order not found with ID: {id}"
      }
### 5. Delete Order by ID
- **Endpoint**: `/{id}`
- **Method**: `DELETE`
- **Description**: Xóa một đơn hàng theo ID.

- **Path Parameters**:

- `id` (String): ID của đơn hàng cần xóa.
- **Response**:

  - **204 No Content**: Đơn hàng đã được xóa thành công.
  - **404 Not Found**:
      ```json
      {
        "error": "Order not found with ID: {id}"
      }
### Notes
- **Validation**: Lỗi liên quan đến đầu vào sẽ được trả về dưới dạng mã lỗi HTTP phù hợp.
- **HTTP Status Codes**:
- `200 OK`: Thành công lấy hoặc cập nhật thông tin đơn hàng.
- `201 Created`: Thành công tạo đơn hàng mới.
- `204 No Content`: Thành công xóa đơn hàng.
- `404 Not Found`: Không tìm thấy đơn hàng tương ứng.