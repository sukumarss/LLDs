package org.example.models;

public class Dice {
    int NDice;

    public Dice(int dice) {
        this.NDice=dice;
    }

    public int getNDice() {
        return NDice;
    }

    public int roll() {
        int jums=(int) (Math.random() * (NDice*6 + 1));
        if(jums<NDice){
            return NDice;
        }
        return jums;
    }
}
