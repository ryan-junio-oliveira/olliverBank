package com.olliverbank;

public class Deposit {

    private double deposit;

    public Deposit(){
        this.deposit = 0;
    }

    public double getDeposit(){
        return this.deposit;
    }

    public void setDeposit(double deposit){
        if(this.checkDepositAmount(deposit)){
            this.deposit =  deposit;
        }
    }

    private boolean checkDepositAmount(double deposit) throws IllegalArgumentException {
        if (deposit <= 0) {
            throw new IllegalArgumentException("Valor de depósito inválido: " + deposit);
        }
        return true;
    }

}
