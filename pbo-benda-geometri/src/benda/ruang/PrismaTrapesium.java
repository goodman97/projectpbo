package benda.ruang;

import benda.datar.Trapesium;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrismaTrapesium extends Trapesium {
    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    public PrismaTrapesium(double atas, double bawah, double tinggiAlas, double tinggiPrisma) {
        super(atas, bawah, tinggiAlas);
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public String getNama() {
        return "Prisma Trapesium";
    }

    public double hitungVolume() {
        volume = super.luas * tinggiPrisma;
        return volume;
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = super.luas + super.keliling * tinggiPrisma;
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Masukkan sisi atas: ");
                double atas = inp.nextDouble();
                inp.nextLine();
                if (atas <= 0) {
                    System.out.println("❌ Sisi atas harus lebih dari nol.\n");
                    continue;
                }
                this.atas = atas;
                break;
            } catch (InputMismatchException e) {
                System.out.println("❌ Input sisi atas harus berupa angka.\n");
                inp.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("Masukkan sisi bawah: ");
                double bawah = inp.nextDouble();
                inp.nextLine();
                if (bawah <= 0) {
                    System.out.println("❌ Sisi bawah harus lebih dari nol.\n");
                    continue;
                }
                this.bawah = bawah;
                break;
            } catch (InputMismatchException e) {
                System.out.println("❌ Input sisi bawah harus berupa angka.\n");
                inp.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("Masukkan tinggi: ");
                double tinggi = inp.nextDouble();
                inp.nextLine();
                if (tinggi <= 0) {
                    System.out.println("❌ Tinggi harus lebih dari nol.\n");
                    continue;
                }
                this.tinggi = tinggi;
                break;
            } catch (InputMismatchException e) {
                System.out.println("❌ Input tinggi harus berupa angka.\n");
                inp.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("Masukkan sisi miring: ");
                double sisiMiring = inp.nextDouble();
                inp.nextLine();
                if (sisiMiring <= 0) {
                    System.out.println("❌ Sisi miring harus lebih dari nol.\n");
                    continue;
                }
                this.sisiMiring = sisiMiring;
                break;
            } catch (InputMismatchException e) {
                System.out.println("❌ Input sisi miring harus berupa angka.\n");
                inp.nextLine();
            }
        }

        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    public double getLuas() {
        return luas;
    }

    public double getKeliling() {
        return keliling;
    }

    public double getAtas() {
        return atas;
    }

    public double getBawah() {
        return bawah;
    }

    public double getTinggi() {
        return tinggi;
    }

    public double getSisiMiring() {
        return sisiMiring;
    }
}
