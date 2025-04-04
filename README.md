
# 🚗 Vehicle Rental Service API

A robust and secure RESTful API for managing a vehicle rental service built using **Spring Boot** and **MySQL**. It includes features for managing vehicles, bookings, users, and payments with role-based access and JDBC authentication.

---

## 📂 Project Structure

- **Spring Boot** for building the backend REST API
- **MySQL** as the relational database
- **Spring Security** with JDBC for authentication & authorization
- Clean separation into controllers, services, and repositories

---

## 🚀 Features

- 🔐 Role-based user access (Admin & User)
- 🚘 Vehicle CRUD management
- 📅 Booking system with user association
- 💳 Payment tracking
- 🧑‍💼 User management for admins

---

## 🧪 API Endpoints

All endpoints are prefixed with `/api`.

### 📦 Booking Endpoints

| Method | Endpoint                        | Description                      |
|--------|----------------------------------|----------------------------------|
| POST   | `/bookings`                     | Create a new booking             |
| GET    | `/bookings`                     | List all bookings                |
| GET    | `/bookings/{id}`                | Get booking by ID                |
| GET    | `/bookings/user/{username}`     | Get bookings by username         |
| PUT    | `/bookings/{id}`                | Update booking                   |
| DELETE | `/bookings/{id}`                | Delete booking                   |

---

### 💳 Payment Endpoints

| Method | Endpoint         | Description                |
|--------|------------------|----------------------------|
| GET    | `/payments`      | Get all payments           |
| GET    | `/payments/{id}` | Get payment by ID          |

---

### 👤 User Endpoints

| Method | Endpoint    | Description             |
|--------|-------------|-------------------------|
| GET    | `/users`    | Get all users           |
| POST   | `/users`    | Add a new user          |
| PUT    | `/users`    | Update existing user    |

---

### 🚗 Vehicle Endpoints

| Method | Endpoint         | Description                    |
|--------|------------------|--------------------------------|
| GET    | `/vehicles`      | Get all vehicles               |
| GET    | `/vehicles/{id}` | Get vehicle by ID (with bookings) |
| POST   | `/vehicles`      | Add a new vehicle              |
| PUT    | `/vehicles/{id}` | Update vehicle details         |
| DELETE | `/vehicles/{id}` | Delete vehicle                 |

---

## 🛡️ Security

- **Spring Security** is configured using JDBC authentication
- User roles: `ROLE_USER`, `ROLE_ADMIN`
- Database-backed user credential storage

---

## 💻 Tech Stack

## 💻 Tech Stack

- Java 24 ✅
- Spring Boot 3+ ✅
- Spring Data JPA ✅
- Spring Security (JDBC) ✅ 
- MySQL ✅
- Maven ✅

---

## 📦 Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/shubham-vaishnav-13/Vehicle-Rental-Service.git
   ```

2. **Set up the MySQL database**

   Create a database:
   ```sql
   CREATE DATABASE vehicle_rental;
   ```

3. **Configure `application.properties`**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/vehicle_rental
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

5. Use Postman or Swagger to test the API!

---

## 📂 Folder Structure

```
├── controller/
├── model/
├── repository/
├── service/
├── dto/
└── VehicleRentalApplication.java
```

---

## 🤝 Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you'd like to change or improve.

---

## 🧑‍💻 Author

**Shubham Vaishnav**  
[GitHub](https://github.com/shubham-vaishnav-13)

---

## 📃 License

This project is licensed under the [MIT License](LICENSE).
