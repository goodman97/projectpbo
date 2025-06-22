package ruang;

import datar.PersegiPanjang;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrismaPersegiPanjang extends PersegiPanjang {
    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;
    private Thread thread;
    private String namaProses;

    public PrismaPersegiPanjang(double panjang, double lebar, double tinggiPrisma) {
        super(panjang, lebar);
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
        this.namaProses = "Perhitungan prisma persegi panjang";
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

    public double hitungVolume(double newPanjang, double newLebar, double newTinggiPrisma) {
        volume = newPanjang * newLebar * newTinggiPrisma;
        return volume;
    }

    public double hitungLuasPermukaan(double newPanjang, double newLebar, double newTinggiPrisma) {
        luasPermukaan = 2 * newPanjang * newLebar + 2 * (newPanjang + newLebar) * newTinggiPrisma;
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("Apakah ingin mengubah nilai panjang, lebar, dan tinggi prisma persegi panjang? (Y/N): ");
            String jawab = inp.nextLine();
            if (!jawab.equalsIgnoreCase("Y") && !jawab.equalsIgnoreCase("N")) {
                System.out.println("❌ Jawaban hanya boleh Y atau N.");
                continue;
            }
            if (jawab.equalsIgnoreCase("N")) {
                System.out.println("Masukkan tinggi Prisma");
                double inputTinggiPrisma = inp.nextDouble();
                if(inputTinggiPrisma<=0){
                    System.out.println("Tingggi prisma harus lebih dari 0\n");
                    continue;
                }
                
                this.tinggiPrisma = inputTinggiPrisma;
                //super.luas = super.hitungLuas();
                this.volume = hitungVolume();
                this.luasPermukaan = hitungLuasPermukaan();
                break;
            }
            try {
                System.out.print("Masukkan panjang baru: ");
                double newPanjang = inp.nextDouble();
                if (newPanjang <= 0) {
                    System.out.println("❌ Panjang harus lebih dari nol.");
                    continue;
                }
                System.out.print("Masukkan lebar baru: ");
                double newLebar = inp.nextDouble();
                if (newLebar <= 0) {
                    System.out.println("❌ Lebar harus lebih dari nol.");
                    continue;
                }
                System.out.print("Masukkan tinggi prisma baru: ");
                double newTinggiPrisma = inp.nextDouble();
                if (newTinggiPrisma <= 0) {
                    System.out.println("❌ Tinggi prisma harus lebih dari nol.");
                    continue;
                }
                this.panjang = newPanjang;
                this.lebar = newLebar;
                this.tinggiPrisma = newTinggiPrisma;
                super.luas = panjang * lebar;
                volume = hitungVolume(newPanjang, newLebar, newTinggiPrisma);
                luasPermukaan = hitungLuasPermukaan(newPanjang, newLebar, newTinggiPrisma);
                break;
            } catch (InputMismatchException e) {
                System.out.println("❌ Input harus berupa angka.");
                inp.nextLine(); // Clear buffer
            }
        }
    }

}
