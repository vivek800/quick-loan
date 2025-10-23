package com.vivek.quickloan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuickLoanApplication {

	 public static void main(String[] args) {
        try {
            SpringApplication.run(QuickLoanApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("⚠️ Application started with errors, but continuing...");
         }
    }

}
