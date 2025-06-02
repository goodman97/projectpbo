package benda.ruang;

import benda.datar.Persegi;
<<<<<<< HEAD
import java.util.*;
=======

import java.util.InputMismatchException;
import java.util.Scanner;
>>>>>>> b0cfc26bb44bcf0883e1559161b5cb260a9d0b33

public class LimasPersegi extends Persegi{
    protected double tinggiLimas;
    protected double volume;
    protected double luasPermukaan;

    public LimasPersegi(double sisi, double tinggiLimas) {
        super(sisi);
        this.tinggiLimas = tinggiLimas;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
        
    }

    @Override
    public String getNama() {
        return "Limas Persegi";
    }

    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.luas * tinggiLimas;
        return volume;
    }

    public double hitungVolume(double newSisi, double tinggiLimas) {
        volume = (1.0 / 3.0) * Math.pow(newSisi, 2) * tinggiLimas;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double luasSegitigaTegak = 0.5 * super.sisi * Math.sqrt(Math.pow((0.5 * super.sisi), 2) + Math.pow(tinggiLimas, 2));
        luasPermukaan = super.luas + 4 * luasSegitigaTegak;
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newSisi, double tinggiLimas) {
        double luasSegitigaTegak = 0.5 * newSisi * Math.sqrt(Math.pow((0.5 * newSisi), 2) + Math.pow(tinggiLimas, 2));
        luasPermukaan = Math.pow(newSisi, 2) + 4 * luasSegitigaTegak;
        return luasPermukaan;
    }

    public void prosesHitungVolumeDanLuasPermukaan() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Nilai sisi persegi saat ini adalah " + super.sisi + "Apakah ingin mengubah nilai sisi persegi? (Y/N): ");
        String jawab = inp.nextLine();

        if (jawab.equalsIgnoreCase("Y")) {
            try {
                System.out.print("Masukkan sisi baru: ");
                double newSisi = inp.nextDouble();
                if (newSisi <= 0) {
                    throw new IllegalArgumentException("Sisi harus lebih dari nol.");
                }
                System.out.print("Masukkan tinggi limas persegi: ");
                double tinggiLimas = inp.nextDouble();
                if (tinggiLimas <= 0) {
                    throw new IllegalArgumentException("Tinggi limas harus lebih dari nol.");
                }
                volume = hitungVolume(newSisi, tinggiLimas);
                luasPermukaan = hitungLuasPermukaan(newSisi, tinggiLimas);
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("Inputan harus berupa angka.");
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
