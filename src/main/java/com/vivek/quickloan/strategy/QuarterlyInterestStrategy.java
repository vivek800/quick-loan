package com.vivek.quickloan.strategy;

public class QuarterlyInterestStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double principal, double rate, int periodDays) {
        int quarters = periodDays / 90;
        return (principal * rate * quarters) / 400; // quarterly
    }
}
