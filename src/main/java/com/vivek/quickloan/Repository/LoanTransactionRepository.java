package com.vivek.quickloan.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.quickloan.Models.LoanTransaction;;

public interface LoanTransactionRepository extends JpaRepository<LoanTransaction, Long> {
    List<LoanTransaction> findByLoanId(Long loanId);

}