package ruang;

import datar.Persegi;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LimasPersegi extends Persegi implements Runnable {
    protected double tinggiLimas;
    protected double volume;
    protected double luasPermukaan;

    // Konstruktor untuk inisialisasi limas persegi
    public LimasPersegi(double sisi, double tinggiLimas) {
        super(sisi);
        this.tinggiLimas = tinggiLimas;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    // Implementasi metode getNama dari BangunDatar
    @Override
    public String getNama() {
        return "Limas Persegi";
    }

    // Menghitung volume limas
    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.getLuas() * tinggiLimas;
        return volume;
    }

    // Metode overloaded untuk menghitung volume dengan nilai baru
    public double hitungVolume(double sisiBaru, double tinggiLimasBaru) {
        super.setSisi(sisiBaru);
        this.tinggiLimas = tinggiLimasBaru;
        super.hitungLuas(sisiBaru); // Perbarui luas di kelas induk
        super.hitungKeliling(sisiBaru); // Perbarui keliling di kelas induk
        return (1.0 / 3.0) * super.getLuas() * tinggiLimasBaru;
    }

    // Menghitung luas permukaan limas
    public double hitungLuasPermukaan() {
        double luasSegitigaTegak = 0.5 * super.getSisi() * Math.sqrt(Math.pow((0.5 * super.getSisi()), 2) + Math.pow(tinggiLimas, 2));
        luasPermukaan = super.getLuas() + 4 * luasSegitigaTegak;
        return luasPermukaan;
    }

    // Metode overloaded untuk menghitung luas permukaan dengan nilai baru
    public double hitungLuasPermukaan(double sisiBaru, double tinggiLimasBaru) {
        super.setSisi(sisiBaru);
        this.tinggiLimas = tinggiLimasBaru;
        super.hitungLuas(sisiBaru); // Perbarui luas di kelas induk
        super.hitungKeliling(sisiBaru); // Perbarui keliling di kelas induk
        double luasSegitigaTegak = 0.5 * sisiBaru * Math.sqrt(Math.pow((0.5 * sisiBaru), 2) + Math.pow(tinggiLimasBaru, 2));
        return super.getLuas() + 4 * luasSegitigaTegak;
    }

    // Memproses input pengguna dengan validasi
    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.printf("\nNilai sisi persegi saat ini adalah %.2f dan tinggi limas adalah %.2f. Apakah ingin mengubah nilai? (Y/N): ", 
                              super.getSisi(), this.tinggiLimas);
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan sisi baru: ");
                        double sisiBaru = inp.nextDouble();
                        System.out.print("Masukkan tinggi limas baru: ");
                        double tinggiLimasBaru = inp.nextDouble();
                        inp.nextLine();

                        // Validasi input
                        if (sisiBaru <= 0) {
                            System.out.println("Sisi harus lebih dari nol.\n");
                            continue;
                        }
                        if (tinggiLimasBaru <= 0) {
                            System.out.println("Tinggi limas harus lebih dari nol.\n");
                            continue;
                        }

                        // Update nilai
                        super.setSisi(sisiBaru);
                        this.tinggiLimas = tinggiLimasBaru;
                        super.hitungLuas(sisiBaru);
                        super.hitungKeliling(sisiBaru);
                        this.volume = hitungVolume(sisiBaru, tinggiLimasBaru);
                        this.luasPermukaan = hitungLuasPermukaan(sisiBaru, tinggiLimasBaru);

                        System.out.printf("\nLuas Alas Persegi: %.2f\n", super.getLuas());
                        System.out.printf("Keliling Alas Persegi: %.2f\n", super.getKeliling());
                        System.out.printf("Volume Limas Persegi: %.2f\n", volume);
                        System.out.printf("Luas Permukaan Limas Persegi: %.2f\n", luasPermukaan);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid. Silakan masukkan angka yang benar.\n");
                        inp.nextLine();
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                this.volume = hitungVolume();
                this.luasPermukaan = hitungLuasPermukaan();
                break;
            } else {
                System.out.println("Jawaban hanya boleh Y atau N.\n");
            }
        }
    }

    // Getter
    public double getTinggiLimas() {
        return tinggiLimas;
    }

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }

    // Setter
    public void setTinggiLimas(double tinggiLimas) {
        this.tinggiLimas = tinggiLimas;
    }

    // Implementasi metode run dari Runnable
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("--- Thread [%s] sedang memproses objek Limas Persegi ---\n", threadName);
        try {
            System.out.printf("[%s] Menghitung properti Limas Persegi (sisi: %.2f, tinggi limas: %.2f)...\n", 
                              threadName, super.getSisi(), this.tinggiLimas);
            Thread.sleep(1500);
            double luasDihitung = super.hitungLuas();
            double kelilingDihitung = super.hitungKeliling();
            double volumeDihitung = this.hitungVolume();
            double luasPermukaanDihitung = this.hitungLuasPermukaan();
            System.out.printf("[%s] Hasil Limas Persegi -> Luas Alas: %.2f, Keliling Alas: %.2f, Volume: %.2f, Luas Permukaan: %.2f\n", 
                              threadName, luasDihitung, kelilingDihitung, volumeDihitung, luasPermukaanDihitung);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("Thread [%s] diinterupsi.\n", threadName);
        }
        System.out.printf("Thread [%s] selesai.\n", threadName);
    }
}
