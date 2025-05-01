package SoalNomor2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalKendaraan = 0;
        int totalBiaya = 0;
        boolean lanjut = true;

        while (lanjut) {
            System.out.println("Masukkan jenis kendaraan (Motor/Mobil/Truk): ");
            String jenisKendaraan = input.nextLine();

            Kendaraan k = new Kendaraan(jenisKendaraan);

            System.out.println("Masukkan metode durasi parkir (Manual/Otomatis): ");
            String metode = input.nextLine();

            if (metode.equalsIgnoreCase("Manual")) {
                System.out.print("Masukkan durasi parkir (jam): ");
                while (!input.hasNextInt()) {
                    System.out.print("Masukkan angka durasi yang valid: ");
                    input.next();
                }
                int durasi = input.nextInt();
                k.HitungBiayaParkir(durasi);
            } else if (metode.equalsIgnoreCase("Otomatis")) {
                System.out.print("Jam masuk: ");
                int masuk = input.nextInt();
                System.out.print("Jam keluar: ");
                int keluar = input.nextInt();
                k.HitungBiayaParkir(masuk, keluar);
            } else {
                System.out.println("Inputan metode tidak valid. Ulangi dari awal.");
                continue;
            }

            input.nextLine();


            System.out.println("\n===== RINGKASAN PARKIR =====");
            System.out.println(k);


            totalKendaraan++;
            totalBiaya += k.getBiayaAkhir();


            System.out.print("Apakah ingin menambah kendaraan lagi? (y/n): ");
            String lagi = input.nextLine();
            if (!lagi.equalsIgnoreCase("y")) {
                lanjut = false;
            }
        }


        System.out.println("\n======= RINGKASAN AKHIR =======");
        System.out.println("Total kendaraan   : " + totalKendaraan);
        System.out.println("Total biaya parkir: Rp" + totalBiaya);
        System.out.println("Terimakahsih! ");
    }
}
