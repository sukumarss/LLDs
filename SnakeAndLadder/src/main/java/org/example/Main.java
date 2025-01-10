package org.example;

public class Main {
    public static void main(String[] args) {
        Game game = Game.getInstanceOfGame();

        // Parameters: Number of players, Board size, Number of dice, Number of snakes, Number of ladders
        game.start(4, 10, 2, 6, 8);
    }
}
