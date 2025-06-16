package benda.ruang;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CincinBola extends Bola implements Runnable {
    private double jariJariDalam;
    private double volume;
    private double luasPermukaan;
    private Thread thread;
    private String namaProses;

    public CincinBola(double jariJariLuar, double jariJariDalam) {
        super(jariJariLuar);
        if (jariJariDalam <= 0 || jariJariDalam >= jariJariLuar) {
            throw new IllegalArgumentException("Jari-jari dalam harus lebih dari 0 dan lebih kecil dari jari-jari luar.");
        }
        this.jariJariDalam = jariJariDalam;
        this.namaProses = "Perhitungan Cincin Bola";
    }

    @Override
    public String getNama() {
        return "Cincin Bola";
    }

    @Override
    public double hitungVolume() {
        volume = (4.0 / 3.0) * Math.PI * 
                (Math.pow(jariJari, 3) - Math.pow(jariJariDalam, 3));
        return volume;
    }

    // Overload
    public double hitungVolume(double newJariJariLuar, double newJariJariDalam) {
        volume = (4.0 / 3.0) * Math.PI * 
                (Math.pow(newJariJariLuar, 3) - Math.pow(newJariJariDalam, 3));
        return volume;
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaan = 4 * Math.PI * 
                (Math.pow(jariJari, 2) - Math.pow(jariJariDalam, 2));
        return luasPermukaan;
    }

    // Overload
    public double hitungLuasPermukaan(double newJariJariLuar, double newJariJariDalam) {
        luasPermukaan = 4 * Math.PI * 
                (Math.pow(newJariJariLuar, 2) - Math.pow(newJariJariDalam, 2));
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Masukkan jari-jari luar bola: ");
                double newJariJariLuar = inp.nextDouble();
                System.out.print("Masukkan jari-jari dalam bola: ");
                double newJariJariDalam = inp.nextDouble();
                inp.nextLine();

                if (newJariJariLuar <= 0 || newJariJariDalam <= 0) {
                    System.out.println("Nilai jari-jari harus lebih dari 0.\n");
                    continue;
                }
                if (newJariJariDalam >= newJariJariLuar) {
                    System.out.println("Jari-jari dalam harus lebih kecil dari jari-jari luar.\n");
                    continue;
                }

                super.jariJari = newJariJariLuar;
                this.jariJariDalam = newJariJariDalam;
                this.volume = hitungVolume(newJariJariLuar, newJariJariDalam);
                this.luasPermukaan = hitungLuasPermukaan(newJariJariLuar, newJariJariDalam);
                break;

            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka.\n");
                inp.nextLine();
            }
        }
    }

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }

    public void startCalculationThread() {
        if (thread == null) {
            thread = new Thread(this, namaProses);
            thread.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread " + namaProses + " mulai...");
        System.out.println("Hitung: " + getNama());
        System.out.printf("Volume Cincin Bola: %.2f\n", hitungVolume());
        System.out.printf("Luas Permukaan Cincin Bola: %.2f\n", hitungLuasPermukaan());
        System.out.println("Thread " + namaProses + " selesai.\n");
        thread = null;
    }

    public Thread getThread() {
        return thread;
    }

    public double getJariJariDalam() {
        return jariJariDalam;
    }
}
