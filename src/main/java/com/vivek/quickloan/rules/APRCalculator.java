package com.vivek.quickloan.rules;

@FunctionalInterface
public interface APRCalculator {
    double compute(double loanAmount, double rate, int months);
}
