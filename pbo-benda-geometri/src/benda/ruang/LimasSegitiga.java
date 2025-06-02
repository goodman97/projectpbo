package benda.ruang;

import benda.datar.Segitiga;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LimasSegitiga extends Segitiga{
    private double tinggiLimas;
    private double volume;
    private double luasPermukaan;

    public LimasSegitiga(double alas, double tinggiSegitiga, double tinggiLimas) {
        super(alas, tinggiSegitiga);
        this.tinggiLimas = tinggiLimas;
    }

    @Override
    public String getNama() {
        return "Limas Segitiga";
    }
    
    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.luas * tinggiLimas;
        return volume;
    }

    public double hitungVolume(double newAlas, double newTinggiSegitiga) {
        volume = (1.0 / 3.0) * (0.5 * newAlas * newTinggiSegitiga) * tinggiLimas;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double tinggiSegitigaTegak = Math.sqrt(Math.pow(alas / 2, 2) + Math.pow(tinggiLimas, 2));
        double luasSegitigaTegak = 0.5 * alas * tinggiSegitigaTegak;
        luasPermukaan = super.luas + 3 * luasSegitigaTegak;
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newAlas, double newTinggiSegitiga) {
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
                        this.tinggiLimas = inp.nextDouble();
                        inp.nextLine();
                        if (tinggiLimas <= 0) {
                            System.out.println("Tinggi limas harus lebih dari nol.\n");
                            continue;
                        }
                        super.alas = newAlas;
                        super.tinggiSegitiga = newTinggiSegitiga;
                        this.tinggiLimas = tinggiLimas;
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

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }
}
