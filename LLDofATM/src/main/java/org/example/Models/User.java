package org.example.Models;

public class User {
    String name;
    Card card;

    public String getName() {
        return name;
    }

//    public Card getCard() {
//        return card;
//    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setName(String name) {
        this.name = name;
    }
}
