# 🏦 Banking Microservices System

A production-style **Spring Boot microservices architecture** built using **Spring Cloud, Eureka, API Gateway, Docker**, and **profile-based configuration**.

This project demonstrates **service discovery, API routing, containerized deployment**, and **observability** — designed for real-world backend systems.

---

## 🧩 Architecture Overview

```
Client
  │
  ▼
API Gateway (8080)
  │
  ├── Account Service (8081)
  ├── Transaction Service (8082)
  └── Auth Service (8083)
  
Service Registry (Eureka – 8761)
```

* All requests go through **API Gateway**
* Services communicate via **Eureka Service Discovery**
* Docker handles networking & deployment
* Separate configs for **local** and **docker** environments

---

## 🧠 Services

| Service Name        | Description                    | Port |
| ------------------- | ------------------------------ | ---- |
| api-gateway         | Entry point & request routing  | 8080 |
| account-service     | Account management             | 8081 |
| transaction-service | Transactions & balance updates | 8082 |
| auth-service        | Authentication & authorization | 8083 |
| service-registry    | Eureka discovery server        | 8761 |

---

## 🌐 Service Discovery (Eureka)

Eureka Dashboard:
👉 **[http://localhost:8761](http://localhost:8761)**

All services must show **STATUS = UP**.

---

## 🔀 API Gateway Routing

| Request Path
