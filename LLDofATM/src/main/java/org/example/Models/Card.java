package org.example.Models;

public class Card {
    UserAccount account;
    private int pin =2002;
    String expiry;
    int cvv;
    int cardNo;

    public boolean isValidPin(Card card,int pin){
        return pin==card.pin;
    }
    public UserAccount getAccount() {
        return account;
    }

    public void setAccount(UserAccount account) {
        this.account = account;
    }
}
