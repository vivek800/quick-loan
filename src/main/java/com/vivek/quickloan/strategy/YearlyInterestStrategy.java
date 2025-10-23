package com.vivek.quickloan.strategy;

public class YearlyInterestStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double principal, double rate, int periodDays) {
        int years = periodDays / 365;
        return (principal * rate * years) / 100;  
    }
}
