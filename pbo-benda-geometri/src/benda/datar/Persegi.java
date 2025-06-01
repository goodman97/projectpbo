package benda.datar;

import benda.geometri.BangunDatar;
import java.util.*;

public class Persegi extends BangunDatar{
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
        keliling =  sisi * sisi;
        return keliling;
    }

    @Override
    public double hitungKeliling() {
        luas = 4 * sisi;
        return luas;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Masukkan sisi persegi: ");
                double sisi = inp.nextDouble();
                inp.nextLine();

                if (sisi <= 0) {
                    System.out.println("sisi harus lebih dari nol.\n");
                    continue;
                }

                this.sisi = sisi;
                this.luas = hitungLuas();
                this.keliling = hitungKeliling();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input sisi harus berupa angka.\n");
                inp.nextLine();
            }
        }
    }

    public double getLuas(){
        return luas;
    }

    public double getKeliling(){
        return keliling;
    }

    public double getSisi(){
        return sisi;
    }
}