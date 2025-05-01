package SoalNomor2;

public class Kendaraan {
    private String JenisKendaraan;
    private int LamaParkir;

    public Kendaraan (String JenisKendaraan){
        this.JenisKendaraan = JenisKendaraan;
    }

    public int HitungBiayaParkir (int DurasiParkir) {
        this.LamaParkir = DurasiParkir;
        return BiayaParkir();
    }

    public int HitungBiayaParkir (int JamMasuk, int JamKeluar) {
        this.LamaParkir = JamKeluar - JamMasuk;
        if (this.LamaParkir < 0) {
            System.out.println("Jam keluar tidak boleh kurang dari jam masuk");
            this.LamaParkir = 0;
        }
        return BiayaParkir();
    }

    private int getTarifPerJam() {
        switch (JenisKendaraan) {
            case "Motor":
                return 3000;
            case "Mobil":
                return 5000;
            case "Truk":
                return 10000;
            default:
                return 0;
        }
    }

    private int BiayaParkir(){
        int Tarif = getTarifPerJam();
        int Total = LamaParkir * Tarif;

        if (LamaParkir > 5) {
            Total = Total - (Total / 10);
        }
        return Total;
    }

    @Override
    public String toString() {
        return String.format(
                "Jenis Kendaraan : %s\nLama Parkir     : %d jam\nTotal Biaya     : Rp%d\n", JenisKendaraan, LamaParkir, BiayaParkir()
        );
    }

    public int getBiayaAkhir() {
        return BiayaParkir();
    }

}
