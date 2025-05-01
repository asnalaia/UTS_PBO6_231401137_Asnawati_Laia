package SoalNomor1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Perusahaan perusahaan = new Perusahaan();

        while (true) {
            System.out.println("\n=== MENU PERUSAHAAN ===");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Hapus Karyawan");
            System.out.println("3. Ubah Posisi Karyawan");
            System.out.println("4. Ubah Gaji Karyawan");
            System.out.println("5. Tampilkan Semua Karyawan");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1: //tambah karyawan
                    try {
                        System.out.print("Masukkan nama: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan posisi: ");
                        String posisi = scanner.nextLine();
                        System.out.print("Masukkan gaji: ");
                        double gaji = scanner.nextDouble();
                        String divisi = scanner.nextLine();
                        System.out.print("Masukkan ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        Karyawan karyawanBaru = new Karyawan(nama, posisi, gaji, divisi, id);
                        perusahaan.tambahKaryawan(karyawanBaru);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Gagal menambahkan data karyawan: " + e.getMessage());
                    }
                    break;

                case 2: //hapus data karyawan
                    System.out.print("Masukkan ID karyawan yang ingin dihapus: ");
                    int idHapus = scanner.nextInt();
                    scanner.nextLine();
                    perusahaan.hapusKaryawan(idHapus);
                    break;

                case 3: //ubah posisi karyawan
                    System.out.print("Masukkan ID karyawan: ");
                    int idUbahPosisi = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan posisi baru: ");
                    String posisiBaru = scanner.nextLine();
                    perusahaan.ubahPosisi(idUbahPosisi, posisiBaru);
                    break;

                case 4: //ubah gaji karyawan
                    System.out.print("Masukkan ID karyawan: ");
                    int idUbahGaji = scanner.nextInt();
                    System.out.print("Masukkan gaji baru: ");
                    double gajiBaru = scanner.nextDouble();
                    scanner.nextLine();
                    perusahaan.ubahGaji(idUbahGaji, gajiBaru);
                    break;


                case 5: //menampilkan semua data karyawan
                    perusahaan.tampilkanSemuaKaryawan();
                    break;


                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

    }
}
