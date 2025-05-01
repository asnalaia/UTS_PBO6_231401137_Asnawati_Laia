package SoalNomor1;
import java.util.ArrayList;

public class Perusahaan {
    private ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();

    // Tambah karyawan baru
    public void tambahKaryawan(Karyawan karyawan) {
        for (Karyawan k : daftarKaryawan) {
            if (k.getID() == karyawan.getID()) {
                System.out.println("ID sudah terdaftar. Gagal menambahkan karyawan.");
                return;
            }
        }
        daftarKaryawan.add(karyawan);
        System.out.println("Karyawan berhasil ditambahkan: " + karyawan);
    }

    // Hapus karyawan berdasarkan ID
    public void hapusKaryawan(int id) {
        for (Karyawan k : daftarKaryawan) {
            if (k.getID() == id) {
                daftarKaryawan.remove(k);
                System.out.println("Data karyawan dengan ID " + id + " berhasil dihapus.");
                return;
            }
        }
        System.out.println("Data karyawan dengan ID " + id + " tidak ditemukan.");
    }

    // Ubah posisi karyawan berdasarkan ID
    public void ubahPosisi(int id, String posisiBaru) {
        for (Karyawan k : daftarKaryawan) {
            if (k.getID() == id) {
                k.setPosisi(posisiBaru);
                System.out.println("Posisi berhasil diubah untuk " + k.getNama());
                return;
            }
        }
        System.out.println("Data karyawan dengan ID " + id + " tidak ditemukan.");
    }

    // Ubah gaji karyawan berdasarkan ID
    public void ubahGaji(int id, double gajiBaru) {
        for (Karyawan k : daftarKaryawan) {
            if (k.getID() == id) {
                try {
                    k.setGaji(gajiBaru);
                    System.out.println("Gaji berhasil diubah untuk " + k.getNama());
                } catch (IllegalArgumentException e) {
                    System.out.println(" " + e.getMessage());
                }
                return;
            }
        }
        System.out.println("Data karyawan dengan ID " + id + " tidak ditemukan.");
    }


    // Tampilkan semua karyawan
    public void tampilkanSemuaKaryawan() {
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Tidak ada data karyawan yang terdaftar.");
        } else {
            System.out.println("Daftar data karyawan:");
            for (Karyawan k : daftarKaryawan) {
                System.out.println(k);
            }
        }
    }



}
