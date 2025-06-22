package ruang;

import datar.Persegi;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrismaPersegi extends Persegi implements Runnable {
    protected double tinggiPrisma;
    protected double volume;
    protected double luasPermukaan;

    // Konstruktor untuk inisialisasi prisma persegi
    public PrismaPersegi(double sisi, double tinggiPrisma) {
        super(sisi);
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    // Implementasi metode getNama dari BangunDatar
    @Override
    public String getNama() {
        return "Prisma Persegi";
    }

    // Menghitung volume prisma
    public double hitungVolume() {
        volume = super.getLuas() * tinggiPrisma;
        return volume;
    }

    // Metode overloaded untuk menghitung volume dengan nilai baru
    public double hitungVolume(double sisiBaru, double tinggiPrismaBaru) {
        super.setSisi(sisiBaru);
        this.tinggiPrisma = tinggiPrismaBaru;
        super.hitungLuas(sisiBaru); // Perbarui luas di kelas induk
        super.hitungKeliling(sisiBaru); // Perbarui keliling di kelas induk
        return super.getLuas() * tinggiPrismaBaru;
    }

    // Menghitung luas permukaan prisma
    public double hitungLuasPermukaan() {
        luasPermukaan = 2 * super.getLuas() + super.getKeliling() * tinggiPrisma;
        return luasPermukaan;
    }

    // Metode overloaded untuk menghitung luas permukaan dengan nilai baru
    public double hitungLuasPermukaan(double sisiBaru, double tinggiPrismaBaru) {
        super.setSisi(sisiBaru);
        this.tinggiPrisma = tinggiPrismaBaru;
        super.hitungLuas(sisiBaru); // Perbarui luas di kelas induk
        super.hitungKeliling(sisiBaru); // Perbarui keliling di kelas induk
        return 2 * super.getLuas() + super.getKeliling() * tinggiPrismaBaru;
    }

    // Memproses input pengguna dengan validasi
    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.printf("\nNilai sisi persegi saat ini adalah %.2f dan tinggi prisma adalah %.2f. Apakah ingin mengubah nilai? (Y/N): ", 
                              super.getSisi(), this.tinggiPrisma);
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan sisi baru: ");
                        double sisiBaru = inp.nextDouble();
                        System.out.print("Masukkan tinggi prisma baru: ");
                        double tinggiPrismaBaru = inp.nextDouble();
                        inp.nextLine();

                        // Validasi input
                        if (sisiBaru <= 0) {
                            System.out.println("Sisi harus lebih dari nol.\n");
                            continue;
                        }
                        if (tinggiPrismaBaru <= 0) {
                            System.out.println("Tinggi prisma harus lebih dari nol.\n");
                            continue;
                        }

                        // Update nilai
                        super.setSisi(sisiBaru);
                        this.tinggiPrisma = tinggiPrismaBaru;
                        super.hitungLuas(sisiBaru);
                        super.hitungKeliling(sisiBaru);
                        this.volume = hitungVolume(sisiBaru, tinggiPrismaBaru);
                        this.luasPermukaan = hitungLuasPermukaan(sisiBaru, tinggiPrismaBaru);

                        System.out.printf("\nLuas Alas Persegi: %.2f\n", super.getLuas());
                        System.out.printf("Keliling Alas Persegi: %.2f\n", super.getKeliling());
                        System.out.printf("Volume Prisma Persegi: %.2f\n", volume);
                        System.out.printf("Luas Permukaan Prisma Persegi: %.2f\n", luasPermukaan);
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
    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }

    // Setter
    public void setTinggiPrisma(double tinggiPrisma) {
        this.tinggiPrisma = tinggiPrisma;
    }

    // Implementasi metode run dari Runnable
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("--- Thread [%s] sedang memproses objek Prisma Persegi ---\n", threadName);
        try {
            System.out.printf("[%s] Menghitung properti Prisma Persegi (sisi: %.2f, tinggi prisma: %.2f)...\n", 
                              threadName, super.getSisi(), this.tinggiPrisma);
            Thread.sleep(1500);
            double luasDihitung = super.hitungLuas();
            double kelilingDihitung = super.hitungKeliling();
            double volumeDihitung = this.hitungVolume();
            double luasPermukaanDihitung = this.hitungLuasPermukaan();
            System.out.printf("[%s] Hasil Prisma Persegi -> Luas Alas: %.2f, Keliling Alas: %.2f, Volume: %.2f, Luas Permukaan: %.2f\n", 
                              threadName, luasDihitung, kelilingDihitung, volumeDihitung, luasPermukaanDihitung);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("Thread [%s] diinterupsi.\n", threadName);
        }
        System.out.printf("Thread [%s] selesai.\n", threadName);
    }
}
