package com.vivek.quickloan.strategy;

import com.vivek.quickloan.utilily.LoanRuleFactory;

public class DailyInterestStrategy implements InterestStrategy {

   @Override
    public double calculateInterest(double principal, double rate, int periodDays) {
         return LoanRuleFactory.SIMPLE_INTEREST.calculate(principal, rate, periodDays);
    }
    
}
