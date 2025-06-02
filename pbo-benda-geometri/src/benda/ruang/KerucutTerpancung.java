package benda.ruang;

import java.util.InputMismatchException;
import java.util.Scanner;

public class KerucutTerpancung extends Kerucut {
    private double jariJariAtas;
    protected double volume;
    protected double luasPermukaan;

    public KerucutTerpancung(double jariJariBawah, double jariJariAtas, double tinggi) {
        super(jariJariBawah, tinggi);
        this.jariJariAtas = jariJariAtas;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Kerucut Terpancung";
    }

    // Method utama
    @Override
    public double hitungVolume() {
        volume = (1.0 / 3.0) * Math.PI * tinggiKerucut *
                (Math.pow(jariJari, 2) + Math.pow(jariJariAtas, 2) + jariJari * jariJariAtas);
        return volume;
    }

    // Overloading: parameter jari-jari atas baru
    public double hitungVolume(double newJariJariAtas) {
        return (1.0 / 3.0) * Math.PI * tinggiKerucut *
                (Math.pow(jariJari, 2) + Math.pow(newJariJariAtas, 2) + jariJari * newJariJariAtas);
    }

    // Overloading: parameter jari-jari bawah, atas, tinggi baru
    public double hitungVolume(double newJariJariBawah, double newJariJariAtas, double newTinggi) {
        return (1.0 / 3.0) * Math.PI * newTinggi *
                (Math.pow(newJariJariBawah, 2) + Math.pow(newJariJariAtas, 2) + newJariJariBawah * newJariJariAtas);
    }

    @Override
    public double hitungLuasPermukaan() {
        double s = Math.sqrt(Math.pow((jariJari - jariJariAtas), 2) + Math.pow(tinggiKerucut, 2));
        luasPermukaan = Math.PI * (jariJari + jariJariAtas) * s +
                        Math.PI * Math.pow(jariJari, 2) +
                        Math.PI * Math.pow(jariJariAtas, 2);
        return luasPermukaan;
    }

    // Overloading: parameter jari-jari atas baru
    public double hitungLuasPermukaan(double newJariJariAtas) {
        double s = Math.sqrt(Math.pow((jariJari - newJariJariAtas), 2) + Math.pow(tinggiKerucut, 2));
        return Math.PI * (jariJari + newJariJariAtas) * s +
               Math.PI * Math.pow(jariJari, 2) +
               Math.PI * Math.pow(newJariJariAtas, 2);
    }

    // Overloading: parameter jari-jari bawah, atas, tinggi baru
    public double hitungLuasPermukaan(double newJariJariBawah, double newJariJariAtas, double newTinggi) {
        double s = Math.sqrt(Math.pow((newJariJariBawah - newJariJariAtas), 2) + Math.pow(newTinggi, 2));
        return Math.PI * (newJariJariBawah + newJariJariAtas) * s +
               Math.PI * Math.pow(newJariJariBawah, 2) +
               Math.PI * Math.pow(newJariJariAtas, 2);
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Apakah ingin mengubah nilai jari-jari bawah, atas, dan tinggi? (Y/N): ");
        String jawab = inp.nextLine();

        if (jawab.equalsIgnoreCase("Y")) {
            try {
                System.out.print("Masukkan jari-jari bawah baru: ");
                double newJariJariBawah = inp.nextDouble();

                System.out.print("Masukkan jari-jari atas baru: ");
                double newJariJariAtas = inp.nextDouble();

                System.out.print("Masukkan tinggi baru: ");
                double newTinggi = inp.nextDouble();

                if (newJariJariBawah <= 0 || newJariJariAtas <= 0 || newTinggi <= 0) {
                    throw new IllegalArgumentException("Semua nilai harus lebih dari nol.");
                }

                // Pakai method overloading
                volume = hitungVolume(newJariJariBawah, newJariJariAtas, newTinggi);
                luasPermukaan = hitungLuasPermukaan(newJariJariBawah, newJariJariAtas, newTinggi);

                System.out.println("\nHasil Perhitungan:");
                System.out.println("Volume Kerucut Terpancung: " + volume);
                System.out.println("Luas Permukaan Kerucut Terpancung: " + luasPermukaan);

            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("Input harus berupa angka.");
            }

        } else if (jawab.equalsIgnoreCase("N")) {
            try {
                System.out.print("Masukkan jari-jari atas baru: ");
                double newJariJariAtas = inp.nextDouble();

                if (newJariJariAtas <= 0) {
                    throw new IllegalArgumentException("Jari-jari atas harus lebih dari nol.");
                }

                volume = hitungVolume(newJariJariAtas);
                luasPermukaan = hitungLuasPermukaan(newJariJariAtas);

                System.out.println("\nHasil Perhitungan:");
                System.out.println("Volume Kerucut Terpancung: " + volume);
                System.out.println("Luas Permukaan Kerucut Terpancung: " + luasPermukaan);

            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("Input harus berupa angka.");
            }

        } else {
            throw new IllegalArgumentException("Jawaban hanya boleh Y atau N.");
        }
    }

    public double volume() {
        return volume;
    }

    public double luasPermukaan() {
        return luasPermukaan;
    }
}
