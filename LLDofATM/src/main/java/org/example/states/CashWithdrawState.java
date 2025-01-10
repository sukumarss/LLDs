package org.example.states;

import org.example.Models.ATM;
import org.example.Models.Card;

public class CashWithdrawState extends ATMStates {
    @Override
    public void cashWithDraw(ATM atm, Card card, int amt){
        if(atm.getBalance()<amt){
            System.out.println("Not enough funds");
        }
        else if(card.getAccount().getBalance()<amt){
            System.out.println("Insufficient Balance");
        }
        else{
            System.out.println("Money debited: "+amt);
            card.getAccount().withDraw(amt);
        }
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
