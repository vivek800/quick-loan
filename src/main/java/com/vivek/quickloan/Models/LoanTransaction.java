package com.vivek.quickloan.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LoanTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionType;  
    private double amount;
    private LocalDate transactionDate;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;

   
}
