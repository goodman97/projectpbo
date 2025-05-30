package benda.geometri;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Segitiga extends BangunDatar {
    protected double alas;
    protected double tinggi;
    protected double luas;
    protected double keliling;

    public Segitiga(double alas, double tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    @Override
    public String getNama() {
        return "Segitiga";
    }

    public double hitungLuas() {
        luas =  0.5 * alas * tinggi;
        return luas;
    }

    public double hitungKeliling() {
        double sisiMiring = Math.sqrt(Math.pow(alas / 2, 2) + Math.pow(tinggi, 2));
        keliling = alas + 2 * sisiMiring;
        return keliling;
    }

    public double hitungLuas(double newAlas, double newTinggi) {
        luas =  0.5 * newAlas * newTinggi;
        return luas;
    }

    public double hitungKeliling(double newAlas, double newTinggi) {
        double sisiMiring = Math.sqrt(Math.pow(newAlas / 2, 2) + Math.pow(newTinggi, 2));
        keliling = newAlas + 2 * sisiMiring;
        return keliling;
    }

    public void prosesHitungLuasDanKeliling() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Apakah ingin mengubah nilai alas dan tinggi segitiga? (Y/N): ");
        String jawab = inp.nextLine();

        if (jawab.equalsIgnoreCase("Y")) {
            try {
                System.out.print("Masukkan alas baru: ");
                double newAlas = inp.nextDouble();
                if (newAlas <= 0) {
                    throw new IllegalArgumentException("❌ Alas harus lebih dari nol.");
                }
                System.out.print("Masukkan tinggi baru: ");
                double newTinggi = inp.nextDouble();
                if (newTinggi <= 0) {
                    throw new IllegalArgumentException("❌ Tinggi harus lebih dari nol.");
                }
                luas = hitungLuas(newAlas, newTinggi);
                keliling = hitungKeliling(newAlas, newTinggi);
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("❌ Input alas dan tinggi harus berupa angka.");
            }
        } else if (jawab.equalsIgnoreCase("N")) {
            luas = hitungLuas();
            keliling = hitungKeliling();
        } else {
            throw new IllegalArgumentException("❌ Jawaban hanya boleh Y atau N.");
        }
    }

    public double getLuas(){
        return luas;
    }

    public double getKeliling(){
        return keliling;
    }
}