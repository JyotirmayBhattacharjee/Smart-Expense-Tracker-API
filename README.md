# Smart Expense Tracker API

## Overview

Smart Expense Tracker is a RESTful web application developed using Spring Boot for managing personal expenses. The application allows users to add, view, filter, calculate totals, and delete expenses. Data is stored in memory, as required by the assignment.

A simple HTML, CSS, and JavaScript frontend is included for interacting with the API through a web browser.

---

## Features

- Add a new expense
- View all expenses
- Filter expenses by category
- Calculate total expenses
- Calculate total expenses by category
- Delete an expense
- Input validation
- Global exception handling
- Interactive Swagger API documentation
- Unit tests using JUnit

---

## Tech Stack

- Java 21
- Spring Boot
- Maven
- HTML
- CSS
- JavaScript
- JUnit 5
- Swagger / OpenAPI

---

## Project Structure

```
expense-tracker-api
│
├── README.md
├── AI_NOTES.md
├── pom.xml
├── src
│   ├── main
│   └── test
└── mvnw
```

---

# Test Location

This project follows the standard Maven directory structure.

All JUnit test cases are located in:

src/test/java

## Getting Started

### Prerequisites

- Java 21 or later
- Git

---

## Clone the Repository

```bash
git clone https://github.com/JyotirmayBhattacharjee/Smart-Expense-Tracker-API.git

cd Smart-Expense-Tracker-API
```

---

## Run the Application

### Windows

```bash
mvnw.cmd spring-boot:run
```

### Linux / macOS

```bash
./mvnw spring-boot:run
```

The application will start on:

```
http://localhost:8080
```

---

## Frontend

Open the following URL in your browser:

```
http://localhost:8080
```

---

## Swagger Documentation

Swagger UI is available at:

```
http://localhost:8080/swagger-ui/index.html
```

---

## Running the Tests

```bash
mvnw.cmd test
```

---

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/expenses` | Add a new expense |
| GET | `/expenses` | Retrieve all expenses |
| GET | `/expenses?category={category}` | Filter expenses by category |
| GET | `/expenses/total` | Get total expenses |
| GET | `/expenses/total?category={category}` | Get total by category |
| DELETE | `/expenses/{id}` | Delete an expense |

---

## Notes

- Expense data is stored in memory.
- Data will be reset whenever the application restarts.
- No external database is required.

---

## Author

**Jyotirmay Bhattacharjee**
