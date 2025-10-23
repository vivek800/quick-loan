package com.vivek.quickloan.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vivek.quickloan.Models.Loan;
import com.vivek.quickloan.Models.LoanTransaction;
import com.vivek.quickloan.response.ApiResponse;
import java.util.List;
import com.vivek.quickloan.Services.*;
@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Loan>> createLoan(@RequestBody Loan loan) {
        Loan saved = loanService.createLoan(loan);
        return ResponseEntity.ok(new ApiResponse<>(true, "Loan created successfully", saved));
    }

    @PostMapping("/{loanId}/transactions")
    public ResponseEntity<ApiResponse<LoanTransaction>> addTransaction(
            @PathVariable Long loanId,
            @RequestBody LoanTransaction transaction) {
        LoanTransaction tx = loanService.addTransaction(loanId, transaction);
        return ResponseEntity.ok(new ApiResponse<>(true, "Transaction recorded", tx));
    }

    @GetMapping("/{loanId}/interest")
    public ResponseEntity<ApiResponse<Double>> calculateInterest(
            @PathVariable Long loanId,
            @RequestParam int periodDays) {
        double interest = loanService.calculateInterest(loanId, periodDays);
        return ResponseEntity.ok(new ApiResponse<>(true, "Interest calculated", interest));
    }

    @GetMapping("/{loanId}/transactions")
    public ResponseEntity<ApiResponse<List<LoanTransaction>>> getTransactions(@PathVariable Long loanId) {
        List<LoanTransaction> transactions = loanService.getTransactions(loanId);
        return ResponseEntity.ok(new ApiResponse<>(true, "Transactions retrieved", transactions));
    }
}
