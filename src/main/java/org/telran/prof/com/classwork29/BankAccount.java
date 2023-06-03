package org.telran.prof.com.classwork29;

public class BankAccount {
    private int balance;

//    public synchronized void  increaseBalance() {
//        balance = balance + 1000;
//    }

    public void  increaseBalance() {

        synchronized (this) {
            balance = balance + 1000;
        }
    }

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public BankAccount() {
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
