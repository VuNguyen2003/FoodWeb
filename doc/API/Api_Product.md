# **ProductController**

## **Mô tả**
`ProductController` cung cấp các API để quản lý sản phẩm trong hệ thống, bao gồm các tính năng: tạo, lấy chi tiết, cập nhật, xóa, tìm kiếm, phân trang và sắp xếp sản phẩm.

## **Các Endpoint**

### **1. Tạo sản phẩm**
- **URL**: `/api/v1/products`
- **Phương thức**: `POST`
- **Mô tả**: Tạo một sản phẩm mới cùng với hình ảnh.
- **Request**:
    ```json
  {
    "product": {
      "name": "Tên sản phẩm",
      "description": "Mô tả sản phẩm",
      "price": 100.0,
      "categoryId": "12345"
    },
    "image": "file hình ảnh sản phẩm (multipart/form-data)"
  }
- **Response**:
    ```json
    {
      "id": "12345",
      "name": "Tên sản phẩm",
      "description": "Mô tả sản phẩm",
      "price": 100.0,
      "categoryId": "12345",
      "imageUrl": "http://example.com/images/product.jpg"
    }

---

### **2. Lấy sản phẩm theo ID**
- **URL**: `/api/v1/products/{id}`
- **Phương thức**: `GET`
- **Mô tả**: Lấy chi tiết sản phẩm dựa vào ID.
- **Request**:
    - `id`: ID của sản phẩm.
- **Response**:
    ```json
    {
      "id": "12345",
      "name": "Tên sản phẩm",
      "description": "Mô tả sản phẩm",
      "price": 100.0,
      "categoryId": "12345",
      "imageUrl": "http://example.com/images/product.jpg"
    }

---

### **3. Lấy danh sách sản phẩm (Phân trang)**
- **URL**: `/api/v1/products/products`
- **Phương thức**: `GET`
- **Mô tả**: Lấy danh sách các sản phẩm với phân trang.
- **Request**:
    - `page` (Tùy chọn): Số trang (mặc định là `0`).
    - `size` (Tùy chọn): Số sản phẩm mỗi trang (mặc định là `20`).
- **Response**:
    ```json
    {
      "content": [
        {
          "id": "12345",
          "name": "Tên sản phẩm 1",
          "price": 100.0
        },
        {
          "id": "67890",
          "name": "Tên sản phẩm 2",
          "price": 150.0
        }
      ],
      "pageable": {
        "pageNumber": 0,
        "pageSize": 20
      },
      "totalPages": 5,
      "totalElements": 100
    }


---

### **4. Cập nhật sản phẩm**
- **URL**: `/api/v1/products/{id}`
- **Phương thức**: `PUT`
- **Mô tả**: Cập nhật thông tin sản phẩm theo ID.
- **Request**:
    ```json
    {
      "name": "Tên sản phẩm mới",
      "description": "Mô tả sản phẩm mới",
      "price": 120.0
    }

- **Response**:
    ```json
    {
      "id": "12345",
      "name": "Tên sản phẩm mới",
      "description": "Mô tả sản phẩm mới",
      "price": 120.0,
      "categoryId": "12345",
      "imageUrl": "http://example.com/images/product.jpg"
    }

---

### **5. Xóa sản phẩm**
- **URL**: `/api/v1/products/{id}`
- **Phương thức**: `DELETE`
- **Mô tả**: Xóa sản phẩm theo ID.
- **Request**:
    - `id`: ID của sản phẩm cần xóa.
- **Response**:
    ```json
    {
      "message": "Sản phẩm đã được xóa thành công"
    }
      

---

### **6. Lấy sản phẩm theo khoảng giá**
- **URL**: `/api/v1/products/products/price-range`
- **Phương thức**: `GET`
- **Mô tả**: Lấy danh sách sản phẩm trong khoảng giá cụ thể.
- **Request**:
    - `minPrice`: Giá tối thiểu.
    - `maxPrice`: Giá tối đa.
- **Response**:
    ```json
    [
      {
        "id": "12345",
        "name": "Sản phẩm 1",
        "price": 50.0
      },
      {
        "id": "67890",
        "name": "Sản phẩm 2",
        "price": 70.0
      }
    ]


---

### **7. Sắp xếp sản phẩm**
#### **Sắp xếp tăng dần theo giá**
- **URL**: `/api/v1/products/products/sorted/asc`
- **Phương thức**: `GET`
- **Mô tả**: Lấy danh sách sản phẩm sắp xếp theo giá tăng dần.
- **Response**:
    - **200 OK**: Trả về danh sách sản phẩm.

#### **Sắp xếp giảm dần theo giá**
- **URL**: `/api/v1/products/products/sorted/desc`
- **Phương thức**: `GET`
- **Mô tả**: Lấy danh sách sản phẩm sắp xếp theo giá giảm dần.
- **Response**:
    ```json
    [
      {
        "id": "12345",
        "name": "Sản phẩm rẻ",
        "price": 10.0
      },
      {
        "id": "67890",
        "name": "Sản phẩm đắt",
        "price": 50.0
      }
    ]

### **Sắp xếp giảm dần theo giá**
- **URL**: `/api/v1/products/products/sorted/desc`
- **Phương thức**: `GET`
- **Mô tả**: Lấy danh sách sản phẩm sắp xếp theo giá giảm dần.
- **Response**:
    ```json
    [
      {
        "id": "67890",
        "name": "Sản phẩm đắt",
        "price": 50.0
      },
      {
        "id": "12345",
        "name": "Sản phẩm rẻ",
        "price": 10.0
      }
    ]

---

### **8. Tìm kiếm sản phẩm theo tên**
- **URL**: `/api/v1/products/products/search`
- **Phương thức**: `GET`
- **Mô tả**: Tìm kiếm sản phẩm theo từ khóa tên.
- **Request**:
    - `name`: Từ khóa tìm kiếm.
- **Response**:
    ```json
    [
      {
        "id": "12345",
        "name": "Sản phẩm phù hợp",
        "price": 100.0
      },
      {
        "id": "67890",
        "name": "Sản phẩm phù hợp khác",
        "price": 150.0
      }
    ]
      

---

## **Lưu ý**
- **Validation**: Đảm bảo dữ liệu đầu vào hợp lệ trước khi xử lý.
- **Xử lý lỗi**:
    - Trả về mã lỗi phù hợp (ví dụ: `404 Not Found` nếu sản phẩm không tồn tại).
    - Sử dụng thông báo lỗi chi tiết trong Response. 
