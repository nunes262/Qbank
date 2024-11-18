package com.example.Qbank.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private Long userId;
    private double balance;
    private List<String> transactionHistory;

    public Account(Long userId) {
        this.userId = userId;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public Long getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposit: +" + amount);
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawal: -" + amount);
            return true;
        }
        return false;
    }

    public boolean transfer(double amount, Account targetAccount) {
        if (amount <= balance) {
            this.withdraw(amount);
            targetAccount.deposit(amount);
            transactionHistory.add("Transfer to Account " + targetAccount.getUserId() + ": -" + amount);
            targetAccount.getTransactionHistory().add("Transfer from Account " + this.getUserId() + ": +" + amount);
            return true;
        }
        return false;
    }
}
