package benda.geometri;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bola extends Lingkaran {
    protected double volume;
    protected double luasPermukaan;

    public Bola(double jariJari) {
        super(jariJari);
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Bola";
    }

    public double hitungVolume() {
        volume = (4.0 / 3.0) * super.jariJari * super.luas;
        return volume;
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = 4 * super.luas;
        return luasPermukaan;
    }

    public double hitungVolume(double newJariJari) {
        return (4.0 / 3.0) * Math.PI * Math.pow(newJariJari, 3);
    }

    public double hitungLuasPermukaan(double newJariJari) {
        return 4 * Math.PI * Math.pow(newJariJari, 2);
    }

    public void prosesHitungVolumeDanLuasPermukaan() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Apakah ingin mengubah nilai jari-jari bola? (Y/N): ");
        String jawab = inp.nextLine();

        if (jawab.equalsIgnoreCase("Y")) {
            try {
                System.out.print("Masukkan jari-jari baru: ");
                double newJariJari = inp.nextDouble();
                if (newJariJari <= 0) {
                    throw new IllegalArgumentException("❌ Jari-jari harus lebih dari nol.");
                }
                volume = hitungVolume(newJariJari);
                luasPermukaan = hitungLuasPermukaan(newJariJari);
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("❌ Input jari-jari harus berupa angka.");
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