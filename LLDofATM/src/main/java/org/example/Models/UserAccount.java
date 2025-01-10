package org.example.Models;

public class UserAccount {
    int balance;

    public int getBalance() {
        return balance;
    }
    public void withDraw(int amt){
        this.balance=balance-amt;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
