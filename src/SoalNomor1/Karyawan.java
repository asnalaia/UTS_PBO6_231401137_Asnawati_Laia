package SoalNomor1;
import java.util.HashSet;

public class Karyawan {
    private String nama;
    private String posisi;
    private double gaji;
    private int id;

    // Validasi ID
    static HashSet<Integer> daftarID = new HashSet<>();

    public Karyawan(String nama, String posisi, double gaji, String divisi, int idBaru) {
        if (daftarID.contains(idBaru)) {
            throw new IllegalArgumentException("ID " + idBaru + " sudah dipakai! Mohon gunakan ID yang lain."); // validasi ID
        } else if (gaji < 0) {
            throw new IllegalArgumentException("Gaji tidak boleh kurang dari nol."); // validasi gaji agar tidak negatif
        } else {
            this.nama = nama;
            this.posisi = posisi;
            this.gaji = gaji;
            this.id = idBaru;
            daftarID.add(idBaru);
        }
    }

    public int getID() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getPosisi() {
        return posisi;
    }

    public double getGaji() {
        return gaji;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public void setGaji(double gaji) {
        if (gaji < 0) {
            throw new IllegalArgumentException("Gaji tidak boleh kurang dari nol.");
        }
        this.gaji = gaji;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Nama: %s | Posisi: %s | Gaji: %.2f", id, nama, posisi, gaji);
    }
}
