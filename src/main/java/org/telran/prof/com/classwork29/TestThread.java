package org.telran.prof.com.classwork29;

public class TestThread extends Thread{
    private BankAccount bankAccount;

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.bankAccount.increaseBalance();
    }
}
