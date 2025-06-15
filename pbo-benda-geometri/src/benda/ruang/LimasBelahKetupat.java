package benda.ruang;

import benda.datar.BelahKetupat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LimasBelahKetupat extends BelahKetupat{
    private double tinggiLimas;
    private double newDiagonal1;
    private double newDiagonal2;
    private double newSisi;
    private double volume;
    private double luasPermukaan;

    public LimasBelahKetupat(double diagonal1, double diagonal2,  double tinggiLimas) {
        super(diagonal1, diagonal2);
        this.tinggiLimas = tinggiLimas;
        this.newSisi = Math.sqrt(Math.pow(newDiagonal1 / 2, 2) + Math.pow(newDiagonal2 / 2, 2));
    }

    @Override
    public String getNama() {
        return "Limas Belah Ketupat";
    }
    
    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.luas * tinggiLimas;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double luasSegitiga = 0.5 * sisi * Math.sqrt(Math.pow(sisi, 2) - Math.pow(diagonal1 / 2, 2));
        luasPermukaan = super.luas + 4 * luasSegitiga;
        return luasPermukaan;
    }

    public double hitungVolume(double newDiagonal1, double newDiagonal2, double newSisi) {
        return  (1.0 / 3.0) * (1.0 / 2.0) * newDiagonal1 * newDiagonal2 * tinggiLimas;
    }

    public double hitungLuasPermukaan(double newDiagonal1, double newDiagonal2, double newSisi) {
        double luasSegitiga = 0.5 * newSisi * Math.sqrt(Math.pow(newSisi, 2) - Math.pow(newDiagonal1 / 2, 2));
        luasPermukaan = (1.0 / 2.0) * newDiagonal1 * newDiagonal2 + 4 * luasSegitiga;
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai diagonal dan sisi belah ketupat? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan diagonal 1 yang baru: ");
                        double newDiagonal1 = inp.nextDouble();
                        inp.nextLine();
                        if (newDiagonal1 <= 0) {
                            System.out.println("Diagonal 1 harus lebih dari nol.\n");
                            continue;
                        }

                        System.out.print("Masukkan diagonal 2 yang baru: ");
                        double newDiagonal2 = inp.nextDouble();
                        inp.nextLine();
                        if (newDiagonal2 <= 0) {
                            System.out.println("Diagonal 2 harus lebih dari nol.\n");
                            continue;
                        }

                        System.out.print("Masukkan sisi yang baru: ");
                        double newSisi = inp.nextDouble();
                        inp.nextLine();
                        if (newSisi <= 0) {
                            System.out.println("Sisi harus lebih dari nol.\n");
                            continue;
                        }
                        
                        this.newSisi = Math.sqrt(Math.pow(newDiagonal1 / 2, 2) + Math.pow(newDiagonal2 / 2, 2));
                        
                        System.out.print("Masukkan tinggi limas: ");
                        this.tinggiLimas = inp.nextDouble();
                        inp.nextLine();
                        if (tinggiLimas <= 0) {
                            System.out.println("Tinggi limas harus lebih dari nol.\n");
                            continue;
                        }

                        super.diagonal1 = newDiagonal1;
                        super.diagonal2 = newDiagonal2;
                        super.sisi = newSisi;
                        this.tinggiLimas = tinggiLimas;
                        super.luas = super.hitungLuas();
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
                        System.out.print("Masukkan tinggi limas: ");
                        this.tinggiLimas = inp.nextDouble();
                        inp.nextLine();
                        if (tinggiLimas <= 0) {
                            System.out.println("Tinggi limas harus lebih dari nol.\n");
                            continue;
                        }

                        this.tinggiLimas = tinggiLimas;
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