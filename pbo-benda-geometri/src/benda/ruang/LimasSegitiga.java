package benda.ruang;

import benda.datar.Segitiga;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LimasSegitiga extends Segitiga{
    private double tinggiLimas;
    private double volume;
    private double luasPermukaan;

    public LimasSegitiga(double alas, double tinggiSegitiga, double tinggiLimas) {
        super(alas, tinggiSegitiga);
        this.tinggiLimas = tinggiLimas;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Limas Segitiga";
    }
    
    public double hitungVolume() {
        return (1.0 / 3.0) * hitungLuas() * tinggiLimas;
    }

    public double hitungLuasPermukaan() {
        double sisiMiring = Math.sqrt(Math.pow(alas / 2, 2) + Math.pow(tinggiLimas, 2));
        double luasTegak = 0.5 * alas * sisiMiring;
        return hitungLuas() + 3 * luasTegak;
    }

    public double hitungVolume(double newAlas, double newTinggiSegitiga) {
        return  (1.0 / 3.0) * newAlas * newTinggiSegitiga * tinggiLimas;
    }

    public double hitungLuasPermukaan(double newAlas, double newTinggiSegitiga) {
        double sisiMiring = Math.sqrt(Math.pow(newAlas / 2, 2) + Math.pow(tinggiLimas, 2));
        double luasTegak = 0.5 * newAlas * sisiMiring;
        return (1.0 / 2.0) * newAlas * newTinggiSegitiga + 3 * sisiMiring;
    }

    public void prosesVolumeDanLuasPermukaan() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Apakah ingin mengubah nilai alas dan tinggi segitiga? (Y/N): ");
        String jawab = inp.nextLine();

        if (jawab.equalsIgnoreCase("Y")) {
            try {
                System.out.print("Masukkan alas baru: ");
                double newAlas = inp.nextDouble();
                if (newAlas <= 0) {
                    throw new IllegalArgumentException("❌ Alas harus lebih dari nol.");
                }
                System.out.print("Masukkan tinggi baru: ");
                double newTinggiSegitiga = inp.nextDouble();
                if (newTinggiSegitiga <= 0) {
                    throw new IllegalArgumentException("❌ Tinggi segitiga harus lebih dari nol.");
                }
                volume = hitungVolume(newAlas, newTinggiSegitiga);
                luasPermukaan = hitungLuasPermukaan(newAlas, newTinggiSegitiga);
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("❌ Input alas dan tinggi segitiga harus berupa angka.");
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
