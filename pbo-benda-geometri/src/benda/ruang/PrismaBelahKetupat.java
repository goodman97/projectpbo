package benda.ruang;

import benda.datar.BelahKetupat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrismaBelahKetupat extends BelahKetupat{
    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;
    

    public PrismaBelahKetupat(double tinggiPrisma, double diagonal1, double diagonal2, double sisi) {
        super(diagonal1, diagonal2, sisi);
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }
    
    @Override
    public String getNama() {
        return "Prisma Belah Ketupat";
    }

    public double hitungVolume() {
        volume = super.luas * tinggiPrisma;
        return volume; 
    }
    
    public double hitungLuasPermukaan() {
        luasPermukaan = (super.luas*2) + (sisi * tinggiPrisma) * 4;
        return luasPermukaan;
    }

    public double hitungVolume(double newDiagonal1, double newDiagonal2, double newSisi) {
        return  (1.0 / 2.0) * newDiagonal1 * newDiagonal2 * tinggiPrisma;
    }

    public double hitungLuasPermukaan(double newDiagonal1, double newDiagonal2, double newSisi) {
        luasPermukaan = ((1.0 / 2.0) * newDiagonal1 * newDiagonal2) + (newSisi * tinggiPrisma) * 4;
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai diagonal dan sisi yang baru? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan diagonal 1 yang baru: ");
                        double newDiagonal1 = inp.nextDouble();
                        inp.nextLine();
                        if (newDiagonal1 <= 0) {
                            System.out.println("Diagonal 1 harus lebih dari nol.\n");
                            continue;
                        }

                        System.out.print("Masukkan diagonal 2 yang baru: ");
                        double newDiagonal2 = inp.nextDouble();
                        inp.nextLine();
                        if (newDiagonal2 <= 0) {
                            System.out.println("Diagonal 2 harus lebih dari nol.\n");
                            continue;
                        }

                        System.out.print("Masukkan sisi yang baru: ");
                        double newSisi = inp.nextDouble();
                        inp.nextLine();
                        if (newSisi <= 0) {
                            System.out.println("Sisi harus lebih dari nol.\n");
                            continue;
                        }

                        System.out.print("Masukkan tinggi prisma: ");
                        this.tinggiPrisma = inp.nextDouble();
                        inp.nextLine();
                        if (tinggiPrisma <= 0) {
                            System.out.println("Tinggi prisma harus lebih dari nol.\n");
                            continue;
                        }

                        super.diagonal1 = newDiagonal1;
                        super.diagonal2 = newDiagonal2;
                        super.sisi = newSisi;
                        this.tinggiPrisma = tinggiPrisma;
                        super.luas = super.hitungLuas();
                        this.volume = hitungVolume(newDiagonal1, newDiagonal2, newSisi);
                        this.luasPermukaan = hitungLuasPermukaan(newDiagonal1, newDiagonal2, newSisi);
                        break;

                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka.");
                        inp.nextLine();
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                while (true) {
                    try {
                        System.out.print("Masukkan tinggi prisma: ");
                        this.tinggiPrisma = inp.nextDouble();
                        inp.nextLine();
                        if (tinggiPrisma <= 0) {
                            System.out.println("Tinggi prisma harus lebih dari nol.\n");
                            continue;
                        }

                        this.tinggiPrisma = tinggiPrisma;
                        this.volume = hitungVolume();
                        this.luasPermukaan = hitungLuasPermukaan();
                        break;

                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka.");
                        inp.nextLine();
                    }
                }
                break;
            } else {
                System.out.println("Jawaban hanya boleh Y atau N.\n");
            }
        }
    }

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
    }
}