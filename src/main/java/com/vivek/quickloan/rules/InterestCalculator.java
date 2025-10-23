package com.vivek.quickloan.rules;

@FunctionalInterface
 public interface InterestCalculator {
    double calculate(double principal, double rate, int days);

}
