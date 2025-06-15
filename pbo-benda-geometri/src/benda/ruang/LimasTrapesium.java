package benda.ruang;

import benda.datar.Trapesium;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LimasTrapesium extends Trapesium{
    private double tinggiLimas;
    private double volume;
    private double luasPermukaan;

    public LimasTrapesium(double atas, double bawah, double tinggiAlas, double sisiMiring, double tinggiLimas) {
        super(atas, bawah, tinggiAlas, sisiMiring);
        this.tinggiLimas = tinggiLimas;
    }
    
    @Override
    public String getNama() {
        return "Limas Trapesium";
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * super.luas * tinggiLimas;
    }

    public double hitungVolume(double newAtas, double newBawah, double newTinggi, double tinggiLimas) {
        return (1.0 / 3.0) * (newAtas + newBawah) * 0.5 * newTinggi * tinggiLimas;
    }

    public double hitungLuasPermukaan() {
        double luasSegitigaTegak = 0.5 * super.keliling * tinggiLimas / 4;
        return hitungLuas() + 4 * luasSegitigaTegak;
    }

    public double hitungLuasPermukaan(double newAtas, double newBawah, double newTinggi, double tinggiLimas) {
        double luasSegitigaTegak = 0.5 * super.keliling * tinggiLimas / 4;
        return hitungLuas() + 4 * luasSegitigaTegak;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Apakah ingin mengubah nilai panjang dan tinggi limas trapesium? (Y/N): ");
        String jawab = inp.nextLine();

        if (jawab.equalsIgnoreCase("Y")) {
            try {
                super.prosesInputDanValidasi();
                System.out.print("Masukkan tinggi limas baru: ");
                double newTinggiLimas = inp.nextDouble();
                inp.nextLine();
                if (newTinggiLimas <= 0) {
                    throw new IllegalArgumentException("❌ Tinggi limas harus lebih dari nol.");
                }
                this.tinggiLimas = newTinggiLimas;
                volume = hitungVolume();
                luasPermukaan = hitungLuasPermukaan();
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("❌ Input harus berupa angka.");
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
