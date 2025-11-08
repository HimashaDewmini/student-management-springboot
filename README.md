# 🎓 Student Management REST API (Spring Boot)

## 🧩 Overview
This project is a simple **Student Management REST API** built using **Spring Boot 3**, **Spring Data JPA**, and **MySQL**.  

---
## 🚀 Features

✅ Manage Students (Add, View, Update, Delete)  
✅ Pagination & Sorting for `GET /api/students`  
✅ Search by **name** or **course**  
✅ Field validation (email format, not null, age > 18)  
✅ Integrated Swagger UI (`springdoc-openapi`)  
✅ MySQL + Spring Boot app fully containerized with **Docker Compose**

---

## 🚀 Technologies Used
- **Spring Boot 3+**
- **Spring Data JPA**
- **MySQL** (or H2 for testing)
- **Jakarta Validation**
- **Lombok**
- **ModelMapper**
- **Swagger UI (springdoc-openapi)**
- **Maven**
- **Docker, Docker Compose**

---
## Setup (XAMPP)
1. Start Apache and MySQL in XAMPP.
2. Create database in phpMyAdmin: `CREATE DATABASE studentdb;`
3. Update `src/main/resources/application.properties` DB credentials if needed.
4. Build & run:
   ```bash
   mvn clean package
   mvn spring-boot:run


