package org.example;

import org.example.Models.ATM;
import org.example.Models.Card;
import org.example.Models.User;
import org.example.Models.UserAccount;
import org.example.states.IdleState;

import static org.example.enums.TransactionType.BALANCE_CHECK;
import static org.example.enums.TransactionType.CASH_WITHDRAW;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static ATM atm;
    public static void main(String[] args) {
        UserAccount acc = new UserAccount();
        acc.setBalance(1000);
        Card card = new Card();
        card.setAccount(acc);
        User user = new User();
        user.setName("Sukumar");
        user.setCard(card);


        atm = ATM.getAtmObject();
        atm.setBalance(10000);
        atm.getCurrentState().insertCard(atm,card);
        atm.getCurrentState().authenticate(atm,card,2002);
        atm.getCurrentState().selectOption(atm,card,BALANCE_CHECK);
        atm.getCurrentState().balanceCheck(atm,card);



    }
}