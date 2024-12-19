# API Documentation - AuthController

## Base URL: `/api/auth`

---

### 1. **Generate a New Token**

**Endpoint**: `/token`  
**Method**: `POST`  
**Description**: Tạo token mới cho tài khoản.

**Request Parameters**:
- `accountId` (String): ID của tài khoản muốn tạo token.

**Response**:
- **200 OK**:
  ```json
  {
  "tokenValue": "[token_value]",
  "expiryDate": "[expiry_date]"
  }
### 2. **Validate Token**
- **Endpoint**: /validate 
- **Method**: GET
- **Description**: Kiểm tra tính hợp lệ của token.

**Request Parameters**:

- `tokenValue` (String): Token cần kiểm tra.
**Response**:

- 200 OK:
  ```json
  Token hợp lệ
- 401 Unauthorized:
  ```json
  Token không hợp lệ
### **Notes**
- Các API trên yêu cầu token để xác thực.
- Đảm bảo token được truyền đúng định dạng và sử dụng đúng API để kiểm tra tính hợp lệ trước khi thực hiện các yêu cầu khác.






