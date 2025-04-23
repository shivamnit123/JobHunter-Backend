# 🧠 Job Finder Backend

A Spring Boot backend application designed for managing **Companies**, their respective **Jobs**, and **Reviews**. This RESTful backend uses **Spring Data JPA** with proper **One-to-Many / Many-to-One** entity relationships and leverages **Spring Boot Actuator** for monitoring and production readiness.

---

## 🚀 Tech Stack

- **Java**
- **Spring Boot**
- **Spring Boot Actuator**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **Postman**

---

## 🗃️ Database Relationships

- 📦 **One Company → Many Jobs**
- 📝 **One Company → Many Reviews**
- 🧩 **Many Jobs ↔ One Company**
- 🧩 **Many Reviews ↔ One Company**

These relationships are mapped using `@OneToMany` and `@ManyToOne` annotations in Spring JPA.

---

## 🔧 Features

### ✅ Company Module
- Add, view, update, and delete companies.
- View all jobs and reviews posted under a company.

### ✅ Job Module
- Add, update, delete job listings linked to a specific company.
- Search for jobs using filters.

### ✅ Review Module
- Add and fetch reviews for a specific company.

### ✅ Monitoring with Spring Boot Actuator
- Track application health, metrics, beans, and more.

---

## 🧪 API Endpoints Overview

> **Base URL:** `http://localhost:8080/api`

### 🏢 Company Endpoints
| Method | Endpoint              | Description             |
|--------|-----------------------|-------------------------|
| POST   | `/companies`          | Add new company         |
| GET    | `/companies`          | Get all companies       |
| GET    | `/companies/{id}`     | Get company by ID       |
| PUT    | `/companies/{id}`     | Update company          |
| DELETE | `/companies/{id}`     | Delete company          |
| GET    | `/companies/{id}/jobs`| Get jobs for company    |
| GET    | `/companies/{id}/reviews` | Get reviews for company |

### 💼 Job Endpoints
| Method | Endpoint              | Description               |
|--------|-----------------------|---------------------------|
| POST   | `/companies/{id}/jobs`| Add job to a company      |
| GET    | `/jobs/{id}`          | Get job by ID             |
| PUT    | `/jobs/{id}`          | Update job                |
| DELETE | `/jobs/{id}`          | Delete job                |

### 📝 Review Endpoints
| Method | Endpoint                   | Description             |
|--------|----------------------------|-------------------------|
| POST   | `/companies/{id}/reviews`  | Add review to company   |
| GET    | `/reviews/{id}`            | Get review by ID        |

### 📊 Actuator Endpoints
| Endpoint             | Purpose                          |
|----------------------|----------------------------------|
| `/actuator/health`   | Application health               |
| `/actuator/metrics`  | Metrics like JVM, memory usage   |
| `/actuator/beans`    | List of Spring beans             |
| `/actuator/info`     | Custom app info (if configured)  |

> In `application.properties`:
```properties
management.endpoints.web.exposure.include=*
