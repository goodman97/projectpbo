package benda.datar;

import benda.geometri.BangunDatar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BelahKetupat extends BangunDatar implements Runnable {
    protected double diagonal1;
    protected double diagonal2;
    protected double sisi;
    protected double luas;
    protected double keliling;
    private Thread thread;
    private String namaProses;

    public BelahKetupat(double diagonal1, double diagonal2) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisi = Math.sqrt(Math.pow(diagonal1 / 2, 2) + Math.pow(diagonal2 / 2, 2));
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
        this.namaProses = "Perhitungan belah ketupat";
    }

    @Override
    public String getNama() {
        return "Belah Ketupat";
    }
    
    public double hitungLuas() {
        luas = 0.5 * diagonal1 * diagonal2;
        return luas;
    }

    public double hitungKeliling() {
        keliling = sisi * 4;
        return keliling;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Masukkan Diagonal1 : ");
                double d1 = inp.nextDouble();

                if (d1 <= 0 ) {
                    System.out.println("Semua nilai harus lebih dari nol.\n");
                    continue;
                }
                System.out.print("Masukkan Diagonal2 : ");
                double d2 = inp.nextDouble();

                if ( d2 <= 0) {
                    System.out.println("Semua nilai harus lebih dari nol.\n");
                    continue;
                }

                this.diagonal1 = d1;
                this.diagonal2 = d2;
                this.sisi = Math.sqrt(Math.pow(diagonal1 / 2, 2) + Math.pow(diagonal2 / 2, 2));
                this.luas = hitungLuas();
                this.keliling = hitungKeliling();

                break; // input valid
            } catch (InputMismatchException e) {
                System.out.println("Semua input harus berupa angka desimal.\n");
                inp.nextLine(); // bersihkan buffer
            }
        }
    }

    // Getter
    public double getDiagonal1() {
        return diagonal1;
    }

    public double getDiagonal2() {
        return diagonal2;
    }

    public double getSisi() {
        return sisi;
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
        System.out.printf("Luas belah ketupat: %.2f\n", hitungLuas());
        System.out.printf("Keliling belah ketupat: %.2f\n", hitungKeliling());
        System.out.println("Thread " + namaProses + " selesai.\n");
        thread = null; // Reset thread after completion
    }

     public Thread getThread() {
        return thread;
    }
}