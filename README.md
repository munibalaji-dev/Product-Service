Product Service API

Overview

The Product Service API is a Spring Boot-based backend application that provides RESTful APIs to manage products. It supports full CRUD operations, integrates with an external FakeStore API, and follows a clean layered architecture using DTOs and entity mapping.

---

Features

* Create Product
* Get All Products
* Get Product by ID
* Update Product
* Delete Product
* Category Mapping using JPA (`@ManyToOne`)
* JPA Inheritance Strategies Implementation
* * DTO Mapping (External FakeStore API ↔ Internal DTO ↔ Entity)
* External API Integration (FakeStore API)

---
JPA Inheritance Strategies Implemented
----------------------------------------

This project demonstrates different inheritance mapping strategies in JPA:

1. Single Table Strategy
---------------------------

All classes stored in one table

Uses a discriminator column

Faster performance but may contain null values

2. Joined Table Strategy
---------------------------
Separate tables for each class

Uses joins to fetch data

Better normalization

3. Table Per Class Strategy
-------------------------------
Each class has its own table

No joins required

May cause data duplication

4. Mapped Superclass
----------------------
Base class is not a table

Common fields are inherited by child entities

Tech Stack
--------------
* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* REST APIs
* Maven

---

Project Structure

```
src/main/java/com/balaji/productservice
│
|-- controllers     # REST Controllers
|-- services        # Business Logic
|-- repositories    # JPA Repositories
|-- models          # Entity Classes
|-- inheritance     # Inheritance mapping strategy
|-- dtos            # Data Transfer Objects
|-- clients         # External API Calls
|-- mappers         # DTO ↔ Entity Conversion
```

---

API Endpoints

------------------------------------------------
| Method | Endpoint       | Description       |
| ------ | -------------- | ----------------- |
| GET    | /products      | Get all products  |
| GET    | /products/{id} | Get product by ID |
| POST   | /products      | Create product    |
| PUT    | /products/{id} | Update product    |
| DELETE | /products/{id} | Delete product    |
--------------------------------------------------
---

How to Run the Project

1. Clone the Repository

```
git clone https://github.com/munibalaji-dev/product-service.git
```

2. Navigate to Project Folder

```
cd product-service
```

3. Run the Application

```
mvn spring-boot:run
```

---

Sample Request (POST / PUT)

```json
{
  "title": "iPhone",
  "description": "Apple mobile",
  "price": 999.0,
  "image": "image_url",
  "category": "Electronics"
}
```

---

Concepts Covered

* REST API Design
* Layered Architecture
* JPA Relationships
* External API Integration
* Exception Handling

---

Future Enhancements

* Add Authentication (JWT)
* Add Pagination & Sorting

---
Author

**Muni Balaji N**

---
