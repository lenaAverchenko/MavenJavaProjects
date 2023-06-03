package org.telran.prof.com.classwork29;

import java.util.HashSet;
import java.util.Set;

public class ExampleSync {
    public static void main(String[] args) throws InterruptedException {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 1000; i++) {

            BankAccount bankAccount = new BankAccount();
            bankAccount.setBalance(0);

            TestThread one = new TestThread();
            TestThread two = new TestThread();

            one.setBankAccount(bankAccount);
            two.setBankAccount(bankAccount);

            one.start();
            two.start();

            one.join();
            two.join();

            set.add(bankAccount.getBalance());
        }
        System.out.println(set);


    }
}
