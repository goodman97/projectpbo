package benda.ruang;

import benda.datar.Segitiga;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LimasSegitiga extends Segitiga{
    private double tinggiLimas;
    private Double newAlas = null;
    private Double newTinggiSegitiga = null;
    private double volume;
    private double luasPermukaan;
    private Thread thread;
    private String namaProses;

    public LimasSegitiga(double alas, double tinggiSegitiga, double tinggiLimas) {
        super(alas, tinggiSegitiga);
        this.tinggiLimas = tinggiLimas;
        this.namaProses = "Perhitungan limas segitiga";
    }

    @Override
    public String getNama() {
        return "Limas Segitiga";
    }
    
    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.luas * tinggiLimas;
        return volume;
    }

    public double hitungVolume(double newAlas, double newTinggiSegitiga, double tinggiLimas) {
        volume = (1.0 / 3.0) * (0.5 * newAlas * newTinggiSegitiga) * tinggiLimas;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double tinggiSegitigaTegak = Math.sqrt(Math.pow(alas / 2, 2) + Math.pow(tinggiLimas, 2));
        double luasSegitigaTegak = 0.5 * alas * tinggiSegitigaTegak;
        luasPermukaan = super.luas + 3 * luasSegitigaTegak;
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newAlas, double newTinggiSegitiga, double tinggiLimas) {
        double tinggiSegitigaTegak = Math.sqrt(Math.pow(newAlas / 2, 2) + Math.pow(tinggiLimas, 2));
        double luasTegak = 0.5 * newAlas * tinggiSegitigaTegak;
        double luasAlas = 0.5 * newAlas * newTinggiSegitiga;
        luasPermukaan = luasAlas + 3 * luasTegak;
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("Apakah ingin mengubah nilai alas dan tinggi segitiga? (Y/N): ");
            String jawab = inp.nextLine();
            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan alas baru: ");
                        double newAlas = inp.nextDouble();
                        inp.nextLine();
                        if (newAlas <= 0) {
                            System.out.println("Alas harus lebih dari nol.\n");
                            continue;
                        }
                        System.out.print("Masukkan tinggi segitiga baru: ");
                        double newTinggiSegitiga = inp.nextDouble();
                        inp.nextLine();
                        if (newTinggiSegitiga <= 0) {
                            System.out.println("Tinggi segitiga harus lebih dari nol.\n");
                            continue;
                        }
                        System.out.print("Masukkan tinggi limas: ");
                        double inputTinggiLimas = inp.nextDouble();
                        inp.nextLine();
                        if (inputTinggiLimas <= 0) {
                            System.out.println("Tinggi limas harus lebih dari nol.\n");
                            continue;
                        }
                        this.newAlas = newAlas;
                        this.newTinggiSegitiga = newTinggiSegitiga;
                        this.tinggiLimas = inputTinggiLimas;
                        this.volume = hitungVolume(newAlas, newTinggiSegitiga, tinggiLimas);
                        this.luasPermukaan = hitungLuasPermukaan(newAlas, newTinggiSegitiga, tinggiLimas);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka.");
                        inp.nextLine();
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                while (true) {
                    try {
                        System.out.print("Masukkan tinggi limas: ");
                        double inputTinggiLimas = inp.nextDouble();
                        inp.nextLine();
                        if (inputTinggiLimas <= 0) {
                            System.out.println("Tinggi limas harus lebih dari nol.\n");
                            continue;
                        }
                        this.tinggiLimas = inputTinggiLimas;
                        this.volume = hitungVolume();
                        this.luasPermukaan = hitungLuasPermukaan();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka.");
                        inp.nextLine();
                    }
                }
                break;
            } else {
                System.out.println("Jawaban hanya boleh Y atau N.\n");
            }
        }
    }
    
    public double getNewAlas(){
        return newAlas;
    }
    
    public double getNewTinggiSegitiga(){
        return newTinggiSegitiga;
    }
    
    public double getTinggiLimas(){
        return tinggiLimas;
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
        
        if (newAlas != null && newTinggiSegitiga != null){
            this.volume = hitungVolume(newAlas, newTinggiSegitiga, tinggiLimas);
            this.luasPermukaan = hitungLuasPermukaan(newAlas, newTinggiSegitiga, tinggiLimas);
            System.out.printf("Volmue limas segitiga: %.2f\n", volume);
            System.out.printf("Luas permukaan limas segitiga: %.2f\n", luasPermukaan);
        }else{
            this.volume = hitungVolume();
            this.luasPermukaan = hitungLuasPermukaan();
            System.out.printf("Volmue limas segitiga: %.2f\n", volume);
            System.out.printf("Luas permukaan limas segitiga: %.2f\n", luasPermukaan);
        }

        System.out.println("Thread " + namaProses + " selesai.\n");
        thread = null;
    }

    public Thread getThread() {
        return thread;
    }
}