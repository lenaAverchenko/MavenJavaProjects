package org.telran.prof.com.homework23;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Storage {
    private String firstAccount;
    private String secondAccount;
    private double firstSumOfMoney;
    private double secondSumOfMoney;
    private double transferLimit;
    private Scanner scanner = new Scanner(System.in);

    public Storage(String firstAccount, String secondAccount, double firstSumOfMoney, double secondSumOfMoney, double transferLimit) {
        this.firstAccount = firstAccount;
        this.secondAccount = secondAccount;
        this.firstSumOfMoney = firstSumOfMoney;
        this.secondSumOfMoney = secondSumOfMoney;
        this.transferLimit = transferLimit;
    }

    public String getFirstAccount() {
        return firstAccount;
    }

    public double getFirstSumOfMoney() {
        return firstSumOfMoney;
    }

    public double getSecondSumOfMoney() {
        return secondSumOfMoney;
    }
    //Внимание, в результате всех действий данные о текущих остатках и
    // переводах должны реально осуществляться в хранилище счета и суммы на нем.

    // Считаю, что методы по работе с хранилищем должны бы быть вынесены в отдельный класс, но в задании, я поняла,
    // что все они, включая доступ к меню, должны быть написаны в текущем классе.
    public boolean getMenuAndTakeAction() {
        boolean isDone = false;
        boolean currentDecision = false;
        System.out.println("Please, pick the option: " +
                "\n Get balance at the first account (1)" +
                "\n Get balance at the second account (2)" +
                "\n Transfer from the first to the second account (3)" +
                "\n Transfer from the second to the first account (4)" +
                "\n Exit (5)");
        //не получается обработать InputMismatchException
//        int choice = 0;
//        try {
           int choice = scanner.nextInt();
//        } catch (InputMismatchException e){
//            System.out.println("You have to choose from (1, 2, 3, 4, 5): ");
//            getMenuAndTakeAction();
//        }
        switch (choice) {
            case 1:
                System.out.println(getFirstSumOfMoney());
                currentDecision = getDecision();
                if (!currentDecision){
                    isDone = true;
                    break;
                    }
                break;
            case 2:
                System.out.println(getSecondSumOfMoney());
                currentDecision = getDecision();
                if (!currentDecision){
                    isDone = true;
                    break;
                }
                break;
            case 3: {
                try {
                    makeTransactionFromFirstToSecond();
                } catch (TransferLimitException ex) {
                    System.out.println(ex.getMessage());
                    if (getDecision()) {
                        getMenuAndTakeAction();
                    }
                } catch (InputMismatchException exception) {
                    System.out.println("Incorrect input. Example: 21,0. Try again.");
                    getMenuAndTakeAction();
                } catch (NotEnoughFundsException ex) {
                    System.out.println(ex.getMessage());
                    getMenuAndTakeAction();
                    }
                }
            currentDecision = getDecision();
            if (!currentDecision){
                isDone = true;
                break;
            }
                break;
            case 4: {
                try {
                    makeTransactionFromSecondToFirst();
                } catch (TransferLimitException e) {
                    System.out.println(e.getMessage());
                    if (getDecision()) {
                        getMenuAndTakeAction();
                    }
                } catch (InputMismatchException exception) {
                    System.out.println("Incorrect input. Example: 21,0. Try again.");
                    getMenuAndTakeAction();
                } catch(NotEnoughFundsException e1){
                    System.out.println(e1.getMessage());
                    getMenuAndTakeAction();
                }
                currentDecision = getDecision();
                if (!currentDecision){
                    isDone = true;
                    break;
                }
                break;
            }
            case 5:
                isDone = true;
                break;
            default:
                throw new NoSuchOptionException("The chosen option is wrong!");
        }
        return isDone;
    }

    public void makeTransactionFromFirstToSecond (){
        System.out.println("Please, enter the sum to transfer: ");
        double moneyToTransfer = scanner.nextDouble();
        if(moneyToTransfer<=getFirstSumOfMoney()) {
            if (moneyToTransfer <= transferLimit) {
                firstSumOfMoney = firstSumOfMoney - moneyToTransfer;
                secondSumOfMoney = secondSumOfMoney + moneyToTransfer;
                System.out.printf("You've got " +
                        firstSumOfMoney + " left on your %s account\n", getFirstAccount());
            } else {
                throw new TransferLimitException("The transfer limit has been exceeded!");
            }
        } else{
            throw new NotEnoughFundsException("There's no such amount of money on the account.");
        }
    }
    public void makeTransactionFromSecondToFirst(){
        System.out.println("Please, enter the sum to transfer: ");
        double moneyToTransfer = scanner.nextDouble();
        if(moneyToTransfer <= getSecondSumOfMoney()){
            if (moneyToTransfer <= transferLimit){
                secondSumOfMoney = secondSumOfMoney - moneyToTransfer;
                firstSumOfMoney = firstSumOfMoney + moneyToTransfer;
                System.out.println("You've got " +
                    secondSumOfMoney + " left on the second account");
            } else {
                throw new TransferLimitException("The transfer limit has been exceeded!");
            }
        } else{
            throw new NotEnoughFundsException("There's no such amount of money on the account.");
        }
    }

    public boolean getDecision(){
        System.out.println("Do you want to try again (Y/N)?");
        String answer = scanner.next();
        boolean ans = false;
        switch (answer) {
            case "Y":
                ans = true;
                break;
            case "N":
                break;
            default:
                ans = true;
                System.out.println("Incorrect answer.");
                getDecision();
        }
        return ans;
    }
}