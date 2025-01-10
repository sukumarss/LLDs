package org.example.states;

import org.example.Models.ATM;
import org.example.Models.Card;

public class IdleState extends ATMStates {
    public IdleState() {
    }

    @Override
    public void insertCard(ATM atm, Card card){
        System.out.println("Please insert your card");
        atm.setAtmState(new HasCardState());
    }

}
