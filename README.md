# 💸 Quick Loan System
> A modular and production-grade **Spring Boot REST API** to manage loans, transactions, and interest calculations — built with **Builder**, **Factory**, and **Strategy** design patterns.

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.3.0-brightgreen)
![Database](https://img.shields.io/badge/MySQL-8.0-blue)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

---

## 🧭 Overview

The **Quick Loan System** is a RESTful backend service designed to manage loan lifecycles — from creation to repayment.  
It demonstrates clean architecture principles, reusable components, and enterprise-level design patterns.

---

## 🎯 Features

✅ Create, approve, and manage loans  
✅ Record and fetch loan transactions  
✅ Calculate interest dynamically based on strategy  
✅ Plug-and-play strategy (daily or custom interest)  
✅ Unified API response structure (`ApiResponse`)  
✅ Centralized exception handling  
✅ Ready for integration with **Swagger**, **ELK**, and **Actuator**

---

## 🧠 Design Patterns Used

| Pattern | Purpose | Implementation |
|----------|----------|----------------|
| **Builder** | Simplifies complex Loan object creation | `LoanBuilder.java` |
| **Factory** | Abstracts loan creation logic | `LoanFactory.java` |
| **Strategy** | Dynamically selects interest calculation logic | `InterestStrategy.java`, `DailyInterestStrategy.java` |

---

## 🏗️ Project Architecture

src/main/java/com/vivek/quickloan/
├── builder/
│ └── LoanBuilder.java
├── Controllers/
│ └── LoanController.java
├── exception/
├── factory/
│ └── LoanFactory.java
├── Models/
│ ├── Loan.java
│ └── LoanTransaction.java
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
└── strategy/
├── InterestStrategy.java
└── DailyInterestStrategy.java


---

## ⚙️ Tech Stack

| Layer | Technology |
|-------|-------------|
| **Language** | Java 17 |
| **Framework** | Spring Boot |
| **Database** | MySQL |
| **ORM** | Spring Data JPA / Hibernate |
| **Monitoring** | Spring Boot Actuator |
| **Build Tool** | Maven |

---

## 🚀 Setup Instructions

### 1️⃣ Clone the repository
```bash
git clone https://github.com/vivek-kumar/quick-loan.git
cd quick-loan
2️⃣ Configure the database

Update src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/quick_loan
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

3️⃣ Build & run the app
mvn clean install
mvn spring-boot:run


Server starts at 👉 http://localhost:8080

🔍 API Endpoints
Method	Endpoint	Description
POST	/api/v1/loans	Create a new loan
POST	/api/v1/loans/{loanId}/transactions	Add a loan transaction
GET	/api/v1/loans/{loanId}/interest?periodDays=30	Calculate interest
GET	/api/v1/loans/{loanId}/transactions	Fetch all transactions
✅ Example Response
{
  "success": true,
  "message": "Loan created successfully",
  "data": {
    "loanId": 1,
    "borrower": "Vivek Kumar",
    "principal": 10000,
    "interestRate": 9.5,
    "status": "APPROVED"
  }
}

🧾 Monitoring (Actuator)

Access health and metrics at:

http://localhost:8080/actuator/health
http://localhost:8080/actuator/metrics

📘 Future Enhancements

🧮 Add EMI calculator

📊 Integrate ELK for logging and analytics

🔐 Add JWT-based authentication

🌐 Swagger API documentation UI
  
