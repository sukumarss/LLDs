package org.example;

import org.example.models.Cell;
import org.example.models.Dice;
import org.example.models.Jump;
import org.example.models.Player;

import java.util.*;

public class Board {
    Cell[][] cells;
    int length;
    Queue<Player> playersQue = new LinkedList<>();
    Map<Integer, List<Integer>> snakesMap = new HashMap<>();
    Map<Integer, List<Integer>> laddersMap = new HashMap<>();
    Dice dice;
    Scanner sc = new Scanner(System.in);

    public Board(int players, int size, int dice, int snakes, int ladders) {
        this.cells = new Cell[size][size];
        int pos = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell();
                cells[i][j].setPosition(pos++);
            }
        }
        this.length = size;
        addSnakesAndLadders(snakes, ladders);
        addPlayers(players);
        Dice dic = new Dice(dice);
        this.dice = dic;
    }

    private void addPlayers(int players) {
        int i = 0;
        while (i < players) {
            System.out.println("Player " + (i + 1) + " name: ");
            String name = sc.nextLine();
            Player player = new Player(name, cells[0][0]);
            playersQue.add(player); // Add player to the queue
            i++;
        }
    }

    public int roll() {
        return dice.roll();
    }

    private void addSnakesAndLadders(int snakes, int ladders) {
        while (snakes > 0) {
            int start = (int) (Math.random() * (length * length)) + 1;
            int end = (int) (Math.random() * (length * length)) + 1;
            if (Math.abs(start - end) >= length / 4 && end < start) {
                List<Integer> lis = snakesMap.get(start);
                if (lis == null) {
                    lis = new ArrayList<>();
                }
                if (!lis.contains(end)) {
                    lis.add(end);
                    snakesMap.put(start, lis);
                    snakes--;
                    Jump jump = new Jump(start, end);
                    int startRow = (start - 1) / length;
                    int startCol = (start - 1) % length;
                    cells[startRow][startCol].setJump(jump);
                }
            }
        }

        while (ladders > 0) {
            int start = (int) (Math.random() * (length * length)) + 1;
            int end = (int) (Math.random() * (length * length)) + 1;
            if (Math.abs(start - end) >= length / 4 && end > start) {
                List<Integer> lis = laddersMap.get(start);
                if (lis == null) {
                    lis = new ArrayList<>();
                }
                if (!lis.contains(end)) {
                    lis.add(end);
                    laddersMap.put(start, lis);
                    ladders--;
                    Jump jump = new Jump(start, end);
                    int startRow = (start - 1) / length;
                    int startCol = (start - 1) % length;
                    cells[startRow][startCol].setJump(jump);
                }
            }
        }
    }

    public int getLength() {
        return length;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Queue<Player> getPlayersQue() {
        return playersQue;
    }

    public Map<Integer, List<Integer>> getSnakesMap() {
        return snakesMap;
    }

    public Map<Integer, List<Integer>> getLaddersMap() {
        return laddersMap;
    }
}
