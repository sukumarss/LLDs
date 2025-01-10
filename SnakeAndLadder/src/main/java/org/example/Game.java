package org.example;

import org.example.models.Player;

import java.util.Scanner;

public class Game {
    static Game game;
    Board board;
    Scanner sc = new Scanner(System.in);

    public static Game getInstanceOfGame() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    private Game() {
    }

    public void start(int players, int size, int dice, int snakes, int ladders) {
        Board board = new Board(players, size, dice, snakes, ladders);
        this.board = board;
        play();
    }

    public void play() {
        while (board.playersQue.size() > 1) {
            Player player = board.playersQue.poll();
            System.out.println(player.getName() + "'s turn");
            int rollValue = board.roll();
            System.out.println(player.getName() + " rolled a " + rollValue);

            int currentPosition = player.getCell().getPosition();
            int newPosition = currentPosition + rollValue;

            if (newPosition > board.getLength() * board.getLength()) {
                System.out.println(player.getName() + " rolled too high and stays at position " + currentPosition);
                board.playersQue.add(player);
                continue;
            }

            int row = (newPosition - 1) / board.getLength();
            int col = (newPosition - 1) % board.getLength();
            player.setPosition(board.getCells()[row][col]);

            if (player.getCell().getJump() != null) {
                int jumpStart = player.getCell().getJump().getStart();
                int jumpEnd = player.getCell().getJump().getEnd();
                System.out.println(player.getName() + " encountered a " +
                        (jumpEnd > jumpStart ? "ladder!" : "snake!"));
                row = (jumpEnd - 1) / board.getLength();
                col = (jumpEnd - 1) % board.getLength();
                player.setPosition(board.getCells()[row][col]);
            }

            System.out.println(player.getName() + " moved to position " + player.getCell().getPosition());

            if (player.getCell().getPosition() == board.getLength() * board.getLength()) {
                System.out.println(player.getName() + " wins the game!");
            } else {
                board.playersQue.add(player);
            }
        }
    }
}
