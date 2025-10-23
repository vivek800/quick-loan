
A modular and production-ready Spring Boot REST API to manage loans, transactions, and interest calculations — built with Builder, Factory, and Strategy design patterns.

🧭 Overview

The Quick Loan System is a RESTful backend service designed to manage the entire loan lifecycle — from creation to repayment.
It demonstrates clean architecture principles, reusable components, and enterprise-level design patterns.

Automatic interest calculation based on loan type

Flexible strategy pattern for dynamic interest computation

Unified API responses with ApiResponse

Ready for integration with Swagger, ELK, and Spring Boot Actuator

🎯 Features

✅ Create, approve, and manage loans
✅ Record and fetch loan transactions
✅ Calculate interest dynamically using LoanRuleFactory strategies
✅ Default interest rate for each LoanType
✅ Centralized exception handling
✅ Plug-and-play interest strategies (daily, fixed)
✅ Monitoring via Actuator

🧠 Design Patterns Used
Pattern	Purpose	Implementation
Builder	Simplifies complex Loan object creation	LoanBuilder.java
Factory	Abstracts loan creation logic	LoanFactory.java
Strategy	Dynamically selects interest calculation logic	InterestStrategy.java, DailyInterestStrategy.java
🏗️ Project Architecture
src/main/java/com/vivek/quickloan/
├── builder/
│   └── LoanBuilder.java
├── Controllers/
│   └── LoanController.java
├── exception/
│   └── Custom exceptions & handlers
├── factory/
│   └── LoanFactory.java
├── Models/
│   ├── Loan.java
│   ├── LoanTransaction.java
│   └── enums/
│       └── LoanType.java
├── Repository/
│   ├── LoanRepository.java
│   └── LoanTransactionRepository.java
├── response/
│   └── ApiResponse.java
├── rules/
│   ├── APRCalculator.java
│   ├── InterestCalculator.java
│   └── TransactionFilter.java
├── Services/
│   ├── LoanService.java
│   └── LoanServiceImpl.java
├── strategy/
│   ├── InterestStrategy.java
│   └── DailyInterestStrategy.java
└── utilily/
    └── LoanRuleFactory.java

⚙️ Tech Stack
Layer	Technology
Language	Java 17
Framework	Spring Boot 3.3.0
Database	MySQL 8.0
ORM	Spring Data JPA / Hibernate
Monitoring	Spring Boot Actuator
Build Tool	Maven
🚀 Setup Instructions
1️⃣ Clone the repository
git clone https://github.com/vivek-kumar/quick-loan.git
cd quick-loan

2️⃣ Configure the database

Update src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/quick_loan
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

3️⃣ Build & run the app
mvn clean install
mvn spring-boot:run


Server starts at 👉 http://localhost:8080

🔍 API Endpoints
Method	Endpoint	Description
POST	/api/v1/loans	Create a new loan
POST	/api/v1/loans/{loanId}/transactions	Add a transaction to a loan
GET	/api/v1/loans/{loanId}/interest?periodDays=30	Calculate interest
GET	/api/v1/loans/{loanId}/transactions	Fetch all transactions of a loan
1️⃣ Create a Loan

Endpoint: POST /api/v1/loans
Request Body (JSON):

{
  "loanType": "DAILY",
  "loanAmount": 10000.0,
  "interestRate": 40.0,
  "disbursementDate": "2025-10-23",
  "firstPaymentDate": "2025-10-24",
  "status": "APPROVED"
}


Response Body:

{
  "success": true,
  "message": "Loan created successfully",
  "data": {
    "id": 1,
    "loanType": "DAILY",
    "loanAmount": 10000.0,
    "interestRate": 40.0,
    "disbursementDate": "2025-10-23",
    "firstPaymentDate": "2025-10-24",
    "status": "APPROVED",
    "transactions": []
  }
}

2️⃣ Add a Loan Transaction

Endpoint: POST /api/v1/loans/{loanId}/transactions
Request Body (JSON):

{
  "transactionType": "DISBURSEMENT",
  "amount": 10000.0,
  "transactionDate": "2025-10-23"
}


Response Body:

{
  "success": true,
  "message": "Transaction recorded",
  "data": {
    "id": 1,
    "transactionType": "DISBURSEMENT",
    "amount": 10000.0,
    "transactionDate": "2025-10-23",
    "loan": {
      "id": 1,
      "loanType": "DAILY",
      "loanAmount": 10000.0,
      "interestRate": 40.0,
      "status": "APPROVED"
    }
  }
}

3️⃣ Get All Transactions for a Loan

Endpoint: GET /api/v1/loans/{loanId}/transactions

Response Body:

{
  "success": true,
  "message": "Transactions retrieved",
  "data": [
    {
      "id": 1,
      "transactionType": "DISBURSEMENT",
      "amount": 10000.0,
      "transactionDate": "2025-10-23",
      "loan": {
        "id": 1,
        "loanType": "DAILY",
        "loanAmount": 10000.0,
        "interestRate": 40.0,
        "status": "APPROVED"
      }
    },
    {
      "id": 2,
      "transactionType": "REPAYMENT",
      "amount": 2000.0,
      "transactionDate": "2025-10-24",
      "loan": {
        "id": 1,
        "loanType": "DAILY",
        "loanAmount": 10000.0,
        "interestRate": 40.0,
        "status": "APPROVED"
      }
    }
  ]
}

4️⃣ Calculate Interest

Endpoint: GET /api/v1/loans/{loanId}/interest?periodDays=30

Response Body:

{
  "success": true,
  "message": "Interest calculated",
  "data": 328.76
}


Explanation: Calculated using LoanRuleFactory.SIMPLE_INTEREST formula: (principal * rate * days) / 36500

5️⃣ Example Error Response

If something goes wrong (loan not found, invalid input, etc.), a standardized error response can be returned:

{
  "success": false,
  "message": "Loan with ID 99 not found",
  "data": null
}

🧾 Monitoring (Actuator)

Access health and metrics at:

http://localhost:8080/actuator/health

http://localhost:8080/actuator/metrics
[Download Swagger Documentation](docs/swagger.pdf)
📘 Future Enhancements

🧮 Add EMI calculator

📊 Integrate ELK for logging and analytics

🔐 JWT-based authentication and authorization

🌐 Swagger/OpenAPI UI for API documentation

💡 Advanced interest strategies (monthly, compounding)

📈 Dashboard for loan and transaction statistics
