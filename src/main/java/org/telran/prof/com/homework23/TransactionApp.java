package org.telran.prof.com.homework23;

import java.util.HashMap;
import java.util.Map;

public class TransactionApp {
    public static void main(String[] args) {
        Map<String, Storage> data = new HashMap<>();
        data.put("012345", new Storage("GB29639660161331926819", "FR1420041010050500013002606", 1200.0, 5000.0, 1000.0));
        data.put("789652", new Storage("DE89370400440532013000", "IE29123593115212345678", 20000.0, 3000.0, 2000.0));
        data.put("258963", new Storage("ES9121000418450200051332", "IT6080542811101000000123456", 3600.0, 5000.0, 1000.0));
        data.put("658963", new Storage("PL61109010140000071219812874", "NL9145890417164300", 20.0, 9800.0, 500.0));
        data.put("147852", new Storage("RO4900001831007593840000", "GT20125O00000000001234567890", 690.0, 8000.0, 3000.0));
        data.put("985146", new Storage("PT50000201231234567890154", "GR9608100010000001234567890", 4000.0, 700.0, 1000.0));

        AccountData accountData = new AccountData(data);
        AccountService transactionHelper = new AccountService(accountData);

        String authorisedAccount = null;
        try{
        authorisedAccount = transactionHelper.authorize();
        }catch (IncorrectIbanNumberException e){
            System.out.println(e.getMessage());
            transactionHelper.getDecisionAndAct();
        }

        if (authorisedAccount != null) {
            Storage currentStorage = accountData.getData().get(transactionHelper.getCurrentKey());
            boolean isFinished = false;
            while (!isFinished) {
                try {
                    isFinished = currentStorage.getMenuAndTakeAction();
                } catch (NoSuchOptionException e) {
                    System.out.println(e.getMessage());
                    isFinished = currentStorage.getMenuAndTakeAction();
                } catch (NotEnoughFundsException ex) {
                    System.out.println(ex.getMessage());
                    boolean isAgree = currentStorage.getDecision();
                    while (isAgree && !isFinished) {
                        try {
                            isFinished = currentStorage.getMenuAndTakeAction();
                        } catch (NoSuchOptionException e) {
                            System.out.println(e.getMessage());
                            isFinished = currentStorage.getMenuAndTakeAction();
                        }
                    }
                }
            }
        }
        transactionHelper.close();
    }
}