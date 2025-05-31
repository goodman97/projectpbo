package benda.ruang;

import benda.datar.Lingkaran;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Kerucut extends Lingkaran{
    protected double tinggiKerucut;
    protected double volume;
    protected double luasPermukaan;

    public Kerucut(double jariJari, double tinggi) {
        super(jariJari);
        this.tinggiKerucut = tinggiKerucut;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Kerucut";
    }

    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.hitungLuas() * tinggiKerucut;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double s = Math.sqrt(Math.pow(jariJari, 2) + Math.pow(tinggiKerucut, 2));
        luasPermukaan = Math.PI * jariJari * (jariJari + s);
        return luasPermukaan;
    }

    public double hitungVolume(double newJarijari){
        volume = (1.0 / 3.0) * Math.PI * Math.pow(newJarijari, 2) * tinggiKerucut;
        return volume;
    }

    public double hitungLuasPermukaan(double newJarijari){
        double s = Math.sqrt(Math.pow(newJarijari, 2) + Math.pow(tinggiKerucut, 2));
        luasPermukaan = Math.PI * newJarijari * (newJarijari + s);
        return luasPermukaan;
    }
    
    public void ProsesPerhitungan() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Apakah ingin mengubah nilai jari-jari Kerucut? (Y/N): ");
        String jawab = inp.nextLine();

        if (jawab.equalsIgnoreCase("Y")) {
            try {
                System.out.print("Masukkan jari-jari baru: ");
                double newJarijari = inp.nextDouble();
                if (newJarijari <= 0) {
                    throw new IllegalArgumentException("Jari-jari harus lebih dari nol.");
                }

                System.out.print("Masukkan panjang tali busur baru: ");
                double tinggiKerucut = inp.nextDouble();
                if (tinggiKerucut <= 0) {
                    throw new IllegalArgumentException("Tali busur harus lebih dari nol.");
                }

                volume = hitungVolume(newJarijari);
                luasPermukaan = hitungLuasPermukaan(newJarijari);

                System.out.println("Volume Kerucut: " + volume);
                System.out.println("volume Permukaan Kerucut: " + luasPermukaan);

            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("Input harus berupa angka.");
            }
        } else if (jawab.equalsIgnoreCase("N")) {
            try {

                System.out.print("Masukkan panjang tinggi kerucut: ");
                double tinggiKerucut = inp.nextDouble();
                if (tinggiKerucut <= 0) {
                    throw new IllegalArgumentException("tinggi kerucut harus lebih dari nol.");
                }
                volume = hitungVolume();
                luasPermukaan = hitungLuasPermukaan();

                System.out.println("volume Kerucut: " + volume);
                System.out.println("luasPermukaan Kerucut: " + luasPermukaan);

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
