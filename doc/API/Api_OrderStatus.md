# API Documentation - OrderStatusController

## Base URL: `/api/order-status`

---

### 1. Create Order Status

- **Endpoint**: `/`  
- **Method**: `POST`  
- **Description**: Tạo một trạng thái đơn hàng mới.

- **Request Body**:
    ```json
    {
      "statusCode": "PENDING",
      "description": "Order is pending confirmation."
    }
- **Response**:
  - **201 Created**:
      ```json
      {
        "id": "1",
        "statusCode": "PENDING",
        "description": "Order is pending confirmation."
      }
### 2. **Get All Order Statuses**
- **Endpoint**: `/`
- **Method**: `GET`
- **Description**: Lấy danh sách tất cả trạng thái đơn hàng.

- **Response**:

  - **200 OK**:
      ```json
      [
        {
          "id": "1",
          "statusCode": "PENDING",
          "description": "Order is pending confirmation."
        },
        {
          "id": "2",
          "statusCode": "COMPLETED",
          "description": "Order has been delivered."
        }
      ]
### 3. Get Order Status by ID
- **Endpoint**: `/{statusId}`
- **Method**: `GET`
- **Description**: Lấy thông tin chi tiết của một trạng thái đơn hàng theo ID.

- **Path Parameters**:

- `statusId` (String): ID của trạng thái đơn hàng cần tìm.
- **Response**:

  - **200 OK**:
      ```json
      {
        "id": "1",
        "statusCode": "PENDING",
        "description": "Order is pending confirmation."
      }
  - **404 Not Found**:
      ```json
      {
        "error": "OrderStatus with ID {statusId} not found."
      }
### 4. **Update Order Status by ID**
- **Endpoint**: `/{statusId}`
- **Method**: `PUT`
- **Description**: Cập nhật thông tin của một trạng thái đơn hàng theo ID.

- **Path Parameters**:

- `statusId` (String): ID của trạng thái đơn hàng cần cập nhật.
- **Request Body**:
- **Response**:

  - **200 OK**:
      ```json
      {
        "id": "1",
        "statusCode": "CONFIRMED",
        "description": "Order has been confirmed."
      }
  - **404 Not Found**:
      ```json
      {
        "error": "OrderStatus with ID {statusId} not found."
      }
### 5. **Delete Order Status by ID**
- **Endpoint**: `/{statusId}`
- **Method**: `DELETE`
- **Description**: Xóa một trạng thái đơn hàng theo ID.

- **Path Parameters**:

- `statusId` (String): ID của trạng thái đơn hàng cần xóa.
- **Response**:

  - **204 No Content**: Trạng thái đơn hàng đã được xóa thành công.
  - **404 Not Found**:
      ```json
      {
        "error": "OrderStatus with ID {statusId} not found."
      }
### **Notes**
- **Validation**: Nếu các đầu vào không hợp lệ, lỗi sẽ được trả về với mã lỗi HTTP phù hợp.
- **HTTP Status Codes**:
- `200 OK`: Thành công lấy hoặc cập nhật thông tin trạng thái đơn hàng.
- `201 Created`: Thành công tạo trạng thái đơn hàng mới.
- `204 No Content`: Thành công xóa trạng thái đơn hàng.
- `404 Not Found`: Không tìm thấy trạng thái đơn hàng với ID tương ứng.