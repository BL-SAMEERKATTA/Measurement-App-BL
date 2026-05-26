# Quantity Measurement App

A Spring Boot backend application that performs quantity measurement conversions, comparisons, and arithmetic operations across multiple units — Length, Weight, Volume, and Temperature.

## Author

**Sameer Katta**
Java Backend Developer Trainee — BridgeLabz Solutions
GitHub: [@sameerkatta-sys](https://github.com/sameerkatta-sys)

## About the Project

This project was developed as part of the BridgeLabz Java training program. It implements a clean, extensible quantity measurement system following SOLID principles, DRY principle, and N-Tier architecture.

## Use Cases Implemented

| Branch | Description |
|--------|-------------|
| UC1  | Feet Measurement Equality |
| UC2  | Feet and Inches Measurement Equality |
| UC3  | Generic Quantity Class for DRY Principle |
| UC4  | Extended Unit Support (Yards, Centimeters) |
| UC5  | Unit to Unit Conversion |
| UC6  | Addition of Two Length Units |
| UC7  | Addition with Target Unit Specification |
| UC8  | Refactoring Unit Enum to Standalone Class |
| UC9  | Weight Measurement (Kg, Gram, Pound) |
| UC10 | Generic Quantity Class with Unit Interface |
| UC11 | Volume Measurement (Litre, Millilitre, Gallon) |
| UC12 | Subtraction and Division Operations |
| UC13 | Centralized Arithmetic Logic (DRY Enforcement) |
| UC14 | Temperature Measurement with Selective Arithmetic |
| UC15 | N-Tier Architecture Restructuring |
| UC16 | Database Integration with JDBC |
| UC17 | Spring Boot Backend with REST APIs |
| UC18 | Google Authentication and User Management |

## Tech Stack

| Technology | Purpose |
|------------|---------|
| Java 21 | Core programming language |
| Spring Boot 3.3.2 | Backend framework |
| Spring Data JPA | Database ORM |
| Spring Security | Authentication and authorization |
| OAuth2 (Google Login) | Social authentication |
| JWT | Stateless token-based auth |
| MySQL | Relational database |
| JUnit 5 | Unit testing |
| Maven | Build and dependency management |

## REST API Endpoints

Base URL: http://localhost:8080

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /quantity/add | Add two quantities |
| POST | /quantity/compare | Compare two quantities |
| POST | /quantity/subtract | Subtract two quantities |
| POST | /quantity/divide | Divide two quantities |

### Sample Request

POST /quantity/add
Content-Type: application/json

[
    { "value": 1.0, "unit": "FEET" },
    { "value": 12.0, "unit": "INCHES" }
]

### Sample Response

{
    "value": 2.0,
    "unit": "FEET"
}

## How to Run

### Prerequisites
- Java 21
- Maven
- MySQL

### Steps

1. Clone the repository
git clone https://github.com/sameerkatta-sys/Measurement-App-BL.git

2. Configure application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/quantitydb
spring.datasource.username=your_username
spring.datasource.password=your_password

3. Run the application
mvn spring-boot:run

4. Access the API at http://localhost:8080

## Supported Units

| Category | Units |
|----------|-------|
| Length | Feet, Inches, Yards, Centimeters |
| Weight | Kilogram, Gram, Pound |
| Volume | Litre, Millilitre, Gallon |
| Temperature | Celsius, Fahrenheit |

## Development Timeline

| Date | Work Done |
|------|-----------|
| 21 Apr 2026 | UC1, UC2 - Length equality |
| 22 Apr 2026 | UC3, UC4 - Generic class and extended units |
| 23 Apr 2026 | UC5, UC6 - Conversion and addition |
| 24 Apr 2026 | UC7, UC8 - Target unit and refactoring |
| 25 Apr 2026 | UC9, UC10 - Weight and generic interface |
| 26 Apr 2026 | UC11, UC12 - Volume and arithmetic ops |
| 27 Apr 2026 | UC13, UC14, UC15 - DRY, Temperature, N-Tier |
| 28 Apr 2026 | UC16, UC17, UC18 - DB, Spring Backend, Auth |

## License

This project is developed for educational purposes as part of BridgeLabz Java training program.
