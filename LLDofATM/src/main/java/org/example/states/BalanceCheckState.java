package org.example.states;

import org.example.Models.ATM;
import org.example.Models.Card;

public class BalanceCheckState extends ATMStates{

    @Override
    public void balanceCheck(ATM atm, Card card){
        System.out.println("Total available balance: "+card.getAccount().getBalance());
        exit(atm);
    }
    @Override
    public void exit(ATM atm){
        returnCard();
        atm.setAtmState(new IdleState());
        System.out.println("Exit happens");

    }

    @Override
    public void returnCard(){
        System.out.println("Please collect your card");
    }
}
