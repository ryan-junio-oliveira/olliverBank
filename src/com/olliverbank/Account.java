package com.olliverbank;

public class Account {

    private String name;
    private int number;
    private String agency;
    private double balance;

    public String getName(){
        return this.name;
    }

    public int getNumber(){
        return this.number;
    }

    public String getAgency(){
        return this.agency;
    }

    public double getBalance(){
        return this.balance;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public void setAgency(String agency){
        this.agency = agency;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

}
