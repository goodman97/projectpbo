package benda.ruang;

import benda.datar.Segitiga;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrismaSegitiga extends Segitiga{
    private double tinggiPrisma;
    private Double newAlas = null;
    private Double newTinggiSegitiga = null;
    private double volume;
    private double luasPermukaan;
    private Thread thread;
    private String namaProses;

    public PrismaSegitiga(double alas, double tinggiSegitiga, double tinggiPrisma) {
        super(alas, tinggiSegitiga);
        this.tinggiPrisma = tinggiPrisma;
        this.namaProses = "Perhitungan prisma segitiga";
    }
   
    @Override
    public String getNama() {
        return "Prisma Segitiga";
    }

    public double hitungVolume() {
        volume = super.luas * tinggiPrisma;
        return  volume;
    }

    public double hitungVolume(double newAlas, double newTinggiSegitiga) {
        volume = newAlas * newTinggiSegitiga * tinggiPrisma;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double sisiMiring = Math.sqrt(Math.pow(alas / 2, 2) + Math.pow(tinggiPrisma, 2));
        luasPermukaan = 2 * super.luas + 2 * sisiMiring * tinggiPrisma;
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newAlas, double newTinggiSegitiga) {
        double sisiMiring = Math.sqrt(Math.pow(newAlas / 2, 2) + Math.pow(tinggiPrisma, 2));
        luasPermukaan = 2 * (0.5 * newAlas * newTinggiSegitiga) + 2 * sisiMiring * tinggiPrisma;
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

                        System.out.print("Masukkan tinggi prisma: ");
                        this.tinggiPrisma = inp.nextDouble();
                        inp.nextLine();
                        if (tinggiPrisma <= 0) {
                            System.out.println("Tinggi prisma harus lebih dari nol.\n");
                            continue;
                        }
                        this.tinggiPrisma = tinggiPrisma;
                        this.newAlas = newAlas;
                        this.newTinggiSegitiga = newTinggiSegitiga;
                        super.luas = super.hitungLuas();
                        this.volume = hitungVolume(newAlas, newTinggiSegitiga);
                        this.luasPermukaan = hitungLuasPermukaan(newAlas, newTinggiSegitiga);
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
                        System.out.print("Masukkan tinggi prisma: ");
                        this.tinggiPrisma = inp.nextDouble();
                        inp.nextLine();
                        if (tinggiPrisma <= 0) {
                            System.out.println("Tinggi prisma harus lebih dari nol.\n");
                            continue;
                        }
                        this.tinggiPrisma = tinggiPrisma;
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
            this.volume = hitungVolume(newAlas, newTinggiSegitiga);
            this.luasPermukaan = hitungLuasPermukaan(newAlas, newTinggiSegitiga);
            System.out.printf("Volmue prisma segitiga: %.2f\n", volume);
            System.out.printf("Luas permukaan prisma segitiga: %.2f\n", luasPermukaan);
        }else{
            this.volume = hitungVolume();
            this.luasPermukaan = hitungLuasPermukaan();
            System.out.printf("Volmue prisma segitiga: %.2f\n", volume);
            System.out.printf("Luas permukaan prisma segitiga: %.2f\n", luasPermukaan);
        }

        System.out.println("Thread " + namaProses + " selesai.\n");
        thread = null;
    }

    public Thread getThread() {
        return thread;
    }
}
