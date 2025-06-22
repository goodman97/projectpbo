package ruang;

import datar.Trapesium;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrismaTrapesium extends Trapesium {
    protected double tinggiPrisma;
    protected double volume;
    protected double luasPermukaan;

    // Konstruktor untuk inisialisasi prisma trapesium
    public PrismaTrapesium(double atas, double bawah, double tinggiAlas, double tinggiPrisma) {
        super(atas, bawah, tinggiAlas);
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    // Implementasi metode getNama dari BangunDatar
    @Override
    public String getNama() {
        return "Prisma Trapesium";
    }

    // Menghitung volume prisma
    public double hitungVolume() {
        volume = super.luas * tinggiPrisma;
        return volume;
    }

    // Metode overloaded untuk menghitung volume dengan nilai baru
    public double hitungVolume(double atasBaru, double bawahBaru, double tinggiAlasBaru, double tinggiPrismaBaru) {
        this.atas = atasBaru;
        this.bawah = bawahBaru;
        this.tinggi = tinggiAlasBaru;
        this.tinggiPrisma = tinggiPrismaBaru;
        this.sisiMiring = Math.sqrt(Math.pow((bawahBaru - atasBaru) / 2.0, 2) + Math.pow(tinggiAlasBaru, 2));
        this.luas = super.hitungLuas(atasBaru, bawahBaru, tinggiAlasBaru);
        this.keliling = super.hitungKeliling(atasBaru, bawahBaru);
        return this.luas * tinggiPrismaBaru;
    }

    // Menghitung luas permukaan prisma
    public double hitungLuasPermukaan() {
        luasPermukaan = 2 * super.luas + super.keliling * tinggiPrisma;
        return luasPermukaan;
    }

    // Metode overloaded untuk menghitung luas permukaan dengan nilai baru
    public double hitungLuasPermukaan(double atasBaru, double bawahBaru, double tinggiAlasBaru, double tinggiPrismaBaru) {
        this.atas = atasBaru;
        this.bawah = bawahBaru;
        this.tinggi = tinggiAlasBaru;
        this.tinggiPrisma = tinggiPrismaBaru;
        this.sisiMiring = Math.sqrt(Math.pow((bawahBaru - atasBaru) / 2.0, 2) + Math.pow(tinggiAlasBaru, 2));
        this.luas = super.hitungLuas(atasBaru, bawahBaru, tinggiAlasBaru);
        this.keliling = super.hitungKeliling(atasBaru, bawahBaru);
        return 2 * this.luas + this.keliling * tinggiPrismaBaru;
    }

    // Memproses input pengguna dengan validasi
    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.printf("\nNilai alas atas saat ini adalah %.2f, alas bawah %.2f, tinggi alas %.2f, dan tinggi prisma %.2f. Apakah ingin mengubah nilai? (Y/N): ", 
                              super.atas, super.bawah, super.tinggi, this.tinggiPrisma);
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan Alas Atas Baru: ");
                        double atasBaru = inp.nextDouble();
                        System.out.print("Masukkan Alas Bawah Baru: ");
                        double bawahBaru = inp.nextDouble();
                        System.out.print("Masukkan Tinggi Alas Baru: ");
                        double tinggiAlasBaru = inp.nextDouble();
                        System.out.print("Masukkan Tinggi Prisma Baru: ");
                        double tinggiPrismaBaru = inp.nextDouble();
                        inp.nextLine();

                        // Validasi input
                        if (atasBaru <= 0 || bawahBaru <= 0 || tinggiAlasBaru <= 0 || tinggiPrismaBaru <= 0) {
                            System.out.println("Nilai harus lebih dari nol.\n");
                            continue;
                        }

                        // Update nilai
                        this.atas = atasBaru;
                        this.bawah = bawahBaru;
                        this.tinggi = tinggiAlasBaru;
                        this.tinggiPrisma = tinggiPrismaBaru;
                        this.sisiMiring = Math.sqrt(Math.pow((bawahBaru - atasBaru) / 2.0, 2) + Math.pow(tinggiAlasBaru, 2));
                        this.luas = super.hitungLuas(atasBaru, bawahBaru, tinggiAlasBaru);
                        this.keliling = super.hitungKeliling(atasBaru, bawahBaru);
                        this.volume = hitungVolume(atasBaru, bawahBaru, tinggiAlasBaru, tinggiPrismaBaru);
                        this.luasPermukaan = hitungLuasPermukaan(atasBaru, bawahBaru, tinggiAlasBaru, tinggiPrismaBaru);

                        System.out.printf("\nLuas Alas Trapesium: %.2f\n", this.luas);
                        System.out.printf("Keliling Alas Trapesium: %.2f\n", this.keliling);
                        System.out.printf("Volume Prisma Trapesium: %.2f\n", this.volume);
                        System.out.printf("Luas Permukaan Prisma Trapesium: %.2f\n", this.luasPermukaan);
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
                System.out.println("Pilihan tidak valid. Silakan masukkan Y atau N.\n");
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

    public double getAtas() {
        return atas;
    }

    public double getBawah() {
        return bawah;
    }

    public double getTinggi() {
        return tinggi;
    }

    public double getSisiMiring() {
        return sisiMiring;
    }

    public double getLuas() {
        return luas;
    }

    public double getKeliling() {
        return keliling;
    }
}
