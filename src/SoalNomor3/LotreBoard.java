package SoalNomor3;

import java.util.Random;

class LotreBoard {
    private char [][] board;
    private boolean [][] revealed;
    private int [][] data;
    private int safeRevealed;

    //inisialisasi ukuran dan isi papan
    public LotreBoard() {
        board = new char[4][5];
        revealed = new boolean[4][5];
        data = new int[4][5];
        safeRevealed = 0;
        generateBoard();
    }

    //buat papan berisi bom acak
    public void generateBoard() {
        Random rand = new Random();
        int bombsPlaced = 0;

        while (bombsPlaced < 2) {
            int row = rand.nextInt(4);
            int col = rand.nextInt(5);
            if (data[row][col] == 0) { //memastikan tidak menimpa bom yang sudah ada
                data[row][col] = 1;
                bombsPlaced++;
            }
        }

        //inisialisasi papan yang belum dibuka dengan *
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = '*';
            }
        }
    }

    //menampilkan kotak yang sudah dibuka
    public void displayBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (revealed[i][j]) {
                    //jika kotak berisi bom maka akan menampilkan X
                    if (data[i][j] == 1) {
                        System.out.print("X ");
                    } else {
                        //jika kotak aman
                        System.out.print("O ");
                    }
                } else {
                    //jika kotak belum dibuka
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }


    public boolean guess(int row, int col) {
        //validasi agar inputan tidak diluar batas
        if (row < 0 || row >= 4 || col < 0 || col >= 5) {
            System.out.println("Posisi di luar jangkauan!");
            return true;
        }

        //jika kotak telah dibuka sebelmmnya
        if (revealed[row][col]) {
            System.out.println("Kotak telah dibuka!");
            return true;
        }

        revealed[row][col] = true;

        //jika kotak adalah bom, permainanan berakhir
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
