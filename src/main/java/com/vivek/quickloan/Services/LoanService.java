package com.vivek.quickloan.Services;

import java.util.List;

import com.vivek.quickloan.Models.Loan;
import com.vivek.quickloan.Models.LoanTransaction;

public interface LoanService {
 Loan createLoan(Loan loan);
    LoanTransaction addTransaction(Long loanId, LoanTransaction transaction);
    double calculateInterest(Long loanId, int periodDays);
    List<LoanTransaction> getTransactions(Long loanId);
}
