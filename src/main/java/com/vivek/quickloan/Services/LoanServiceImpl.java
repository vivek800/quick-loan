package com.vivek.quickloan.Services;

 
import org.springframework.stereotype.Service;

import com.vivek.quickloan.Models.Loan;
import com.vivek.quickloan.Models.LoanTransaction;
import com.vivek.quickloan.Repository.LoanRepository;
import com.vivek.quickloan.Repository.LoanTransactionRepository;
import com.vivek.quickloan.factory.LoanFactory;
import com.vivek.quickloan.strategy.InterestStrategy;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final LoanTransactionRepository transactionRepository;

    public LoanServiceImpl(LoanRepository loanRepository, LoanTransactionRepository transactionRepository) {
        this.loanRepository = loanRepository;
        this.transactionRepository = transactionRepository;
    }

   @Override
    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public LoanTransaction addTransaction(Long loanId, LoanTransaction transaction) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new IllegalArgumentException("Loan not found"));
        transaction.setLoan(loan);
        return transactionRepository.save(transaction);
    }

    @Override
    public double calculateInterest(Long loanId, int periodDays) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new IllegalArgumentException("Loan not found"));
        InterestStrategy strategy = LoanFactory.getInterestStrategy(loan.getLoanType());
        return strategy.calculateInterest(loan.getLoanAmount(), loan.getInterestRate(), periodDays);
    }

    @Override
    public List<LoanTransaction> getTransactions(Long loanId) {
        return transactionRepository.findByLoanId(loanId);
    }
}
    

