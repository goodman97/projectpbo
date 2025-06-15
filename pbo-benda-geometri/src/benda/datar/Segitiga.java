package benda.datar;

import benda.geometri.BangunDatar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Segitiga extends BangunDatar implements Runnable {
    protected double alas;
    protected double tinggiSegitiga;
    protected double luas;
    protected double keliling;
    private Thread thread;
    private String namaProses;

    public Segitiga(double alas, double tinggiSegitiga) {
        this.alas = alas;
        this.tinggiSegitiga = tinggiSegitiga;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
        this.namaProses = "Perhitungan segitiga";
    }

    @Override
    public String getNama() {
        return "Segitiga";
    }

    public double hitungLuas() {
        luas = 0.5 * alas * tinggiSegitiga;
        return luas;
    }

    public double hitungKeliling() {
        double sisiMiring = Math.sqrt(Math.pow(alas / 2, 2) + Math.pow(tinggiSegitiga, 2));
        keliling = alas + 2 * sisiMiring;
        return keliling;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Masukkan alas segitiga: ");
                double inputAlas = inp.nextDouble();
                inp.nextLine();

                if (inputAlas <= 0) {
                    System.out.println("Alas harus lebih dari nol.\n");
                    continue;
                }

                System.out.print("Masukkan tinggi segitiga: ");
                double inputTinggi = inp.nextDouble();
                inp.nextLine();

                if (inputTinggi <= 0) {
                    System.out.println("Tinggi segitiga harus lebih dari nol.\n");
                    continue;
                }

                this.alas = inputAlas;
                this.tinggiSegitiga = inputTinggi;
                this.luas = hitungLuas();
                this.keliling = hitungKeliling();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input alas dan tinggi segitiga harus berupa angka.\n");
                inp.nextLine();
            }
        }
    }

    public double getAlas() {
        return alas;
    }

    public double getTinggiSegitiga() {
        return tinggiSegitiga;
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
        System.out.printf("Luas segitiga: %.2f\n", hitungLuas());
        System.out.printf("Keliling segitiga: %.2f\n", hitungKeliling());
        System.out.println("Thread " + namaProses + " selesai.\n");
        thread = null;
    }

    public Thread getThread() {
        return thread;
    }
}