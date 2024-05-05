package com.olliverbank;

import java.util.Random;
import java.util.HashMap;

public class CreateAccount {

    private String agency;
    private int numberAccount;
    private String nameClient;

    public CreateAccount(String nameClient){
        this.nameClient =  nameClient;
    }


    public HashMap<String, Object> createAccount(int region) {

        this.agency = this.getAgency(region);
        this.numberAccount =  this.generateNumberAccount();

        HashMap<String, Object> accountInfo = new HashMap<>();
        accountInfo.put("agency", this.agency);
        accountInfo.put("numberAccount", this.numberAccount);
        accountInfo.put("nameClient", this.nameClient);

        return accountInfo;

    }

    public int getNumberAccount() {
        return numberAccount;
    }

    public String getAgency() {
        return agency;
    }

    private int generateNumberAccount() {
        Random generateRandom = new Random();
        StringBuilder numberAccount = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            numberAccount.append(generateRandom.nextInt(10));
        }
        return Integer.parseInt(numberAccount.toString());
    }

    private String getAgency(int region){
        switch (region) {
            case 1:
                return "1507-1";
            case 2:
                return "1508-2";
            case 3:
                return "1509-3";
            case 4:
                return "1510-4";
            default:
                System.out.println("Região escolhida inválida!.");
                return "";
        }
    }

}
