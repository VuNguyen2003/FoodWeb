# API Documentation - AuthController

## Base URL: `/api/auth`

---

### 1. Generate a New Token

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
