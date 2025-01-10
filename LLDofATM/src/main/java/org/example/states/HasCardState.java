package org.example.states;

import org.example.Models.ATM;
import org.example.Models.Card;

public class HasCardState extends ATMStates {

    public HasCardState(){
        System.out.println("Enter the pin");

    }
    @Override
    public void authenticate(ATM atm, Card card, int pin){
        if(card.isValidPin(card,pin)){
            atm.setAtmState(new SelectOptionState());
        }
        else{
            exit(atm);
        }

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
