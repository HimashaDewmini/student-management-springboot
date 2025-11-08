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
🚀 How to Run
1. Clone the Repository
git clone https://github.com/HimashaDewmini/student-management-springboot.git

2. Navigate to the Project
cd student-management-springboot

3. Build and Run
mvn spring-boot:run


The application will start at:
👉 http://localhost:8080

---
🧠 Application Properties
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

---
🔗 API Endpoints

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

🧪 API Testing (Postman)
You can import your API endpoints into Postman and test the CRUD functionality.

Example JSON for POST request:
{
  "name": "Himasha Dewmini",
  "email": "himasha@gmail.com",
  "age": 24,
  "course": "Software Engineering"
}
Example Query Parameters:
/api/students?page=0&size=5&sort=name,asc
/api/students/search?name=Himasha
/api/students/search?course=Software Engineering

---

⚡ Swagger UI 

Start the app, then visit:
👉 http://localhost:8080/swagger-ui/index.html

---

🧱 Error Handling Example

| Scenario          | Response Code | Example Message                  |
| ----------------- | ------------- | -------------------------------- |
| Invalid Email     | 400           | `"Invalid email format"`         |
| Age < 18          | 400           | `"Age must be greater than 18"`  |
| Student Not Found | 404           | `"Student not found with ID: 1"` |

---

🧾 License

This project was developed for academic purposes — part of the Spring Boot REST API assignment with Docker integration.

---

👨‍💻 Developer

Himasha Dewmini 
Undergraduate, University of Sri Jayewardenepura
Faculty of Technology 

