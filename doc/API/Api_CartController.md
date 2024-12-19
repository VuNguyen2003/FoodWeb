# API Documentation - CartController

## Base URL: `/api/v1/carts`

---

### 1. Get All Carts

**Endpoint**: `/`  
**Method**: `GET`  
**Description**: Lấy danh sách tất cả các giỏ hàng.

**Response**:
- **200 OK**:
  ```json
  [
    {
      "id": "1",
      "items": [
        {
          "productId": "101",
          "quantity": 2
        },
        {
          "productId": "102",
          "quantity": 1
        }
      ],
      "totalPrice": 50.00
    },
    {
      "id": "2",
      "items": [
        {
          "productId": "103",
          "quantity": 3
        }
      ],
      "totalPrice": 30.00
    }
  ]

### 2. **Get Cart by ID**
- **Endpoint**: `/{id}`
- **Method**: `GET`
- **Description**: Lấy giỏ hàng theo ID duy nhất.

- **Path Parameters**:

- `id` (String): ID của giỏ hàng.
- **Response**:

  - **200 OK**
    ```json
    {
      "id": "1",
      "items": [
        {
          "productId": "101",
          "quantity": 2
        },
        {
          "productId": "102",
          "quantity": 1
        }
      ],
      "totalPrice": 50.00
    }
  - **404 Not Found:
    ```json
    {
      "error": "Giỏ hàng không tìm thấy!"
    }
### 3. **Create a New Cart**
- **Endpoint**: `/`
- **Method**: `POST`
- **Description**: Tạo một giỏ hàng mới.

- **Request Body**:
  ```json
  {
    "items": [
      {
        "productId": "101",
        "quantity": 2
      },
      {
        "productId": "102",
        "quantity": 1
      }
    ]
  }
- **Response**
  - **201 Created
    ```json
    {
      "id": "3",
      "items": [
        {
          "productId": "101",
          "quantity": 2
        },
        {
          "productId": "102",
          "quantity": 1
        }
      ],
      "totalPrice": 50.00
    }
### 4. **Update Cart by ID**
- **Endpoint**: `/{id}`
- **Method**: `PUT`
- **Description**: Cập nhật giỏ hàng hiện có dựa trên ID.

- **Path Parameters**:

- `id` (String): ID của giỏ hàng cần cập nhật.
- **Request Body**:
  ```json
  {
    "items": [
      {
        "productId": "101",
        "quantity": 3
      }
    ]
  }
- **Response**:

  - **200 OK**:
    ```json
    {
      "id": "1",
      "items": [
        {
          "productId": "101",
          "quantity": 3
        }
      ],
      "totalPrice": 75.00
    }
  - **404 Not Found**:
    ```json
    {
      "error": "Giỏ hàng không tìm thấy!"
    }
### 5. **Delete Cart by ID**
- **Endpoint**: /{id}
- **Method**: DELETE
- **Description**: Xóa giỏ hàng theo ID.

- **Path Parameters**:

- `id` (String): ID của giỏ hàng cần xóa.
- **Response**:

  - **204 No Content**:
    ```json
    (No Content)
  - **404 Not Found:
    ```json
    {
      "error": "Giỏ hàng không tìm thấy!"
    }
### **Notes**
- Đảm bảo rằng các yêu cầu API có thể trả về mã lỗi tương ứng khi giỏ hàng không tồn tại.
- Các API trả về trạng thái HTTP chuẩn, bao gồm 200, 201, 204 và 404.
- Các endpoint hỗ trợ các thao tác CRUD (Create, Read, Update, Delete) cho giỏ hàng.
