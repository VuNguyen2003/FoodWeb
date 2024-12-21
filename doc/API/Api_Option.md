# API Documentation - OptionController

## Base URL: `/api/options`

---

### 1. Get All Options

- **Endpoint**: `/`  
- **Method**: `GET`  
- **Description**: Lấy danh sách tất cả các tùy chọn.

- **Response**:
  - **200 OK**:
    ```json
    [
      {
        "id": "1",
        "name": "Small",
        "categoryId": "size"
      },
      {
        "id": "2",
        "name": "Red",
        "categoryId": "color"
      }
    ]
### 2. **Get Option by ID**
- **Endpoint**: `/{id}`
- **Method**: `GET`
- **Description**: Lấy thông tin tùy chọn theo ID.

- **Path Parameters**:

- `id` (String): ID của tùy chọn cần lấy.
- **Response**:

  - **200 OK**:
      ```json
      {
        "id": "1",
        "name": "Small",
        "categoryId": "size"
      }
  - **404 Not Found**:
      ```json
      {
        "error": "Option not found with ID: {id}"
      }
### 3. **Create Option**
- **Endpoint**: `/`
- **Method**: `POST`
- **Description**: Tạo một tùy chọn mới.

- **Request Body**:
    ```json
    {
      "name": "Medium",
      "categoryId": "size"
    }
- **Respone**:
  - **200 OK**:
      ```json
      {
        "id": "3",
        "name": "Medium",
        "categoryId": "size"
      }
### 4. **Update Option**
- **Endpoint**: /{id}
- **Method**: PUT
- **Description**: Cập nhật thông tin của một tùy chọn theo ID.

- **Path Parameters**:

- `id` (String): ID của tùy chọn cần cập nhật.
- **Request Body**:
    ```json
    {
      "name": "Large",
      "categoryId": "size"
    }
- **Respone**:
  - **200 Ok**:
      ```json
      {
        "id": "3",
        "name": "Large",
        "categoryId": "size"
      }
  - **404 Not Found**:
      ```json
      {
        "error": "Option not found with ID: {id}"
      }
### 5. **Delete Option**
- **Endpoint**: `/{id}`
- **Method**: `DELETE`
- **Description**: Xóa một tùy chọn theo ID.

- **Path Parameters**:

- `id` (String): ID của tùy chọn cần xóa.
- **Response**:

  - **204 No Content**: Tùy chọn đã được xóa thành công.
  - **404 Not Found**:
      ```json
      {
        "error": "Option not found with ID: {id}"
      }
### **Notes**
- **Validation**: Dữ liệu đầu vào được kiểm tra trong phần Request Body, các lỗi sẽ trả về mã lỗi HTTP phù hợp.
- **HTTP Status Codes**:
  - **`200 OK`**: Thành công lấy hoặc cập nhật tùy chọn.
  - **`204 No Content`**: Thành công xóa tùy chọn.
  - **`404 Not Found`**: Không tìm thấy tùy chọn tương ứng.