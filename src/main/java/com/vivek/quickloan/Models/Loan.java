package com.vivek.quickloan.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vivek.quickloan.Models.enums.LoanType;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LoanType loanType;

    @Column(nullable = false)
    private double loanAmount;

    @Column(nullable = false)
    private double interestRate;

    private LocalDate disbursementDate;
    private LocalDate firstPaymentDate;

    @Column(length = 20)
    private String status;

    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LoanTransaction> transactions = new ArrayList<>();

}