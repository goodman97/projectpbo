package benda.ruang;

import benda.datar.Persegi;
import java.util.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrismaPersegi extends Persegi{
    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

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
    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Nilai sisi persegi saat ini adalah " + super.sisi +"Apakah ingin mengubah nilai sisi persegi? (Y/N): ");
        String jawab = inp.nextLine();

        if (jawab.equalsIgnoreCase("Y")) {
            try {
                 System.out.print("Masukkan sisi baru: ");
                double newSisi = inp.nextDouble();
                if (newSisi <= 0) {
                    throw new IllegalArgumentException("Sisi harus lebih dari nol.");
                }
                System.out.print("Masukkan tinggi baru: ");
                double tinggiPrisma = inp.nextDouble();
                if (tinggiPrisma <= 0) {
                    throw new IllegalArgumentException("Tinggi prisma harus lebih dari nol.");
                }
                volume = hitungVolume(newSisi, tinggiPrisma);
                luasPermukaan = hitungLuasPermukaan(newSisi, tinggiPrisma);
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("Input an harus berupa angka.");
            }
        } else if (jawab.equalsIgnoreCase("N")) {
            volume = hitungVolume();
            luasPermukaan = hitungLuasPermukaan();
        } else {
            throw new IllegalArgumentException("Jawaban hanya boleh Y atau N.");
        }
    }

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }
    
}
