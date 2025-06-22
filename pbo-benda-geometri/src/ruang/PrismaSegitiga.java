package ruang;

import datar.Segitiga;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrismaSegitiga extends Segitiga{
    private double tinggiPrisma;
    private Double newAlas = null;
    private Double newTinggiSegitiga = null;
    private double volume;
    private double luasPermukaan;

    public PrismaSegitiga(double alas, double tinggiSegitiga, double tinggiPrisma) {
        super(alas, tinggiSegitiga);
        this.tinggiPrisma = tinggiPrisma;
    }
   
    @Override
    public String getNama() {
        return "Prisma Segitiga";
    }

    public double hitungVolume() {
        volume = super.luas * tinggiPrisma;
        return  volume;
    }

    public double hitungVolume(double newAlas, double newTinggiSegitiga, double tinggiPrisma) {
        volume = super.hitungLuas(newAlas, newTinggiSegitiga) * tinggiPrisma;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double sisiMiring = Math.sqrt(Math.pow(alas / 2, 2) + Math.pow(tinggiPrisma, 2));
        luasPermukaan = 2 * super.luas + 2 * sisiMiring * tinggiPrisma;
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newAlas, double newTinggiSegitiga, double tinggiPrisma) {
        double sisiMiring = Math.sqrt(Math.pow(newAlas / 2, 2) + Math.pow(tinggiPrisma, 2));
        luasPermukaan = 2 * super.hitungLuas(newAlas, newTinggiSegitiga) + 2 * sisiMiring * tinggiPrisma;
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
                        double inputTinggiPrisma = inp.nextDouble();
                        inp.nextLine();
                        if (inputTinggiPrisma <= 0) {
                            System.out.println("Tinggi prisma harus lebih dari nol.\n");
                            continue;
                        }
                        this.tinggiPrisma = inputTinggiPrisma;
                        this.newAlas = newAlas;
                        this.newTinggiSegitiga = newTinggiSegitiga;
                        this.volume = hitungVolume(newAlas, newTinggiSegitiga, tinggiPrisma);
                        this.luasPermukaan = hitungLuasPermukaan(newAlas, newTinggiSegitiga, tinggiPrisma);
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
                        double inputTtinggiPrisma = inp.nextDouble();
                        inp.nextLine();
                        if (inputTtinggiPrisma <= 0) {
                            System.out.println("Tinggi prisma harus lebih dari nol.\n");
                            continue;
                        }
                        this.tinggiPrisma = inputTtinggiPrisma;
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
    
    public double getTinggiPrisma(){
        return tinggiPrisma;
    }
}
