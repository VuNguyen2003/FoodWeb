# API Documentation - CartItemController

## Base URL: `/api/v1/cartitem`

---

### 1. Add Items to Cart

- **Endpoint**: `/additems`  
- **Method**: `POST`  
- **Description**: Thêm các sản phẩm vào giỏ hàng.

- **Request Body**:
    ```json
    [
      {
        "productId": "101",
        "quantity": 2
      },
      {
        "productId": "102",
        "quantity": 1
      }
    ]

- **Response**:

  - **200 OK**:
      ```json
      "Received: [{\"productId\":\"101\",\"quantity\":2},{\"productId\":\"102\",\"quantity\":1}]"
  - **400 Bad Request**:
      ```json
      {
        "error": "Danh sách items không thể rỗng!"
      }
## 2. **Get All Cart Items**
- **Endpoint**: `/getallitems` 
- **Method**: `GET`
- **Description**: Lấy tất cả các sản phẩm trong giỏ hàng.

- **Response**:
  - **200 Ok**:
      ```json
      [
        {
          "id": 1,
          "productId": "101",
          "quantity": 2
        },
        {
          "id": 2,
          "productId": "102",
          "quantity": 1
        }
      ]
  - **204 No Content**:
      ```json
      []

### 3. **Remove Item from Cart**
- **Endpoint**: `/remove/{id}`
- **Method**: `DELETE`
- **Description**: Xóa sản phẩm khỏi giỏ hàng dựa trên ID.

- **Path Parameters**:

- `id` (Long): ID của sản phẩm trong giỏ hàng cần xóa.
- **Response**:

  - **204 No Content**:
      ```json
      (No Content)
  - **404 Not Found**:
      ```json
      {
        "error": "Không tìm thấy CartItem với ID: {id}"
      }
### **Notes**
- Các yêu cầu API sẽ trả về mã lỗi khi có lỗi dữ liệu hoặc khi không tìm thấy sản phẩm trong giỏ hàng.
- API hỗ trợ các thao tác CRUD cho các sản phẩm trong giỏ hàng: thêm, lấy tất cả và xóa.
- Nếu danh sách sản phẩm rỗng khi thêm, hệ thống sẽ trả về lỗi 400 với thông báo lỗi.
- Nếu không có sản phẩm nào trong giỏ hàng, hệ thống sẽ trả về mã 204 No Content.