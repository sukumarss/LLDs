package org.example.states;

import org.example.Models.ATM;
import org.example.Models.Card;
import org.example.enums.TransactionType;

public class SelectOptionState extends ATMStates {
    @Override
    public void selectOption(ATM atm, Card card, TransactionType type){
        System.out.println("Select the transaction");
        switch (type) {
            case CASH_WITHDRAW :
                atm.setAtmState(new CashWithdrawState());
                break;
            case BALANCE_CHECK:
                atm.setAtmState(new BalanceCheckState());
                break;
            default :
                System.out.println("Invalid input");
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
