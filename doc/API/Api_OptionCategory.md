# API Documentation - OptionCategoryController

## Base URL: `/api/option-categories`

---

### 1. Get All Option Categories

- **Endpoint**: `/`  
- **Method**: `GET`  
- **Description**: Lấy danh sách tất cả các danh mục tùy chọn.

- **Response**:
  - **200 OK**:
    ```json
    [
      {
        "id": "1",
        "name": "Size",
        "description": "Product sizes available"
      },
      {
        "id": "2",
        "name": "Color",
        "description": "Product colors available"
      }
    ]
### 2. **Get Option Category by ID**
- **Endpoint**: `/{id}`
- **Method**: `GET`
- **Description**: Lấy thông tin danh mục tùy chọn theo ID.

- **Path Parameters**:

- `id` (String): ID của danh mục cần lấy.
- **Response**:

  - **200 OK**:
      ```json
      {
        "id": "1",
        "name": "Size",
        "description": "Product sizes available"
      }
  - **404 Not Found**:
      ```json
      {
        "error": "Option category not found with ID: {id}"
      }
### 3. **Create Option Category**
- **Endpoint**: `/`
- **Method**: `POST`
- **Description**: Tạo một danh mục tùy chọn mới.

- **Request Body**:
    ```json
    {
      "name": "Material",
      "description": "Product materials available"
    }
- **Response**:

- **200 OK**:
    ```json
    {
      "id": "3",
      "name": "Material",
      "description": "Product materials available"
    }
## 4. **Update Option Category**
- **Endpoint**: `/{id}`
- **Method**: `PUT`
- **Description**: Cập nhật thông tin của một danh mục tùy chọn theo ID.

- **Path Parameters**:

- `id` (String): ID của danh mục cần cập nhật.
- **Request Body**:
- **Response**:

  - **200 OK**:
      ```json
      {
        "id": "3",
        "name": "Material",
        "description": "Updated product materials available"
      }
  - **404 Not Found**:
      ```json
      {
        "error": "Option category not found with ID: {id}"
      }
## 5. **Delete Option Category**
- **Endpoint**: /{id}
- **Method**: DELETE
- **Description**: Xóa một danh mục tùy chọn theo ID.

- **Path Parameters**:

- `id` (String): ID của danh mục cần xóa.
- **Response**:

  - **204 No Content**:
      `Danh mục đã được xóa thành công.`
  - **404 Not Found**:
      ```json
      {
        "error": "Option category not found with ID: {id}"
      }
### **Notes**
- **Validation**: Dữ liệu đầu vào được kiểm tra trong phần Request Body, các lỗi sẽ trả về mã lỗi HTTP phù hợp.
- **HTTP Status Codes**:
- **200 OK**: Thành công lấy hoặc cập nhật danh mục.
- **204 No Content**: Thành công xóa danh mục.
- **404 Not Found**: Không tìm thấy danh mục tương ứng.
