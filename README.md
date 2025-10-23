# 💸 Quick Loan System

A **modular**, **production-ready** Spring Boot REST API for managing **loans**, **transactions**, and **interest calculations** — built using **Builder**, **Factory**, and **Strategy** design patterns.

---
## 📄 Documentation

For detailed API specifications and Swagger endpoints:

📘 [View Swagger UI Documentation](Swagger%20UI.pdf)
## 🧭 Overview

The **Quick Loan System** is a robust backend service that handles the entire **loan lifecycle** — from loan creation to repayment tracking and interest computation.  
It follows **clean architecture principles**, promotes **reusability**, and implements **enterprise-grade design patterns** for flexibility and maintainability.

### ✨ Highlights

- ⚙️ Automatic interest calculation based on loan type  
- 🧮 Dynamic computation via **Strategy Pattern**  
- 📦 Unified API responses (`ApiResponse`)  
- 🧰 Centralized exception handling  
- 📊 Ready for **Swagger**, **ELK**, and **Spring Boot Actuator**

---

## 🎯 Features

| ✅ Feature | Description |
|------------|-------------|
| 🏦 Loan Management | Create, approve, and manage loans |
| 💰 Transactions | Record disbursements and repayments |
| 🧮 Interest Calculation | Dynamic interest based on strategies |
| 🔄 Plug & Play Rules | Use `LoanRuleFactory` for flexible logic |
| ⚡ Default Loan Rates | Each `LoanType` has its own rate |
| 🧩 Exception Handling | Centralized and consistent |
| 📈 Monitoring | Integrated with Spring Boot Actuator |

---

## 🧠 Design Patterns Used

| Pattern | Purpose | Implementation |
|----------|----------|----------------|
| 🧱 **Builder** | Simplifies complex Loan object creation | `LoanBuilder.java` |
| 🏭 **Factory** | Abstracts loan creation logic | `LoanFactory.java` |
| 🧮 **Strategy** | Dynamically selects interest calculation | `InterestStrategy.java`, `DailyInterestStrategy.java` |

## 🏗️ Project Architecture

---
src/main/java/com/vivek/quickloan/
├── builder/
│ └── LoanBuilder.java
├── Controllers/
│ └── LoanController.java
├── exception/
│ └── Custom exceptions & handlers
├── factory/
│ └── LoanFactory.java
├── Models/
│ ├── Loan.java
│ ├── LoanTransaction.java
│ └── enums/
│ └── LoanType.java
├── Repository/
│ ├── LoanRepository.java
│ └── LoanTransactionRepository.java
├── response/
│ └── ApiResponse.java
├── rules/
│ ├── APRCalculator.java
│ ├── InterestCalculator.java
│ └── TransactionFilter.java
├── Services/
│ ├── LoanService.java
│ └── LoanServiceImpl.java
├── strategy/
│ ├── InterestStrategy.java
│ └── DailyInterestStrategy.java
└── utility/
└── LoanRuleFactory.java

---

## ⚙️ Tech Stack

| Layer | Technology |
|-------|-------------|
| 💻 **Language** | Java 17 |
| ☕ **Framework** | Spring Boot 3.3.0 |
| 🗄️ **Database** | MySQL 8.0 |
| 🧩 **ORM** | Hibernate / Spring Data JPA |
| 📈 **Monitoring** | Spring Boot Actuator |
| 🧰 **Build Tool** | Maven |

---

## 🚀 Setup Instructions

### 1️⃣ Clone the repository

```bash
git clone https://github.com/vivek-kumar/quick-loan.git
cd quick-loan
2️⃣ Configure the database

Edit src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/quick_loan
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

3️⃣ Build & Run the application
mvn clean install
mvn spring-boot:run


✅ Server starts at → http://localhost:8080

🔍 API Endpoints
Method	Endpoint	Description
POST	/api/v1/loans	Create a new loan
POST	/api/v1/loans/{loanId}/transactions	Add a transaction
GET	/api/v1/loans/{loanId}/transactions	Get all transactions
GET	/api/v1/loans/{loanId}/interest?periodDays=30	Calculate interest
🧾 Example — Create a Loan

POST /api/v1/loans

{
  "loanType": "DAILY",
  "loanAmount": 10000.0,
  "interestRate": 40.0,
  "disbursementDate": "2025-10-23",
  "firstPaymentDate": "2025-10-24",
  "status": "APPROVED"
}


Response

{
  "success": true,
  "message": "Loan created successfully",
  "data": {
    "id": 1,
    "loanType": "DAILY",
    "loanAmount": 10000.0,
    "interestRate": 40.0,
    "status": "APPROVED"
  }
}

🧮 Example — Calculate Interest

GET /api/v1/loans/{loanId}/interest?periodDays=30

{
  "success": true,
  "message": "Interest calculated",
  "data": 328.76
}


📘 Formula: (principal * rate * days) / 36500 (via LoanRuleFactory.SIMPLE_INTEREST)

❌ Example — Error Response
{
  "success": false,
  "message": "Loan with ID 99 not found",
  "data": null
}

🧾 Monitoring (Actuator)

Access health and metrics endpoints:

http://localhost:8080/actuator/health

http://localhost:8080/actuator/metrics

 
📘 Future Enhancements

🧮 Add EMI Calculator

📊 Integrate ELK for logging & analytics

🔐 JWT-based authentication and authorization

🌐 Swagger/OpenAPI UI for live documentation

💡 Advanced interest strategies (monthly, compounding)

📈 Dashboard for loan and transaction analytics
