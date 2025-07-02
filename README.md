# 🏥 Patient Management Microservices Platform

A production-grade microservices architecture built using Java, Spring Boot, Kafka, Docker, and AWS. This platform enables secure, scalable handling of patient data with real-time analytics, billing services, and authentication.

---

## ⚙️ Architecture Overview

This system is composed of four core services:
- **Patient Service** – Manages patient records and CRUD operations.
- **Auth Service** – Centralized JWT-based authentication and authorization.
- **Billing Service** – gRPC service for invoice generation and payment tracking.
- **Analytics Service** – Consumes Kafka events for real-time health data insights.

All services communicate over REST/gRPC and are containerized via Docker.

![Architecture Diagram](./assets/architecture.png) <!-- Optional: include your system diagram -->

---

## 🚀 Features

- ✅ JWT-based authentication & secure API Gateway
- ✅ Real-time Kafka event streaming (Apache Kafka + Protobuf)
- ✅ gRPC for efficient inter-service communication
- ✅ Dockerized with Docker Compose and AWS ECS Fargate deployment
- ✅ Local AWS testing using LocalStack
- ✅ Infrastructure as Code using AWS CloudFormation

---

## 🧰 Tech Stack

| Category      | Tools / Frameworks                                    |
|---------------|--------------------------------------------------------|
| Language      | Java 17                                                |
| Backend       | Spring Boot, gRPC, Hibernate, REST, DTO Layering       |
| Messaging     | Apache Kafka, Protobuf                                 |
| Auth & Security | JWT, Spring Security, OAuth2                         |
| Database      | PostgreSQL (Amazon RDS), Flyway                        |
| DevOps        | Docker, Docker Compose, AWS ECS, CloudFormation        |
| Testing       | JUnit, Mockito                                         |
| Infra (Local) | LocalStack, AWS CLI, Java SDK                          |

---

## 🛠️ Setup Instructions

### Prerequisites
- Java 17+
- Docker & Docker Compose
- Maven
- AWS CLI (configured)
- LocalStack (for local AWS simulation)

### 1. Clone the repo

```bash
git clone https://github.com/joshiatharv1/patient-management-platform.git
cd patient-management-platform
