Product Management System

A RESTful backend application built using Java and Spring Boot to manage product information efficiently through CRUD operations.

=> About the Project

The Product Management System provides REST APIs for creating, viewing, updating, and deleting product details.

The application follows a layered architecture to keep the code organized, maintainable, and easy to understand.

🛠️ Tech Stack

Language: Java
Framework: Spring Boot
ORM: Hibernate
Data Access: Spring Data JPA
Database: PostgreSQL
Build Tool: Maven
API Testing: Postman
IDE: IntelliJ IDEA
✨ Key Features

Create product
View all products
View product by ID
Update product
Delete product
PostgreSQL database integration
RESTful API architecture
JPA/Hibernate-based persistence
Request validation
📂 Project Structure

src └── main ├── java │ └── edu.productmanagement │ ├── controller │ ├── service │ ├── repository │ ├── entity │ ├── dto │ └── config │ └── resources └── application.properties

🔗 API Endpoints

HTTP Method| Endpoint| Purpose POST| "/api/v1/products"| Create product GET| "/api/v1/products"| Get all products GET| "/api/v1/products/{id}"| Get product by ID PUT| "/api/v1/products/{id}"| Update product DELETE| "/api/v1/products/{id}"| Delete product

🗄️ Database

PostgreSQL is used to store product data.

Spring Data JPA and Hibernate are used for database interaction and persistence.

«For security, database passwords and other sensitive credentials are not included in this repository.»

⚙️ How to Run

Clone the repository
git clone

Open the project
Open the project in IntelliJ IDEA.

Configure PostgreSQL
Create a PostgreSQL database and configure your database credentials locally in "application.properties".

Run the application
Run the main Spring Boot application class.

Test the APIs
Use Postman to test the available REST endpoints.

🎯 Learning Outcomes

Through this project, I practiced:

Spring Boot application development
REST API development
CRUD operations
Spring Data JPA
Hibernate
PostgreSQL integration
Layered architecture
API testing with Postman
👩‍💻 Author

Sakshi Dhanokar

Java Full Stack Developer | Java | Spring Boot | React.js | SQL
