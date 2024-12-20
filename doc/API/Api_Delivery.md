# API Documentation - DeliveryController

## Base URL: `/api/delivery`

---

### 1. Create or Update Delivery

- **Endpoint**: `/`
- **Method**: `POST`
- **Description**: Tạo mới hoặc cập nhật thông tin giao hàng.

- **Request Body**:
    ```json
    {
      "deliveryId": "D001",
      "orderId": "O001",
      "deliveryStatus": "Pending",
      "deliveryDate": "2024-12-20",
      "address": "123 Main Street, Cityville"
    }
- **Response**:

    - **201 Created**:
        ```json
        {
          "deliveryId": "D001",
          "orderId": "O001",
          "deliveryStatus": "Pending",
          "deliveryDate": "2024-12-20",
          "address": "123 Main Street, Cityville"
        }
### 2. **Get Delivery by ID**
- **Endpoint**: `/{id}`
- **Method**: `GET`
- **Description**: Lấy thông tin giao hàng theo ID giao hàng.

- **Path Parameters**:

- `id` (String): ID của giao hàng cần lấy.
- **Response**:

    - **200 OK**:
        ```json
        {
          "deliveryId": "D001",
          "orderId": "O001",
          "deliveryStatus": "Pending",
          "deliveryDate": "2024-12-20",
          "address": "123 Main Street, Cityville"
        }
    - **404 Not Found**
        ```json
        {
          "error": "Delivery not found with ID: {id}"
        }
## 3. **Get Delivery by Order ID**
- **Endpoint**: `/order/{orderId}`
- **Method**: `GET`
- **Description**: Lấy thông tin giao hàng theo ID của đơn hàng.

- **Path Parameters**:

- `orderId` (String): ID của đơn hàng cần lấy thông tin giao hàng.
- **Response**:

- **200 OK**:
  ```json
  {
    "deliveryId": "D001",
    "orderId": "O001",
    "deliveryStatus": "Pending",
    "deliveryDate": "2024-12-20",
    "address": "123 Main Street, Cityville"
  }
- **404 Not Found**:
  ```json
  {
    "error": "Delivery not found for Order ID: {orderId}"
  }
## **Notes**
- **Validation**: API xử lý dữ liệu null hoặc không hợp lệ trong phần Request Body và trả về mã lỗi phù hợp.
- **DeliveryMapper**: Chuyển đổi giữa các đối tượng DTO (DeliveryRequest, DeliveryResponse) và thực thể (Delivery) được sử dụng để duy trì cấu trúc và tính rõ ràng trong mã nguồn.
- **HTTP Status Codes**:
- **`201 Created`**: Đối tượng giao hàng được tạo hoặc cập nhật thành công.
- **`404 Not Found`**: Không tìm thấy giao hàng hoặc đơn hàng với ID tương ứng.
