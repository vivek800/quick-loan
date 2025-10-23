package com.vivek.quickloan.utilily;

import com.vivek.quickloan.rules.APRCalculator;
import com.vivek.quickloan.rules.InterestCalculator;

public class LoanRuleFactory {
      public static final InterestCalculator SIMPLE_INTEREST =
            (p, r, d) -> (p * r * d) / 36500;

    public static final InterestCalculator FIXED_INTEREST =
            (p, r, d) -> (p * r * d) / 1200;

    public static final APRCalculator APR =
            (amount, rate, months) -> (amount * rate * months) / 100;
}
