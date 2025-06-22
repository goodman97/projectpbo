package datar;

import geometri.BangunDatar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Persegi extends BangunDatar implements Runnable {
    protected double sisi;
    protected double luas;
    protected double keliling;

    public Persegi(double sisi) {
        this.sisi = sisi;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    @Override
    public String getNama() {
        return "Persegi";
    }

    @Override
    public double hitungLuas() {
        luas = sisi * sisi;
        return luas;
    }
    
    public double hitungLuas(double sisiBaru) {
        this.sisi = sisiBaru; 
        return sisiBaru * sisiBaru;
    }

    public double hitungKeliling(double sisiBaru) {
        this.sisi = sisiBaru;
        return 4 * sisiBaru;
    }

    @Override
    public double hitungKeliling() {
        keliling = 4 * sisi;
        return keliling;
    }

    public double hitungLuas(double sisiBaru) {
        this.sisi = sisiBaru;
        return sisiBaru * sisiBaru;
    }

    public double hitungKeliling(double sisiBaru) {
        this.sisi = sisiBaru;
        return 4 * sisiBaru;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai sisi persegi? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan sisi baru: ");
                        double newSisi = inp.nextDouble();
                        inp.nextLine();
                        if (newSisi <= 0) {
                            System.out.println("Sisi harus lebih dari nol.\n");
                            continue;
                        }
                        sisi = newSisi;
                        luas = hitungLuas(newSisi);
                        keliling = hitungKeliling(newSisi);
                        System.out.printf("\nLuas Persegi: %.2f\n", luas);
                        System.out.printf("Keliling Persegi: %.2f\n", keliling);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid. Silakan masukkan angka yang benar.\n");
                        inp.nextLine();
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                luas = hitungLuas();
                keliling = hitungKeliling();
                break;
            } else {
                System.out.println("Jawaban hanya boleh Y atau N.\n");
            }
        }
    }

    public double getLuas() {
        return luas;
    }

    public double getKeliling() {
        return keliling;
    }

    public double getSisi() {
        return sisi;
    }

    public void setSisi(double sisi) {
        this.sisi = sisi;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("--- Thread [%s] sedang memproses objek Persegi ---\n", threadName);
        try {
            System.out.printf("[%s] Menghitung properti Persegi (sisi: %.2f)...\n", threadName, this.sisi);
            Thread.sleep(1500);
            double luasDihitung = this.hitungLuas();
            double kelilingDihitung = this.hitungKeliling();
            System.out.printf("[%s] Hasil Persegi -> Luas: %.2f, Keliling: %.2f\n", threadName, luasDihitung, kelilingDihitung);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("Thread [%s] diinterupsi.\n", threadName);
        }
        System.out.printf("Thread [%s] selesai.\n", threadName);
    }
}
