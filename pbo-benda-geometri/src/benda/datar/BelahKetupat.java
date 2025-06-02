package benda.datar;

import benda.geometri.BangunDatar;
import java.util.*;


public class BelahKetupat extends BangunDatar{
    protected double diagonal1;
    protected double diagonal2;
    protected double sisi;
    protected double luas;
    protected double keliling;
    
    public BelahKetupat(double diagonal1, double diagonal2, double sisi) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisi = sisi;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
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
                double diagonal1 = inp.nextDouble();
                inp.nextLine();
                System.out.print("Masukkan diagonal2 : ");
                double diagonal2 = inp.nextDouble();
                System.out.print("Masukkan sisi : ");
                double sisi = inp.nextDouble();
                inp.nextLine(); 
                inp.nextLine(); 
                if (diagonal1 <= 0) {
                    System.out.println("Diagonal1 harus lebih dari nol.\n");
                    continue;
                }            
                this.diagonal1 = diagonal1;
                this.diagonal2 = diagonal2;
                this.sisi = sisi;
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input Diagonal1 harus berupa angka.\n");
                inp.nextLine(); 
            }
        }
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    public double getLuas(){
        return luas;
    }

    public double getKeliling(){
        return keliling;
    }

    public double getDiagonal1(){
        return diagonal1;
    }

    public double getDiagonal2(){
        return diagonal2;
    }

    public double getSisi(){
        return sisi;
    }
}