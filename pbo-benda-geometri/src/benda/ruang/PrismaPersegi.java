package benda.ruang;

import benda.datar.Persegi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrismaPersegi extends Persegi{
    protected double tinggiPrisma;
    protected double volume;
    protected double luasPermukaan;

    public PrismaPersegi(double sisi, double tinggiPrisma) {
        super(sisi);
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Prisma Persegi";
    }

    public double hitungVolume() {
        volume = super.luas * tinggiPrisma;
        return volume;
    }

    public double hitungVolume(double newSisi, double tinggiPrisma) {
        volume = Math.pow(newSisi, 2) * tinggiPrisma;
        return volume;
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = 2 * super.luas + 4 * sisi * tinggiPrisma;
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newSisi, double tinggiPrisma) {
        luasPermukaan = 4 * (newSisi * tinggiPrisma) + 2 * (Math.pow(newSisi, 2));
        return luasPermukaan;
    }
    public void prosesHitungVolumeDanLuasPermukaan() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Apakah ingin mengubah nilai panjang dan tinggi prisma persegi? (Y/N): ");
        String jawab = inp.nextLine();

        if (jawab.equalsIgnoreCase("Y")) {
            try {
                 System.out.print("Masukkan sisi baru: ");
                double newSisi = inp.nextDouble();
                if (newSisi <= 0) {
                    throw new IllegalArgumentException("❌ Sisi harus lebih dari nol.");
                }
                System.out.print("Masukkan tinggi baru: ");
                double newtinggiPrisma = inp.nextDouble();
                if (newtinggiPrisma <= 0) {
                    throw new IllegalArgumentException("❌ Tinggi Prisma harus lebih dari nol.");
                }
                volume = hitungVolume(newSisi, newtinggiPrisma);
                luasPermukaan = hitungLuasPermukaan(newSisi, newtinggiPrisma);
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("❌ Input an harus berupa angka.");
            }
        } else if (jawab.equalsIgnoreCase("N")) {
            volume = hitungVolume();
            luasPermukaan = hitungLuasPermukaan();
        } else {
            throw new IllegalArgumentException("❌ Jawaban hanya boleh Y atau N.");
        }
    }

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }
    
}
