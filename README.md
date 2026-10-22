# Employee Management REST API

## Project Overview

A RESTful Employee Management application developed using Java, Spring Boot, Spring Data JPA, and MySQL. The API supports creating, retrieving, updating, and deleting employee records.

## Technologies Used

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL 8
- Maven
- Jakarta Bean Validation

## Features

- Create a new employee
- Retrieve all employees
- Retrieve an employee by ID
- Update employee details
- Delete an employee
- Validate employee input, including email and salary
- Return HTTP 404 for missing employees
- Centralized exception handling

## Employee Fields

| Field | Description |
|---|---|
| id | Automatically generated employee ID |
| name | Employee name |
| email | Employee email; must be valid and unique |
| department | Employee department |
| salary | Employee salary; must be zero or greater |

## Database Setup

1. Start MySQL.
2. Create the database:

   ```sql
   CREATE DATABASE employee_db;
   ```

3. Configure the database URL, username, and password in `src/main/resources/application.properties`.
4. Do not commit real database passwords to GitHub.

## Run the Application

Open a terminal in the project root folder and run:

```powershell
.\mvnw.cmd clean test
.\mvnw.cmd spring-boot:run
```

The API will be available at:

`http://localhost:8080`

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/employees` | Create an employee |
| GET | `/api/employees` | Retrieve all employees |
| GET | `/api/employees/{id}` | Retrieve an employee by ID |
| PUT | `/api/employees/{id}` | Update an employee |
| DELETE | `/api/employees/{id}` | Delete an employee |

## Example POST Request

```json
{
  "name": "Surya Das",
  "email": "surya@example.com",
  "department": "IT",
  "salary": 25000
}
```

## Testing

The following manual API tests have passed:

- Create, read, update, and delete employee records
- Return HTTP 404 when updating a nonexistent employee
- Reject invalid email addresses with HTTP 400
- Reject negative salaries with HTTP 400

Automated Maven tests should also be run before submission.

## Project Structure

```text
src/main/java/com/codenzic/employee_management/
├── controller/
├── entity/
├── exception/
├── repository/
└── service/
```

## Author

Surya Das M.
