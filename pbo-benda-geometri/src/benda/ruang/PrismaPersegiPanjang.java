package benda.ruang;

import benda.datar.PersegiPanjang;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrismaPersegiPanjang extends PersegiPanjang{
    protected double tinggiPrisma;
    protected double volume;
    protected double luasPermukaan;

    public PrismaPersegiPanjang(double panjang, double lebar, double tinggiPrisma) {
        super(panjang, lebar);
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Prisma Persegi Panjang";
    }

    public double hitungVolume() {
        volume = super.luas * tinggiPrisma;
        return volume;
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = 2 * super.luas + 2 * (panjang + lebar) * tinggiPrisma;
        return luasPermukaan;
    }

    public double hitungVolume(double newPanjang, double newLebar, double newtinggiPrisma) {
        return newPanjang * newLebar * newtinggiPrisma;
    }

    public double hitungLuasPermukaan(double newPanjang, double newLebar, double newtinggiPrisma) {
        return 2 * newPanjang * newLebar + 2 * (newPanjang + newLebar) * newtinggiPrisma;
    }

    
    public void prosesHitungVolumeDanLuasPermukaan() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Apakah ingin mengubah nilai panjang, lebar, dan tinggi prisma persegi panjang? (Y/N): ");
        String jawab = inp.nextLine();

        if (jawab.equalsIgnoreCase("Y")) {
            try {
                 System.out.print("Masukkan panjang  baru: ");
                double newPanjang = inp.nextDouble();
                if (newPanjang <= 0) {
                    throw new IllegalArgumentException("❌ Panjang harus lebih dari nol.");
                }
                System.out.print("Masukkan lebar baru: ");
                double newLebar = inp.nextDouble();
                if (newLebar <= 0) {
                    throw new IllegalArgumentException("❌ lebar harus lebih dari nol.");
                }
                System.out.print("Masukkan tinggi baru: ");
                double newtinggiPrisma = inp.nextDouble();
                if (newtinggiPrisma <= 0) {
                    throw new IllegalArgumentException("❌ Tinggi Prisma harus lebih dari nol.");
                }
                volume = hitungVolume(newPanjang, newLebar, newtinggiPrisma);
                luasPermukaan = hitungLuasPermukaan(newPanjang, newLebar, newtinggiPrisma);
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("❌ Input an harus berupa angka.");
            }
        } else if (jawab.equalsIgnoreCase("N")) {
            volume = hitungVolume();
            luasPermukaan = hitungLuasPermukaan();
        } else {
            throw new IllegalArgumentException("❌ Jawaban hanya boleh Y atau N.");
        }
    }

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }
}