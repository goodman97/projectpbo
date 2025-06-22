package ruang;

import datar.BelahKetupat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrismaBelahKetupat extends BelahKetupat{
    private double tinggiPrisma;
    private Double newDiagonal1 = null;
    private Double newDiagonal2 = null;
    private Double newSisi = null;
    private double volume;
    private double luasPermukaan;

    public PrismaBelahKetupat(double tinggiPrisma, double diagonal1, double diagonal2) {
        super(diagonal1, diagonal2);
        this.tinggiPrisma = tinggiPrisma;
        this.newSisi = Math.sqrt(Math.pow(newDiagonal1 / 2, 2) + Math.pow(newDiagonal2 / 2, 2));
    }
    
    @Override
    public String getNama() {
        return "Prisma Belah Ketupat";
    }

    public double hitungVolume() {
        volume = super.luas * tinggiPrisma;
        return volume; 
    }
    
    public double hitungVolume(double newDiagonal1, double newDiagonal2, double newSisi) {
        volume = super.hitungLuas(newDiagonal1, newDiagonal2) * tinggiPrisma;
        return volume;
    }
    
    public double hitungLuasPermukaan() {
        luasPermukaan = (super.luas*2) + (newSisi * tinggiPrisma) * 4;
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newDiagonal1, double newDiagonal2, double newSisi) {
        luasPermukaan = (super.hitungLuas(newDiagonal1, newDiagonal2) + (newSisi * tinggiPrisma)) * 4;
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai diagonal dan sisi yang baru? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan diagonal 1 yang baru: ");
                        this.newDiagonal1 = inp.nextDouble();
                        inp.nextLine();
                        if (newDiagonal1 <= 0) {
                            System.out.println("Diagonal 1 harus lebih dari nol.\n");
                            continue;
                        }

                        System.out.print("Masukkan diagonal 2 yang baru: ");
                        this.newDiagonal2 = inp.nextDouble();
                        inp.nextLine();
                        if (newDiagonal2 <= 0) {
                            System.out.println("Diagonal 2 harus lebih dari nol.\n");
                            continue;
                        }

                        this.newSisi = Math.sqrt(Math.pow(newDiagonal1 / 2, 2) + Math.pow(newDiagonal2 / 2, 2));

                        System.out.print("Masukkan tinggi prisma: ");
                        this.tinggiPrisma = inp.nextDouble();
                        inp.nextLine();
                        if (tinggiPrisma <= 0) {
                            System.out.println("Tinggi prisma harus lebih dari nol.\n");
                            continue;
                        }

                        super.diagonal1 = newDiagonal1;
                        super.diagonal2 = newDiagonal2;
                        super.sisi = newSisi;
                        this.volume = hitungVolume(newDiagonal1, newDiagonal2, newSisi);
                        this.luasPermukaan = hitungLuasPermukaan(newDiagonal1, newDiagonal2, newSisi);
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
}