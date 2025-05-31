package benda.datar;

import benda.geometri.BangunDatar;
import java.util.*;

public class PersegiPanjang extends BangunDatar{
    protected double panjang;
    protected double lebar;
    protected double luas;
    protected double keliling;

    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    @Override
    public String getNama() {
        return "Persegi Panjang";
    }

    @Override
    public double hitungLuas() {
        luas =  panjang * lebar;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        keliling = 2 * (panjang + lebar);
        return keliling;
    }

    public void prosesInputDanValidasi() {
    Scanner inp = new Scanner(System.in);
    
    // Input Panjang
    while (true) {
        try {
            System.out.print("Masukkan Panjang : ");
            double panjang = inp.nextDouble();
            inp.nextLine(); // consume newline
            
            if (panjang <= 0) {
                System.out.println("Panjang harus lebih dari nol.\n");
                continue;
            }
            
            this.panjang = panjang;
            break;
        } catch (InputMismatchException e) {
            System.out.println("Input panjang harus berupa angka.\n");
            inp.nextLine(); // clear invalid input
        }
    }
    
    // Input Lebar
    while (true) {
        try {
            System.out.print("Masukkan Lebar : ");
            double lebar = inp.nextDouble();
            inp.nextLine(); // consume newline
            
            if (lebar <= 0) {
                System.out.println("Lebar harus lebih dari nol.\n");
                continue;
            }
            
            this.lebar = lebar;
            break;
        } catch (InputMismatchException e) {
            System.out.println("Input lebar harus berupa angka.\n");
            inp.nextLine(); // clear invalid input
        }
    }
    
    // Hitung luas dan keliling setelah kedua input valid
    this.luas = hitungLuas();
    this.keliling = hitungKeliling();
}

    public double getLuas(){
        return luas;
    }

    public double getKeliling(){
        return keliling;
    }

    public double getPanjang(){
        return panjang;
    }

    public double getLebar(){
        return lebar;
    }
}
