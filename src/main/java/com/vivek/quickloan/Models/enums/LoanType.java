package com.vivek.quickloan.Models.enums;

public enum LoanType {
    DAILY(40),
    WEEKLY(30),
    MONTHLY(20),
    QUARTERLY(15),
    YEARLY(10),
    BUSINESS(25);

    private final double defaultRate;

    LoanType(double defaultRate) {
        this.defaultRate = defaultRate;
    }

    public double getDefaultRate() {
        return defaultRate;
    }
}
