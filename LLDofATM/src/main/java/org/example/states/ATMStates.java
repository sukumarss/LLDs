package org.example.states;

import org.example.Models.ATM;
import org.example.Models.Card;
import org.example.enums.TransactionType;

public abstract class ATMStates {
    public void insertCard(ATM atm, Card card){
        System.out.println("Oops! something went wrong.");
    }
    public void authenticate(ATM atm,Card card,int pin){
        System.out.println("Oops! something went wrong.");
    }
    public void selectOption(ATM atm, Card card, TransactionType cashWithdraw){
        System.out.println("Oops! something went wrong.");
    }
    public void cashWithDraw(ATM atm,Card card,int amt){
        System.out.println("Oops! something went wrong.");
    }
    public void balanceCheck(ATM atm,Card card){
        System.out.println("Oops! something went wrong.");
    }
    public void exit(ATM atm){
        System.out.println("Oops! something went wrong.");
    }
    public void returnCard(){
        System.out.println("Oops! something went wrong.");
    }
}
