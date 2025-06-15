package benda.ruang;

import benda.datar.PersegiPanjang;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LimasPersegiPanjang extends PersegiPanjang implements Runnable {
    private double tinggiLimas;
    private double volume;
    private double luasPermukaan;
    private Thread thread;
    private String namaProses;

    public LimasPersegiPanjang(double panjang, double lebar, double tinggiLimas) {
        super(panjang, lebar);
        this.tinggiLimas = tinggiLimas;
        this.namaProses = "Perhitungan limas persegi panjang";
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

    public double hitungVolume(double newPanjang, double newLebar, double newTinggiLimas) {
        volume = (1.0 / 3.0) * newPanjang * newLebar * newTinggiLimas;
        return volume; 
    }

    public double hitungLuasPermukaan(double newPanjang, double newLebar, double newTinggiLimas) {
        double luasSegitigaPanjang = 0.5 * newPanjang * Math.sqrt(Math.pow(newLebar / 2, 2) + Math.pow(newTinggiLimas, 2));
        double luasSegitigaLebar = 0.5 * newLebar * Math.sqrt(Math.pow(newPanjang / 2, 2) + Math.pow(newTinggiLimas, 2));
        luasPermukaan = newPanjang * newLebar + 2 * luasSegitigaPanjang + 2 * luasSegitigaLebar;
        return luasPermukaan;
    }   

    public void prosesInputDanValidasi() {
    Scanner inp = new Scanner(System.in);
    while (true) {
        System.out.print("Apakah ingin mengubah nilai panjang, lebar, dan tinggi limas persegi panjang? (Y/N): ");
        String jawab = inp.nextLine();
        if (!jawab.equalsIgnoreCase("Y") && !jawab.equalsIgnoreCase("N")) {
            System.out.println("❌ Jawaban hanya boleh Y atau N.");
            continue;
        }
        if (jawab.equalsIgnoreCase("N")) {
            volume = hitungVolume();
            luasPermukaan = hitungLuasPermukaan();
            break;
        }
        try {
            System.out.print("Masukkan panjang baru: ");
            double newPanjang = inp.nextDouble();
            if (newPanjang <= 0) {
                System.out.println("❌ Panjang harus lebih dari nol.");
                continue;
            }
            System.out.print("Masukkan lebar baru: ");
            double newLebar = inp.nextDouble();
            if (newLebar <= 0) {
                System.out.println("❌ Lebar harus lebih dari nol.");
                continue;
            }
            System.out.print("Masukkan tinggi limas baru: ");
            double newTinggiLimas = inp.nextDouble();
            if (newTinggiLimas <= 0) {
                System.out.println("❌ Tinggi limas harus lebih dari nol.");
                continue;
            }
            this.panjang = newPanjang;
            this.lebar = newLebar;
            this.tinggiLimas = newTinggiLimas;
            super.luas = panjang * lebar;
            volume = hitungVolume(newPanjang, newLebar, newTinggiLimas);
            luasPermukaan = hitungLuasPermukaan(newPanjang, newLebar, newTinggiLimas);
            break;
        } catch (InputMismatchException e) {
            System.out.println("❌ Input harus berupa angka.");
            inp.nextLine(); // Clear buffer
        }
    
    }
    }

    // Thread-related methods
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
        System.out.printf("Volume limas persegi panjang: %.2f\n", volume);
        System.out.printf("Luas permukaan limas persegi panjang: %.2f\n", luasPermukaan);
        System.out.println("Thread " + namaProses + " selesai.\n");
        thread = null; 
    }

    public Thread getThread() {
    return thread;
}
}