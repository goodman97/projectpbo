package benda.datar;

import benda.geometri.BangunDatar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Trapesium extends BangunDatar implements Runnable {
    protected double atas;
    protected double bawah;
    protected double tinggi;
    protected double sisiMiring;
    protected double luas;
    protected double keliling;
    private Thread thread;
    private String namaProses;

    // Konstruktor alternatif: sisi miring dihitung otomatis
    public Trapesium(double atas, double bawah, double tinggi) {
        this.atas = atas;
        this.bawah = bawah;
        this.tinggi = tinggi;
        this.sisiMiring = Math.sqrt(Math.pow((bawah - atas) / 2.0, 2) + Math.pow(tinggi, 2));
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
        this.namaProses = "Perhitungan Trapesium";
    }

    @Override
    public String getNama() {
        return "Trapesium";
    }

    public double hitungLuas() {
        return (atas + bawah) / 2 * tinggi;
    }

    public double hitungKeliling() {
        return atas + bawah + (2 * sisiMiring);
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Masukkan sisi atas: ");
                double atas = inp.nextDouble();

                System.out.print("Masukkan sisi bawah: ");
                double bawah = inp.nextDouble();

                System.out.print("Masukkan tinggi: ");
                double tinggi = inp.nextDouble();

                // Validasi
                if (atas <= 0 || bawah <= 0 || tinggi <= 0) {
                    System.out.println("Semua nilai harus lebih dari nol.\n");
                    continue;
                }

                if (atas == bawah) {
                    System.out.println("Sisi atas dan bawah tidak boleh sama (bukan trapesium).\n");
                    continue;
                }

                // Hitung sisi miring otomatis
                double sisiMiring = Math.sqrt(Math.pow((bawah - atas) / 2.0, 2) + Math.pow(tinggi, 2));

                // Set nilai
                this.atas = atas;
                this.bawah = bawah;
                this.tinggi = tinggi;
                this.sisiMiring = sisiMiring;
                this.luas = hitungLuas();
                this.keliling = hitungKeliling();

                break; // keluar jika semua valid
            } catch (InputMismatchException e) {
                System.out.println("Semua input harus berupa angka desimal.\n");
                inp.nextLine(); // bersihkan buffer
            }
        }
    }

    // Getter
    public double getAtas() {
        return atas;
    }

    public double getBawah() {
        return bawah;
    }

    public double getTinggi() {
        return tinggi;
    }

    public double getSisiMiring() {
        return sisiMiring;
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
        System.out.printf("Luas trapesium: %.2f\n", hitungLuas());
        System.out.printf("Keliling trapesium: %.2f\n", hitungKeliling());
        System.out.println("Thread " + namaProses + " selesai.\n");
        thread = null; // Reset thread after completion
    }
  
}
