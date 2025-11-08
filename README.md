# 🎓 Student Management REST API (Spring Boot)

## 🧩 Overview
This project is a simple **Student Management REST API** built using **Spring Boot 3**, **Spring Data JPA**, and **MySQL**.  

---
## 🚀 Features

✅ **Student Management**: Add, View, Update, Delete  
✅ **Pagination & Sorting** for listing students  
✅ **Search functionality** by name or course  
✅ **Field Validation**: email format, not null, age > 18  
✅ **Swagger UI Integration** (`springdoc-openapi`)  
✅ **Dockerized**: Runs with MySQL container  


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
## ⚙️ Setup & Run (Using Docker)

Follow these steps to run the Student Management API using Docker:

### 1️⃣ Prerequisites
- Docker and Docker Compose installed
- JDK 17 installed (if you want to build the JAR locally)
- Optional: Postman or curl to test the API

---

### 2️⃣ Build and Run Containers

1. Open terminal in the project folder (where `docker-compose.yml` is located).

2. Build and start containers in **detached mode**:

```bash
docker-compose up --build -d

```
3.Check running containers:
```
docker ps
```
You should see:

-**student_app → Spring Boot API (port 8080)**
-**student_mysql → MySQL (port 3306)**

3️⃣ Access the API
```
Base URL: http://localhost:8080
```
4️⃣ Stop Containers
```
docker-compose down
```
---

## 🧠 Application Properties
```
spring.application.name=studentManagement
spring.datasource.url=jdbc:mysql://localhost:3306/studentdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
server.port=8080
springdoc.api-docs.path=/v3/api-docs
springdoc.swagger-ui.path=/swagger-ui.html

```
---
## 🔗 API Endpoints

| Method | Endpoint                                       | Description                             |
| ------ | ---------------------------------------------- | --------------------------------------- |
| POST   | `/api/v1/students/addstudent`                  | Create student                          |
| GET    | `/api/v1/students/{id}`                        | Get student by ID                       |
| GET    | `/api/v1/students`                             | Get all students (pagination + sorting) |
| PUT    | `/api/v1/students/{id}`                        | Update student                          |
| DELETE | `/api/v1/students/{id}`                        | Delete student                          |
| GET    | `/api/v1/students/search/by-name?name=XYZ`     | Search by name                          |
| GET    | `/api/v1/students/search/by-course?course=ABC` | Search by course                        |

---

## 🧪 API Testing (Postman)
You can import your API endpoints into Postman and test the CRUD functionality.
bash
```
Example JSON for POST request:
{
  "name": "Himasha Dewmini",
  "email": "himasha@gmail.com",
  "age": 24,
  "course": "Software Engineering"
}

Example Query Parameters:

/api/students?page=0&size=5&sort=name,asc
/api/students/search/by-name?name=Himasha
/api/students/search/by-course?course=Software Engineering
```
---

⚡ Swagger UI 
```
Start the app, then visit:
👉 http://localhost:8080/swagger-ui/index.html
```
---

## 🧱 Error Handling Example

| Scenario          | Response Code | Example Message                  |
| ----------------- | ------------- | -------------------------------- |
| Invalid Email     | 400           | `"Invalid email format"`         |
| Age < 18          | 400           | `"Age must be greater than 18"`  |
| Student Not Found | 404           | `"Student not found with ID: 1"` |

---

## 🧾 License

This project was developed for academic purposes — part of the Spring Boot REST API assignment with Docker integration.

---

## 👨‍💻 Developer

Himasha Dewmini 
Undergraduate, University of Sri Jayewardenepura
Faculty of Technology 















