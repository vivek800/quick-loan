package com.vivek.quickloan.builder;

import java.time.LocalDate;

import com.vivek.quickloan.Models.Loan;
import com.vivek.quickloan.Models.enums.LoanType;

public class LoanBuilder {

    private final Loan loan;

    public LoanBuilder() {
        this.loan = new Loan();
    }

    public LoanBuilder withType(LoanType type) {
        loan.setLoanType(type);
        return this;
    }

    public LoanBuilder withAmount(double amount) {
        loan.setLoanAmount(amount);
        return this;
    }

    public LoanBuilder withRate(double rate) {
        loan.setInterestRate(rate);
        return this;
    }

    public LoanBuilder withDisbursementDate(LocalDate date) {
        loan.setDisbursementDate(date);
        return this;
    }

    public LoanBuilder withFirstPaymentDate(LocalDate date) {
        loan.setFirstPaymentDate(date);
        return this;
    }

    public LoanBuilder withStatus(String status) {
        loan.setStatus(status);
        return this;
    }

    public Loan build() {
        return loan;
    }
}
