package SoalNomor3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LotreBoard game = new LotreBoard();
        boolean running = true;

        System.out.println("Selamat datang di permainan Lotre Gosok!");

        while (running) {
            game.displayBoard();
            System.out.print("Masukkan tebakan anda (baris dan kolom): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            boolean result = game.guess(row, col);
            if (!result) {
                System.out.println("BOOM! Kamu mengenai bom. Permainan berakhir.");
                game.displayBoard();
                running = false;
            } else if (game.isGameOver()) {
                System.out.println("Selamat! Kamu berhasil menghindari semua bom!");
                game.displayBoard();
                running = false;
            }
        }

    }
}