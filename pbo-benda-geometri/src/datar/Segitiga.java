package datar;

import geometri.BangunDatar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Segitiga extends BangunDatar{
    protected double alas;
    protected double tinggiSegitiga;
    protected double luas;
    protected double keliling;

    public Segitiga(double alas, double tinggiSegitiga) {
        this.alas = alas;
        this.tinggiSegitiga = tinggiSegitiga;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
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
    
    public double hitungLuas(double newAlas, double newTinggiSegitiga) {
        luas = 0.5 * newAlas * newTinggiSegitiga;
        return luas;
    }

    public double hitungKeliling(double newAlas, double newTinggiSegitiga) {
        double sisiMiring = Math.sqrt(Math.pow(newAlas / 2, 2) + Math.pow(newTinggiSegitiga, 2));
        keliling = newAlas + 2 * sisiMiring;
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
}