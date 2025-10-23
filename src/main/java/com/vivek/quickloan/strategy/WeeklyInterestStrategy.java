package com.vivek.quickloan.strategy;

public class WeeklyInterestStrategy  implements InterestStrategy{

    @Override
    public double calculateInterest(double principal, double rate, int periodDays) {
        int weeks = periodDays / 7;
        return (principal * rate * weeks) / 5200; 
    }
    
}
