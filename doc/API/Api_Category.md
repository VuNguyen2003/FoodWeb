# API Documentation - CategoryController

## Base URL: `/api/v1/categories`

---

### 1. Create a New Category

- **Endpoint**: `/`  
- **Method**: `POST`  
- **Description**: Thêm một danh mục mới.

- **Request Body**:
    ```json
    {
      "name": "Beverages",
      "description": "Drinks and refreshments"
    }
- **Response**:

- **200 OK**:
  ```json
  {
    "id": "1",
    "name": "Beverages",
    "description": "Drinks and refreshments"
  }
### 2. **Get Category by ID**
- **Endpoint**: `/{id}`
- **Method**: `GET`
- **Description**: Lấy thông tin chi tiết của danh mục dựa trên ID.

- **Path Parameters**:

- `id` (String): ID của danh mục cần lấy.
- **Response**:

  - **200 OK**:
    ```json
    {
      "id": "1",
      "name": "Beverages",
      "description": "Drinks and refreshments"
    }
  - **404 Not Found**:
    ```json
    {
      "error": "Category not found with ID: {id}"
    }
### 3. **Get All Categories**
- **Endpoint**: `/`
- **Method**: `GET`
- **Description**: Lấy danh sách tất cả các danh mục.

- **Response**:

  - **200 OK**:
    ```json
    [
      {
        "id": "1",
        "name": "Beverages",
        "description": "Drinks and refreshments"
      },
      {
        "id": "2",
        "name": "Snacks",
        "description": "Quick bites and finger foods"
      }
    ]
## 4. **Update a Category**
- **Endpoint**: `/{id}`
- **Method**: `PUT`
- **Description**: Cập nhật thông tin danh mục dựa trên ID.

- **Path Parameters**:

- `id` (String): ID của danh mục cần cập nhật.
- **Request Body**:
  ```json
  {
    "name": "Beverages Updated",
    "description": "Updated description for beverages"
  }
- **Response**:

  - **200 OK**:
    ```json
    {
      "id": "1",
      "name": "Beverages Updated",
      "description": "Updated description for beverages"
    }
  - **404 Not Found**:
    ```json
    {
      "error": "Category not found with ID: {id}"
    }

### 5. **Delete a Category**
- **Endpoint**: `/{id}`
- **Method**: `DELETE`
- **Description**: Xóa danh mục dựa trên ID.

- **Path Parameters**:

- `id` (String): ID của danh mục cần xóa.
- **Response**:

  - **204 No Content**:
    ```json
    (no content)
  - **404 Not Found**:
    ```json
    {
      "error": "Category not found with ID: {id}"
    }
### **Notes**
- API hỗ trợ các thao tác CRUD (Tạo, Đọc, Cập nhật, Xóa) cho danh mục.
- Khi xóa hoặc cập nhật danh mục, nếu không tìm thấy danh mục với ID tương ứng, hệ thống trả về lỗi 404 Not Found.
- Các lỗi và thông báo chi tiết sẽ được xử lý và trả về trong phần Response.