package com.vivek.quickloan.strategy;

import com.vivek.quickloan.utilily.LoanRuleFactory;

public class MonthlyInterestStrategy implements InterestStrategy{

      @Override
    public double calculateInterest(double principal, double rate, int periodDays) {
        return LoanRuleFactory.FIXED_INTEREST.calculate(principal, rate, periodDays);
    }
    
}
