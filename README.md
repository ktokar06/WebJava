<h1 align="center">Hi there, I'm<a ></a> Kirill</a> 
<img src="https://github.com/blackcater/blackcater/raw/main/images/Hi.gif" height="32"/></h1>
<h3 align="center"> Student, Java Developer 🇷🇺 </h3>


# 📜 Java Project: Order Management System

This project is a Java-based web application designed to manage orders, users, and reviews. The system leverages the Spring Framework for application architecture, integrates with MySQL for database storage, and implements Spring Security for authentication and authorization.


## 📦 Installation

1. Clone repositories:
   
 ```bash
 git clone https://github.com/ktokar06/PythonBook.git
 ```

2. Go to the project directory:
   
```bash
cd Phonebook
```


## 💻 Features

1. User Authentication and Roles:
  
    - Users can register and log in.
  
    - Roles include ROLE_USER and ROLE_ADMIN.
  
    - Admins have additional access to manage the application.

2. Order Management:

    - Users can create, view, and manage orders.
  
    - Orders are associated with managers, delivery personnel, and clients.

3. Review System:

    - Users can leave reviews for completed orders, including ratings and comments.

4. Security:

    - Passwords are encrypted using BCryptPasswordEncoder.
  
    - Access control is enforced via role-based authorization.

5. RESTful Endpoints:
  
    - A modular architecture allows for scalability and maintainability.

## 🛠️ Technology Stack

- Programming Language: Java

- Framework: Spring Boot

- Database: MySQL (with Hibernate ORM)

- Security: Spring Security

- Frontend: Thymeleaf templates

- Build Tool: Maven

## 📂 Project Structure

### Database Schema

``person`` Table

- Stores user information with the following fields:

    - id: Auto-increment primary key

    - username: User's name
    
    - year_of_birth: Birth year
    
    - password: Encrypted password
    
    - role: User role (default: ROLE_USER)

`orders` Table : Manages order data with relationships to users (manager, deliveryman, client).

`review` Table :  Stores reviews with references to specific orders.

## Key Packages and Classes

1. Controllers:

    - `AuthController:` Handles user authentication (login and registration).
    
    - `AdminController:` Admin-specific operations.
    
    - `UserController:` User operations and navigation.

2. DTOs:

    - `CreateOrderDTO:` For creating new orders.
    
    - `OrderRequestDTO:` For transferring order data.

3. Models:

    - `Person:` Represents users.
    
    - `Order:` Represents orders.
    
    - `Review:` Represents reviews.

4. Repositories:

   -  Provide CRUD operations for Person, Order, and Review models.

5. Services:

    - `AdminService:` Admin operations.
    
    - `OrderService:` Order-related logic.
    
    - `RegistrationService:` Handles user registration.

6. Security:

    - `PersonDetails:` Implements UserDetails for security.
    
    - `SecurityConfig:` Configures Spring Security.

