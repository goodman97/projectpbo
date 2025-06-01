package benda.datar;

import benda.geometri.BangunDatar;
import java.util.*;



public class Trapesium extends BangunDatar{
    protected double atas;
    protected double bawah;
    protected double tinggi;
    protected double sisiMiring;
    protected double luas;
    protected double keliling;

    public Trapesium(double atas, double bawah, double tinggi, double sisiMiring) {
        this.atas = atas;
        this.bawah = bawah;
        this.tinggi = tinggi;
        this.sisiMiring = sisiMiring;
    }
    
    @Override
    public String getNama() {
        return "Trapesium";
    }    

    public double hitungLuas() {
        luas = (atas + bawah)/2 * tinggi;
        return luas ;
    }    

    public double hitungKeliling() {
        keliling =  atas + bawah + (2 * sisiMiring);
        return keliling ;
    }    

    public void prosesInputDanValidasi() {
    Scanner inp = new Scanner(System.in);
    
    while (true) {
        try {
            System.out.print("Masukkan sisi atas : ");
            double atas = inp.nextDouble();
            inp.nextLine(); // consume newline
            
            if (atas <= 0) {
                System.out.println("Sisi Atas harus lebih dari nol.\n");
                continue;
            }
            
            this.atas = atas;
            break;
        } catch (InputMismatchException e) {
            System.out.println("Input sisi atas harus berupa angka.\n");
            inp.nextLine(); 
        }
    }
    
    while (true) {
        try {
            System.out.print("Masukkan sisi bawah : ");
            double bawah = inp.nextDouble();
            inp.nextLine(); 
            
            if (bawah <= 0) {
                System.out.println("Sisi bawah harus lebih dari nol.\n");
                continue;
            }
            
            this.bawah = bawah;
            break;
        } catch (InputMismatchException e) {
            System.out.println("Input sisi bawah  harus berupa angka.\n");
            inp.nextLine(); 
        }
    }

    while (true) {
        try {
            System.out.print("Masukkan tinggi : ");
            double tinggi = inp.nextDouble();
            inp.nextLine(); 
            
            if (tinggi <= 0) {
                System.out.println("tinggi harus lebih dari nol.\n");
                continue;
            }
            
            this.tinggi = tinggi;
            break;
        } catch (InputMismatchException e) {
            System.out.println("Input tinggi  harus berupa angka.\n");
            inp.nextLine(); 
        }
    }

     while (true) {
        try {
            System.out.print("Masukkan sisi miring : ");
            double sisiMiring = inp.nextDouble();
            inp.nextLine(); 
            
            if (sisiMiring <= 0) {
                System.out.println("Sisi miring harus lebih dari nol.\n");
                continue;
            }
            
            this.sisiMiring = sisiMiring;
            break;
        } catch (InputMismatchException e) {
            System.out.println("Input sisi miring  harus berupa angka.\n");
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

    public double getAtas(){
        return atas;
    }

    public double getBawah(){
        return bawah;
    }

    public double getTinggi(){
        return tinggi;
    }

    public double getSisiMiring(){
        return sisiMiring;
    }
}