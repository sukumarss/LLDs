package org.example.Models;

import org.example.states.ATMStates;
import org.example.states.IdleState;

public class ATM {
    int balance;
    static ATM atm = new ATM();
    ATMStates atmState;
    private ATM(){

    }


    public static ATM getAtmObject(){
        atm.setAtmState(new IdleState());
        return atm;
    }

    public ATMStates getCurrentState(){
        return atmState;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setAtmState(ATMStates atmState) {
        this.atmState = atmState;
    }
}
