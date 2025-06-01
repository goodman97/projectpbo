package benda.ruang;

import benda.datar.Persegi;

import java.util.InputMismatchException;
import java.util.Scanner;

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
        System.out.print("Apakah ingin mengubah nilai panjang dan tinggi limas persegi panjang? (Y/N): ");
        String jawab = inp.nextLine();

        if (jawab.equalsIgnoreCase("Y")) {
            try {
                 System.out.print("Masukkan Sisi baru: ");
                double newSisi = inp.nextDouble();
                if (newSisi <= 0) {
                    throw new IllegalArgumentException("❌ Sisi harus lebih dari nol.");
                }
                System.out.print("Masukkan tinggi baru: ");
                double newtinggiLimas = inp.nextDouble();
                if (newtinggiLimas <= 0) {
                    throw new IllegalArgumentException("❌ Tinggi limas harus lebih dari nol.");
                }
                volume = hitungVolume(newSisi, newtinggiLimas);
                luasPermukaan = hitungLuasPermukaan(newSisi, newtinggiLimas);
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("❌ Inputan harus berupa angka.");
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
