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

    public void prosesVolumeDanLuasPermukaan() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Apakah ingin mengubah nilai diagonal dan sisi? (Y/N): ");
        String jawab = inp.nextLine();

        if (jawab.equalsIgnoreCase("Y")) {
            try {
                System.out.print("Masukkan diagonal 1 baru: ");
                double newDiagonal1 = inp.nextDouble();
                if (newDiagonal1 <= 0) {
                    throw new IllegalArgumentException("❌ Diagonal 1 harus lebih dari nol.");
                }
                System.out.print("Masukkan diagonal 2 baru: ");
                double newDiagonal2 = inp.nextDouble();
                if (newDiagonal2 <= 0) {
                    throw new IllegalArgumentException("❌ Diagonal 2 harus lebih dari nol.");
                }
                System.out.print("Masukkan sisi baru: ");
                double newSisi = inp.nextDouble();
                if (newSisi <= 0) {
                    throw new IllegalArgumentException("❌ Sisi harus lebih dari nol.");
                }
                volume = hitungVolume(newDiagonal1, newDiagonal2, newSisi);
                luasPermukaan = hitungLuasPermukaan(newDiagonal1, newDiagonal2, newSisi);
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("❌ Input diagonal dan sisi harus berupa angka.");
            }
        } else if (jawab.equalsIgnoreCase("N")) {
            volume = hitungVolume();
            luasPermukaan = hitungLuasPermukaan();
        } else {
            throw new IllegalArgumentException("❌ Jawaban hanya boleh Y atau N.");
        }
    }

    public double getVolume(){
        return volume;
    }

    public double getLuasPermukaan(){
        return luasPermukaan;
    }
}