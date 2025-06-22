package datar;

import geometri.BangunDatar;
import java.util.*;

public class PersegiPanjang extends BangunDatar implements Runnable{
    protected double panjang;
    protected double lebar;
    protected double luas;
    protected double keliling;
    private Thread thread;
    private String namaProses;

    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
        this.namaProses = "Perhitungan Persegi Panjang";
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

    public double hitungLuas(double panjangBaru, double lebarBaru) {
        luas = panjangBaru * lebarBaru;
        return luas;
    }
    
    public double hitungKeliling(double panjangBaru,double lebarBaru){
        keliling = 2 * (panjangBaru + lebarBaru);
        return keliling;
    }

    public void prosesInputDanValidasi() {
    Scanner inp = new Scanner(System.in);
    
    while (true) {
        try {
            System.out.print("Masukkan Panjang : ");
            double panjang = inp.nextDouble();
            inp.nextLine(); // consume newline
            
            if (panjang <= 0) {
                System.out.println("Panjang harus lebih dari nol.\n");
                continue;
            }

            System.out.print("Masukkan Lebar : ");
            double lebar = inp.nextDouble();
            inp.nextLine(); 
            
            if (lebar <= 0) {
                System.out.println("Lebar harus lebih dari nol.\n");
                continue;
            }
            this.lebar = lebar;
            this.panjang = panjang;
             this.luas = hitungLuas();
             this.keliling = hitungKeliling();
            break;
        } catch (InputMismatchException e) {
            System.out.println("Input panjang harus berupa angka.\n");
            inp.nextLine(); 
        }
    }

   
    }

    public double getPanjang(){
        return panjang;
    }

    public double getLebar(){
        return lebar;
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
        System.out.printf("Luas trapesium: %.2f\n", hitungLuas());
        System.out.printf("Keliling trapesium: %.2f\n", hitungKeliling());
        System.out.println("Thread " + namaProses + " selesai.\n");
        thread = null; 
    }

    public Thread getThread() {
    return thread;
}
}
