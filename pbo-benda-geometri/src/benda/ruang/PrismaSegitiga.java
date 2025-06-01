package benda.ruang;

import benda.datar.Segitiga;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrismaSegitiga extends Segitiga{
    private double tinggiPrisma;
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
        return hitungLuas() * tinggiPrisma;
    }

    public double hitungLuasPermukaan() {
        double sisiMiring = Math.sqrt(Math.pow(alas / 2, 2) + Math.pow(tinggiPrisma, 2));
        return 2 * hitungLuas() + (alas + 2 * sisiMiring) * tinggiPrisma;
    }

    public double hitungVolume(double newAlas, double newTinggiSegitiga) {
        return newAlas * newTinggiSegitiga * tinggiPrisma;
    }

    public double hitungLuasPermukaan(double newAlas, double newTinggiSegitiga) {
        double sisiMiring = Math.sqrt(Math.pow(newAlas / 2, 2) + Math.pow(tinggiPrisma, 2));
        return 2 * (1.0 / 2.0) * newAlas * newTinggiSegitiga + (alas + 2 * sisiMiring) * tinggiPrisma;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai alas dan tinggi segitiga? (Y/N): ");
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

                        super.alas = newAlas;
                        super.tinggiSegitiga = newTinggiSegitiga;
                        this.tinggiPrisma = tinggiPrisma;
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

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
    }
}
