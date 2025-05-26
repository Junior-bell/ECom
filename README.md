🛒 E-Commerce Website

Welcome to the E-Commerce Website, a vibrant full-stack application that brings online shopping to life! Built with 🚀 Spring Boot for a robust backend and 🎨 React.js for a dynamic frontend, this project lets users browse products, manage carts, sign up or log in, place orders, and more. Admins can also manage products through a dedicated dashboard. 
This stylish README guides you through the project, from setup to contribution, with clear steps for developers of all levels. Let’s dive into the world of e-commerce! 🌟
📋 Table of Contents

✨ Features
🛠️ Tech Stack
📦 Prerequisites
⚙️ Setup Instructions
Backend: Spring Boot
Frontend: React.js
Database Configuration


🚀 Running the Application
🔗 API Endpoints
🤝 Contributing
📜 License

✨ Features
This e-commerce platform is packed with functionality:

🛍️ Product Catalog: Browse and search products by category or name.
🔐 User Authentication: Secure sign-up, login, and account management with JWT.
🛒 Shopping Cart: Add, update, or remove items before checkout.
📦 Order Processing: Place orders and track order history.
🖥️ Admin Dashboard: Add, edit, or delete products (admin-only).
📱 Responsive Design: Seamless experience on desktop and mobile.

🛠️ Tech Stack



Category
Technology



Backend
🌱 Spring Boot: RESTful APIs  📚 Spring Data JPA: Hibernate ORM  🔒 Spring Security: JWT authentication  🗄️ Oracle SQL: Production database  💾 H2 Database: Development/testing


Frontend
⚛️ React.js: Dynamic UI  🧭 React Router: Client-side routing  📡 Axios: API requests  🎨 CSS/Bootstrap: Styling


Tools
🛠️ Maven: Backend dependencies  📦 Node.js/NPM: Frontend dependencies  🐙 Git: Version control


📦 Prerequisites
Get these installed before starting:

☕ Java 17+: For Spring Boot.
🛠️ Maven 3.6+: Backend build tool.
🌐 Node.js 16+: For React.
🗄️ Oracle Database 19c+: For production (optional for local dev with H2).
💾 H2 Database: Included as a dependency.
🐙 Git: For cloning the repo.
💻 IDE: IntelliJ IDEA, Eclipse, or VS Code.
📬 Postman (optional): For API testing.

⚙️ Setup Instructions
Backend: Spring Boot

Clone the Repository:
git clone https://github.com/your-username/ecommerce-website.git
cd ecommerce-website/backend


Install Dependencies:
mvn clean install


Configure Application Properties:Edit backend/src/main/resources/application.properties for your database:

H2 (Dev/Testing):spring.datasource.url=jdbc:h2:mem:ecommerce;DB_CLOSE_DELAY=-1
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


Oracle SQL (Production):spring.datasource.url=jdbc:oracle:thin:@localhost:1521:XE
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.jpa.database-platform=org.hibernate.dialect.OracleDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true




Set Up Databases:

H2: No setup needed; runs in-memory.
Oracle SQL: Install Oracle Database or use a cloud instance. Create a schema (e.g., ecommerce).



Frontend: React.js

Navigate to Frontend:
cd ../frontend


Install Dependencies:
npm install


Configure API URL:Set the backend API base URL (e.g., in a constants file or .env):
API_BASE_URL=http://localhost:8080/api



Database Configuration

💾 H2: Auto-creates tables via JPA (spring.jpa.hibernate.ddl-auto=update). Access the H2 console at http://localhost:8080/h2-console (enable in properties if needed).
🗄️ Oracle SQL: Requires a running database and schema. JPA handles table creation for entities like Product, User, and Order.

🚀 Running the Application

Start the Backend:
cd backend
mvn spring-boot:run

Runs on http://localhost:8080.

Start the Frontend:
cd frontend
npm start

Runs on http://localhost:3000 and opens in your browser.

Access the App:

🌐 Visit http://localhost:3000 for the frontend.
🛠️ Test APIs with Postman (e.g., GET http://localhost:8080/api/products).
💾 View H2 data at http://localhost:8080/h2-console.



🔗 API Endpoints
Key RESTful APIs for the frontend:



Endpoint
Method
Description



/api/products
GET
List all products


/api/products/{id}
GET
Get product by ID


/api/products
POST
Add product (admin-only)


/api/auth/signup
POST
Register a new user


/api/auth/login
POST
Log in and get JWT


/api/orders
POST
Create an order


/api/orders/user/{userId}
GET
Get user’s order history


/api/cart
POST
Manage cart (optional)


Full API docs to be added.
🤝 Contributing
We love contributions! Here’s how to join in:

🍴 Fork the repository.
🌿 Create a branch: git checkout -b feature/your-feature.
💻 Make changes and commit: git commit -m "Add your feature".
🚀 Push: git push origin feature/your-feature.
📬 Open a pull request with a clear description.

Guidelines:

✍️ Write clear commit messages.
🧪 Test changes locally.
📏 Follow coding style (e.g., consistent naming).

📜 License
This project is licensed under the MIT License. See the LICENSE file for details.

🎉 Thank you for exploring the E-Commerce Website! Got questions? Open an issue or contact the maintainers. Let’s build something amazing together! 🚀
