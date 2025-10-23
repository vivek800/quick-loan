package com.vivek.quickloan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.quickloan.Models.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    
}
