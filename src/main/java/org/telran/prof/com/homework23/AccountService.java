package org.telran.prof.com.homework23;

import java.util.Scanner;
import java.util.regex.Pattern;

public class AccountService {
    //эти переменные вполне могут быть харанктеристиками данного класса
    private AccountData accountData;
    private String bankAccountPattern = "[A-Z]{2}\\d{18,32}";
    private String codePattern = "\\d{6}";
    private int codeEntranceCounter = 0;
    private String currentKey;
    private final Scanner scanner = new Scanner(System.in);

    public AccountService(AccountData accountData) {
        this.accountData = accountData;
    }

    public String getCurrentKey() {
        return currentKey;
    }

    public String authorize(){
        System.out.println("Please, enter your bank account: ");
        String clientsBankAccount = scanner.next();
        Pattern pattern = Pattern.compile(bankAccountPattern);
        boolean codeIsChecked = false;
        if (pattern.matcher(clientsBankAccount).matches()){
            if(codeEntranceCounter<3) {
                try {
                    codeIsChecked = checkTheEntranceCode(clientsBankAccount);
                } catch (IncorrectCodeNTemplateException | WrongAccessCodeException exception) {
                    System.out.println(exception.getMessage());
                    boolean decision = getDecision();
                    while(decision && codeEntranceCounter<3 && !codeIsChecked)
                        try {
                            codeIsChecked = checkTheEntranceCode(clientsBankAccount);
                        } catch (IncorrectCodeNTemplateException | WrongAccessCodeException exception1) {
                            System.out.println(exception1.getMessage());
                            decision = getDecision();
                    }
                }
            } else {
                codeEntranceCounter = 0;
                System.out.println("You've put the wrong code 3 times. The end of the current session.");
                authorize();
            }
        } else {
            //неясно, что значит, исходный номер счета - поэтому предположила, что это то, что введено клиентом
            String message = "The bank account " + clientsBankAccount + " is not valid. The example of the correct account:'LE000000000000000000'";
            throw new IncorrectIbanNumberException(message, clientsBankAccount);
        }
        return clientsBankAccount;
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
                    ans = false;
                    break;
                default:
                    System.out.println("Incorrect answer.");
                    getDecision();
            }
            return ans;
    }

    public void getDecisionAndAct(){
        System.out.println("Do you want to try again (Y/N)?");
        String answer = scanner.next();
        try {
            switch (answer) {
                case "Y":
                    authorize();
                    break;
                case "N":
                    break;
                default:
                    System.out.println("Incorrect answer.");
                    getDecisionAndAct();
            }
        } catch (IncorrectIbanNumberException e){
            System.out.println(e.getMessage());
            getDecisionAndAct();
        }
    }

    public boolean checkTheEntranceCode(String clientsBankAccount){
        boolean codeIsOk = false;
        System.out.println("Please, enter the code to verify the entrance: ");
        String customersCode = scanner.next();
        Pattern pattern = Pattern.compile(codePattern);
        if (!pattern.matcher(customersCode).matches()){
            codeEntranceCounter ++;
            throw new IncorrectCodeNTemplateException("The provided code doesn't match the pattern");
        }
        if (!accountData.getData().containsKey(customersCode)){
            codeEntranceCounter ++;
            throw new WrongAccessCodeException("The code is incorrect");
        } else if (accountData.getData().containsKey(customersCode) && pattern.matcher(customersCode).matches()) {
            if (accountData.getData().get(customersCode).getFirstAccount().equals(clientsBankAccount)){
                codeIsOk = true;
            } else{
                System.out.println("The IBAN does not match the code! ");
                getDecisionAndAct();
            }
        }
        currentKey = customersCode;
        return codeIsOk;
    }

    public void close(){
        currentKey = null;
        codeEntranceCounter = 0;
    }
}
