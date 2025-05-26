E-Commerce Website

Welcome to the E-Commerce Website project, a full-stack web application built with Spring Boot for the backend and React.js for the frontend. This project simulates a fully functional online store where users can browse products, add items to a cart, sign up or log in, place orders, and manage their accounts. It also includes an admin dashboard for managing products.
This README provides an overview of the project, instructions for setting it up locally, and guidelines for contributing. Whether you're a developer looking to contribute or someone exploring the code, this guide will help you get started.
Table of Contents

Features
Tech Stack
Prerequisites
Setup Instructions
Backend Setup (Spring Boot)
Frontend Setup (React.js)
Database Configuration


Running the Application
API Endpoints
Contributing
License

Features
This e-commerce website includes the following features:

Product Catalog: Browse and search products by category or name.
User Authentication: Sign up, log in, and manage user accounts with secure JWT-based authentication.
Shopping Cart: Add, update, or remove items from the cart before checkout.
Order Processing: Place orders and view order history.
Admin Dashboard: Manage products (add, edit, delete) with admin-only access.
Responsive Design: A user-friendly interface that works on both desktop and mobile devices.

Tech Stack

Backend:
Spring Boot: Java framework for building RESTful APIs.
Spring Data JPA: For database operations with Hibernate as the ORM.
Spring Security: For authentication and authorization using JWT.
Oracle SQL: Primary relational database for production data storage.
H2 Database: In-memory database for development and testing.


Frontend:
React.js: JavaScript library for building dynamic user interfaces.
React Router: For client-side routing.
Axios: For making HTTP requests to the backend.
CSS/Bootstrap: For styling and responsive design.


Tools:
Maven: Dependency management for the backend.
Node.js/NPM: For managing frontend dependencies.
Git: Version control.



Prerequisites
Before setting up the project, ensure you have the following installed:

Java 17 or higher: For running the Spring Boot backend.
Maven 3.6 or higher: For building the backend.
Node.js 16 or higher: For running the React frontend.
Oracle Database 19c or higher: For the production database (optional for local development if using H2).
H2 Database: Included as a dependency for development and testing.
Git: For cloning the repository.
IDE: IntelliJ IDEA, Eclipse, or VS Code for development.
Postman (optional): For testing API endpoints.

Setup Instructions
Backend Setup (Spring Boot)

Clone the Repository:
git clone https://github.com/your-username/ecommerce-website.git
cd ecommerce-website/backend


Install Dependencies:Run the following command to download dependencies defined in pom.xml:
mvn clean install


Configure Application Properties:Update backend/src/main/resources/application.properties to configure either Oracle SQL or H2 based on your environment:

For H2 (Development/Testing):spring.datasource.url=jdbc:h2:mem:ecommerce;DB_CLOSE_DELAY=-1
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


For Oracle SQL (Production):spring.datasource.url=jdbc:oracle:thin:@localhost:1521:XE
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.jpa.database-platform=org.hibernate.dialect.OracleDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true




Set Up Databases:

H2: No setup required; H2 runs in-memory and is created automatically when the application starts.
Oracle SQL: Install Oracle Database locally or use a cloud instance. Create a schema (e.g., ecommerce) and ensure the credentials match your application.properties.



Frontend Setup (React.js)

Navigate to the Frontend Directory:
cd ../frontend


Install Dependencies:Run the following command to install Node.js packages:
npm install


Configure API Base URL:Update the API base URL in your React code (e.g., in a constants file or environment variable) to point to the backend:
API_BASE_URL=http://localhost:8080/api



Database Configuration

H2 Database: Used for development and testing. Spring Data JPA automatically creates tables based on entity classes (e.g., Product, User, Order) when spring.jpa.hibernate.ddl-auto=update. Access the H2 console at http://localhost:8080/h2-console (enable in application.properties if needed).
Oracle SQL: Used for production. Ensure the Oracle database is running and the schema is created before starting the backend. JPA will manage table creation based on entities.

Running the Application

Start the Backend:In the backend directory, run:
mvn spring-boot:run

The backend will start on http://localhost:8080.

Start the Frontend:In the frontend directory, run:
npm start

The frontend will start on http://localhost:3000 and open in your default browser.

Access the Application:

Open http://localhost:3000 to view the frontend.
Use Postman or cURL to test backend APIs (e.g., GET http://localhost:8080/api/products).
For H2, access the database console at http://localhost:8080/h2-console to inspect data.



API Endpoints
The backend exposes RESTful APIs for the frontend to consume. Key endpoints include:

Products:
GET /api/products: List all products.
GET /api/products/{id}: Get product details by ID.
POST /api/products: Add a new product (admin only).


Authentication:
POST /api/auth/signup: Register a new user.
POST /api/auth/login: Log in and receive a JWT.


Orders:
POST /api/orders: Create a new order.
GET /api/orders/user/{userId}: Get a user’s order history.


Cart:
Managed on the frontend or via backend endpoints (e.g., POST /api/cart).



For a full list of endpoints, refer to the backend documentation (to be added).
Contributing
We welcome contributions! To contribute:

Fork the repository.
Create a new branch (git checkout -b feature/your-feature).
Make your changes and commit (git commit -m "Add your feature").
Push to your branch (git push origin feature/your-feature).
Open a pull request with a clear description of your changes.

Please follow these guidelines:

Write clear, concise commit messages.
Test your changes locally before submitting.
Adhere to the project’s coding style (e.g., consistent naming conventions).

License
This project is licensed under the MIT License. See the LICENSE file for details.

Thank you for exploring the E-Commerce Website project! If you have questions or need help, feel free to open an issue or contact the maintainers.
