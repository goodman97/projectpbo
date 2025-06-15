package benda.ruang;

import benda.datar.PersegiPanjang;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LimasPersegiPanjang extends PersegiPanjang{
    protected double tinggiLimas;
    protected double volume;
    protected double luasPermukaan;

    public LimasPersegiPanjang(double panjang, double lebar, double tinggiLimas) {
        super(panjang, lebar);
        this.tinggiLimas = tinggiLimas;
    }

    @Override
    public String getNama() {
        return "Limas Persegi Panjang";
    }

    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.luas * tinggiLimas;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double luasSegitigaPanjang = 0.5 * panjang * Math.sqrt(Math.pow(lebar / 2, 2) + Math.pow(tinggiLimas, 2));
        double luasSegitigaLebar = 0.5 * lebar * Math.sqrt(Math.pow(panjang / 2, 2) + Math.pow(tinggiLimas, 2));
        luasPermukaan = super.luas + 2 * luasSegitigaPanjang + 2 * luasSegitigaLebar;
        return luasPermukaan;
    }    

      public double hitungVolume(double newPanjang, double newLebar, double newtinggiLimas) {
        return (1.0 / 3.0) * newPanjang * newLebar * newtinggiLimas; 
    }

     public double hitungLuasPermukaan(double newPanjang, double newLebar, double newtinggiLimas) {
        double luasSegitigaPanjang = 0.5 * newPanjang * Math.sqrt(Math.pow(newLebar / 2, 2) + Math.pow(newtinggiLimas, 2));
        double luasSegitigaLebar = 0.5 * newLebar * Math.sqrt(Math.pow(newPanjang / 2, 2) + Math.pow(newtinggiLimas, 2));
        return newPanjang*newLebar + 2 * luasSegitigaPanjang + 2 * luasSegitigaLebar;
    }   

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Apakah ingin mengubah nilai panjang, lebar, dan tinggi limas persegi panjang? (Y/N): ");
        String jawab = inp.nextLine();

        if (jawab.equalsIgnoreCase("Y")) {
            try {
                 System.out.print("Masukkan panjang  baru: ");
                double newPanjang = inp.nextDouble();
                if (newPanjang <= 0) {
                    throw new IllegalArgumentException("❌ Panjang harus lebih dari nol.");
                }
                System.out.print("Masukkan lebar baru: ");
                double newLebar = inp.nextDouble();
                if (newLebar <= 0) {
                    throw new IllegalArgumentException("❌ lebar harus lebih dari nol.");
                }
                System.out.print("Masukkan tinggi baru: ");
                double newtinggiLimas = inp.nextDouble();
                if (newtinggiLimas <= 0) {
                    throw new IllegalArgumentException("❌ Tinggi limas harus lebih dari nol.");
                }
                volume = hitungVolume(newPanjang, newLebar, newtinggiLimas);
                luasPermukaan = hitungLuasPermukaan(newPanjang, newLebar, newtinggiLimas);
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
