package com.vivek.quickloan.strategy;

public interface InterestStrategy {
    double calculateInterest(double principal, double rate, int periodDays);
}
