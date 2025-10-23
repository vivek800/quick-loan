package com.vivek.quickloan.factory;

import com.vivek.quickloan.Models.enums.LoanType;
import com.vivek.quickloan.strategy.*;

public class LoanFactory {

    private LoanFactory() {}

    public static InterestStrategy getInterestStrategy(LoanType type) {
        return switch (type) {
            case DAILY -> new DailyInterestStrategy();
            case WEEKLY -> new WeeklyInterestStrategy();
            case MONTHLY -> new MonthlyInterestStrategy();
            case QUARTERLY -> new QuarterlyInterestStrategy();
            case YEARLY -> new YearlyInterestStrategy();
            default -> throw new IllegalArgumentException("Invalid loan type: " + type);
        };
    }

     
}
