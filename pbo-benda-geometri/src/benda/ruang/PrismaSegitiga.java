package benda.geometri;

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

    public void prosesVolumeDanLuasPermukaan() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Apakah ingin mengubah nilai alas dan tinggi segitiga? (Y/N): ");
        String jawab = inp.nextLine();

        if (jawab.equalsIgnoreCase("Y")) {
            try {
                System.out.print("Masukkan alas baru: ");
                double newAlas = inp.nextDouble();
                if (newAlas <= 0) {
                    throw new IllegalArgumentException("❌ Alas harus lebih dari nol.");
                }
                System.out.print("Masukkan tinggi baru: ");
                double newTinggiSegitiga = inp.nextDouble();
                if (newTinggiSegitiga <= 0) {
                    throw new IllegalArgumentException("❌ Tinggi segitiga harus lebih dari nol.");
                }
                volume = hitungVolume(newAlas, newTinggiSegitiga);
                luasPermukaan = hitungLuasPermukaan(newAlas, newTinggiSegitiga);
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("❌ Input alas dan tinggi segitiga harus berupa angka.");
            }
        } else if (jawab.equalsIgnoreCase("N")) {
            volume = hitungVolume();
            luasPermukaan = hitungLuasPermukaan();
        } else {
            throw new IllegalArgumentException("❌ Jawaban hanya boleh Y atau N.");
        }
    }

    public double getVolume(){
        return volume;
    }

    public double getLuasPermukaan(){
        return luasPermukaan;
    }
}
