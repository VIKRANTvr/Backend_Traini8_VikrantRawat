## Traini8 - Training Center API

This project provides an API for managing training centers, their details, and the courses they offer. It is designed to interact with a MySQL database and exposes various endpoints for CRUD operations on training center data.

## Table of Contents
-Technologies Used
-Setup Instructions
-Database Setup
-API Testing with Postman
-Endpoints

## Technologies Used
-Java 17
-Spring Boot 2.7.9
-Spring Data JPA
-MySQL Workbench
-MySQL Database
-Postman for testing APIs

## Setup Instructions
-Install Java 17 (or a compatible version).
-Install MySQL Workbench.
-Install Postman for API testing.
-Cloning the Repository
-Clone the project repository to your system using the command:

git clone https://github.com/VIKRANTvr/traini8.git
cd traini8

## Project Setup
MySQL Database Setup:

-Create a new MySQL database for the project. You can use MySQL Workbench or command-line tools:

CREATE DATABASE traini8_db;

## Configuration:

Open the src/main/resources/application.properties file.
Configure the database connection as follows:

spring.datasource.url=jdbc:mysql://localhost:3306/traini8?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root

# Hibernate properties
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Build and Run as Spring Boot Application:

The application will start running on http://localhost:8080.

## Database Setup
To work with MySQL and view the data, you can use MySQL Workbench.

Create a database in MySQL Workbench (if not already done):

CREATE DATABASE traini8;
Schema: The application will automatically create the necessary tables based on the entity classes during runtime (via Hibernate).

## API Testing with Postman
You can test the APIs using Postman:

## POST Request - Create Training Center:

URL: http://localhost:8080/api/training-centers
Method: POST
Request Body (JSON):
json

{
  "centerName": "IT Academy",
  "centerCode": "TNA123456789", (exactly 12 character alphanumeric)
  "address": {
    "detailedAddress": "Thane , East",
    "city": "Thane",
    "state": "T",
    "pincode": "400071"
  },
  "studentCapacity": 300,
  "coursesOffered": ["Java", "Python"],
  "contactEmail": "contact@ITacademy.com",
  "contactPhone": "1234567890"
}
## GET Request - Get All Training Centers:

URL: http://localhost:8080/api/training-centers
Method: GET
This will return all training centers in the system.
GET Request - Get Training Center by ID:

URL: http://localhost:8080/api/training-centers/{id}
Method: GET
Replace {id} with the actual training center ID.
POST Request - Create Training Center Example:

You can submit additional training center data in the same format as shown in the example above.
Endpoints
POST /api/training-centers: Create a new training center.
GET /api/training-centers: Get all training centers.
GET /api/training-centers/{id}: Get a specific training center by ID.

## Thank You  
Thank you for checking out the Traini8 API!!
