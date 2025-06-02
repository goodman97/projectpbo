package benda.datar;

import java.util.InputMismatchException;
import java.util.Scanner;

import benda.geometri.BangunDatar;

public class LayangLayang extends BangunDatar{
    protected double diagonal1;
    protected double diagonal2;
    protected double sisiPanjang;
    protected double sisiPendek;
    protected double luas;
    protected double keliling;

    public LayangLayang(double diagonal1, double diagonal2, double sisiPanjang, double sisiPendek) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisiPanjang = sisiPanjang;
        this.sisiPendek = sisiPendek;
    }

    @Override
    public String getNama() {
        return "Layang-Layang";
    }
    
    @Override
    public double hitungLuas() {
        luas = 0.5 * diagonal1 * diagonal2;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        keliling =  2 * (sisiPanjang + sisiPendek);
        return keliling;
    }
    
    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Masukkan nilai diagonal 1: ");
                double diagonal1 = inp.nextDouble();
                inp.nextLine();
                System.out.print("Masukkan nilai diagonal 2: ");
                double diagonal2 = inp.nextDouble();
                inp.nextLine();
                System.out.print("Masukkan nilai sisi panjang: ");
                double sisiPanjang = inp.nextDouble();
                inp.nextLine();
                System.out.print("Masukkan nilai sisi pendek: ");
                double sisiPendek = inp.nextDouble();
                inp.nextLine();
                if (diagonal1 <= 0 || diagonal2 <= 0 || sisiPanjang <= 0 || sisiPendek <= 0) {
                    System.out.println("Nilai harus lebih dari nol.\n");
                    continue;
                }
                this.diagonal1 = diagonal1;
                this.diagonal2 = diagonal2;
                this.sisiPanjang = sisiPanjang;
                this.sisiPendek = sisiPendek;
                this.luas = hitungLuas();
                this.keliling = hitungKeliling();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input nilai harus berupa angka.\n");
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

    public double getDiagonal1(){
        return diagonal1;
    }
    public double getDiagonal2(){
        return diagonal2;
    }
    public double getSisiPanjang(){
        return sisiPanjang;
    }
    public double getSisiPendek(){
        return sisiPendek;
    }
}