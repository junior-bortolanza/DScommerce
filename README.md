# 🛒 DSCommerce – Production-Ready E-commerce Backend API  

A production-oriented e-commerce backend built with Java and Spring Boot.  

This project simulates a real-world commerce system featuring authentication, role-based access control, transactional order processing, and structured validation.

Designed with clean architecture principles and scalable backend practices in mind.

## 🏗 Technical Stack  

- Java 21  
- Spring Boot  
- Spring Data JPA  
- PostgreSQL  
- Jakarta Bean Validation  
- JWT Authentication  
- Maven  

## 🚀 Core Capabilities  

- 🔐 JWT Authentication & Authorization  
- 👤 Authenticated User Endpoint (`/users/me`)  
- 📦 Full Product CRUD  
- 🗂 Category Management  
- 🛒 Order Processing  
- 🧩 DTO Pattern (Request/Response isolation)  
- 🛡 Annotation-Based Input Validation  
- ⚠ Centralized Exception Handling  
- 🏛 Layered Architecture (Controller → Service → Repository)  


## 🧠 Engineering Decisions  

Instead of building a simple CRUD demo, the system was structured to reflect production-ready backend development practices.

### Architecture
- Clear separation of concerns between layers  
- Business logic isolated in services  
- Database access abstracted via repositories  
- DTO mapping to prevent entity exposure  

### Security
- Stateless authentication using JWT  
- Protected routes requiring valid tokens  
- Structure ready for role-based authorization  

### Validation & Reliability
- Request-level validation using annotations  
- Consistent error response structure  
- Business rules enforced at service level  

## 📡 API Overview  

### 🔐 Authentication  

**POST /auth/login**

#### Request

```http
POST /auth/login
Content-Type: application/json
```

```json
{
  "email": "user@email.com",
  "password": "123456"
}
```

#### Response – 200 OK

```json
{
  "accessToken": "jwt-token-example",
  "tokenType": "Bearer"
}
```

#### Response – 401 Unauthorized

```json
{
  "timestamp": "2026-02-16T12:45:00Z",
  "status": 401,
  "error": "Unauthorized",
  "message": "Invalid email or password",
  "path": "/auth/login"
}
```


### 📦 Products  

```http
GET /products
GET /products/{id}
POST /products
PUT /products/{id}
DELETE /products/{id}
```


### 🛒 Orders  

```http
POST /orders
GET /orders/{id}
```


### 👤 User  

```http
GET /users/me
Authorization: Bearer <token>
```

---

### 🗂 Categories  

```http
GET /categories
```

## 🌍 Deployment Readiness  

The application is structured for cloud deployment using environment-based configuration.

- Externalized database credentials  
- Stateless authentication  
- Production-ready layered structure  
- Compatible with platforms like Render, Railway, AWS, or Docker environments  

## 🎯 What This Project Demonstrates  

✔ Backend system design  
✔ RESTful API best practices  
✔ Authentication & authorization implementation  
✔ Transactional service layer logic  
✔ Validation and exception handling strategy  
✔ Clean, maintainable, and scalable architecture 

## 🎞️ Preview 
<img width="1919" height="987" alt="image" src="https://github.com/user-attachments/assets/bfc035c7-ae13-487a-a71f-9eeaa58893a4" />


