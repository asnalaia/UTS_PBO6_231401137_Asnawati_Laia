package SoalNomor3;

import java.util.Random;

class LotreBoard {
    private char [][] board;
    private boolean [][] revealed;
    private int [][] data;
    private int safeRevealed;

    public LotreBoard() {
        board = new char[4][5];
        revealed = new boolean[4][5];
        data = new int[4][5];
        safeRevealed = 0;
        generateBoard();
    }

    public void generateBoard() {
        Random rand = new Random();
        int bombsPlaced = 0;

        while (bombsPlaced < 2) {
            int row = rand.nextInt(4);
            int col = rand.nextInt(5);
            if (data[row][col] == 0) {
                data[row][col] = 1;
                bombsPlaced++;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = '*';
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (revealed[i][j]) {
                    if (data[i][j] == 1) {
                        System.out.print("X ");
                    } else {
                        System.out.print("O ");
                    }
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    public boolean guess(int row, int col) {
        if (row < 0 || row >= 4 || col < 0 || col >= 5) {
            System.out.println("Posisi di luar jangkauan!");
            return true;
        }

        if (revealed[row][col]) {
            System.out.println("Kotak telah dibuka!");
            return true;
        }

        revealed[row][col] = true;

        if (data[row][col] == 1) {
            board[row][col] = 'X';
            return false;
        } else {
            board[row][col] = 'O';
            safeRevealed++;
            return true;
        }
    }

    public boolean isGameOver() {
        return safeRevealed == 18;
    }
}
