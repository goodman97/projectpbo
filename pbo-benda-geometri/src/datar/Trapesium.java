package datar;

import geometri.BangunDatar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Trapesium extends BangunDatar {
    protected double atas;
    protected double bawah;
    protected double tinggi;
    protected double sisiMiring;
    protected double luas;
    protected double keliling;

    // Konstruktor alternatif: sisi miring dihitung otomatis
    public Trapesium(double atas, double bawah, double tinggi) {
        this.atas = atas;
        this.bawah = bawah;
        this.tinggi = tinggi;
        this.sisiMiring = Math.sqrt(Math.pow((bawah - atas) / 2.0, 2) + Math.pow(tinggi, 2));
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    @Override
    public String getNama() {
        return "Trapesium";
    }

    public double hitungLuas() {
        this.luas =(atas + bawah) / 2 * tinggi;
        return luas;
    }

    public double hitungKeliling() {
        this.keliling = atas + bawah + (2 * sisiMiring);
        return keliling;
    }
    
     public double hitungLuas(double newAtas, double newBawah, double newTinggi ) {
        luas =(newAtas + newBawah) / 2 * newTinggi;
        return luas;
    }
     
     public double hitungKeliling(double newAtas, double newBawah) {
        keliling = newAtas + newBawah + (2 * sisiMiring);
        return keliling;
    }

    public void prosesInputDanValidasi() {
        java.util.Scanner inp = new java.util.Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai alas atas, alas bawah, dan tinggi trapesium? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan Alas Atas Baru: ");
                        double newAtas = inp.nextDouble();
                        System.out.print("Masukkan Alas Bawah Baru: ");
                        double newBawah = inp.nextDouble();
                        System.out.print("Masukkan Tinggi Baru: ");
                        double newTinggi = inp.nextDouble();
                        inp.nextLine();
                        if (newAtas <= 0 || newBawah <= 0 || newTinggi <= 0) {
                            System.out.println("Nilai harus lebih dari nol.\n");
                            continue;
                        }
                        atas = newAtas;
                        bawah = newBawah;
                        tinggi = newTinggi;
                        sisiMiring = Math.sqrt(Math.pow((newBawah - newAtas) / 2.0, 2) + Math.pow(newTinggi, 2));
                        
                        luas = hitungLuas(newAtas, newBawah, newTinggi);
                        keliling = hitungKeliling(newAtas, newBawah);
                        System.out.printf("\nLuas Trapesium: %.2f\n", luas);
                        System.out.printf("Keliling Trapesium: %.2f\n", keliling);
                        break; // keluar dari loop input
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid. Silakan masukkan angka yang benar.");
                        inp.nextLine(); // bersihkan input yang salah
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                break; // keluar dari loop jika tidak ingin mengubah nilai
            } else {
                System.out.println("Pilihan tidak valid. Silakan masukkan Y atau N.");
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
}
