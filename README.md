# \# Patient Management System – Microservices Architecture

# 

# This project is a microservices-based Patient Management System built using Spring Boot, secured with JWT authentication, containerized via Docker, and routed through an API Gateway.

# 

# \## 🔧 Technologies Used

# \- \*\*Java 21\*\*, \*\*Spring Boot 3.5\*\*

# \- \*\*Spring Cloud Gateway\*\*

# \- \*\*Spring Security + JWT\*\*

# \- \*\*PostgreSQL\*\*

# \- \*\*Docker + Docker Compose\*\*

# \- \*\*gRPC (for Analytics Service)\*\*

# \- \*\*Kafka\*\* (future analytics events)

# \- \*\*OpenAPI/Swagger\*\*

# 

# \## 📦 Microservices

# 

# \### 1. Auth Service (`auth-service`)

# \- Handles user login and JWT generation

# \- Validates tokens via `/validate` endpoint

# \- Loads user data via `data.sql`

# \- Exposed route via API Gateway: `/api/auth/\*\*`

# 

# \### 2. Patient Service (`patient-app`)

# \- Manages patient CRUD operations

# \- Secured with JWT via Gateway filter

# \- Exposed via: `/api/patients/\*\*`

# 

# \### 3. Analytics Service (`analytics-service`)

# \- Receives data via gRPC

# \- Processes and stores analytics info (WIP)

# 

# \## 🌐 API Gateway

# \- Single entrypoint on `localhost:4004`

# \- Routes:

# &nbsp; - `/api/auth/\*\*` → Auth Service

# &nbsp; - `/api/patients/\*\*` → Patient Service

# &nbsp; - `/api-docs/auth` and `/api-docs/patients` for OpenAPI

# 

# \## 🔒 JWT Authentication Flow

# 1\. Login at `/api/auth/login`

# 2\. Get JWT token in response

# 3\. Pass token in `Authorization: Bearer <token>` header

# 4\. Gateway uses custom `JwtValidation` filter to authorize

# 

# \## 🐳 Dockerized Setup

# Each service and database runs in a container:

# ```bash

# docker-compose up --build



