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
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Limas Segitiga";
    }
    
    public double hitungVolume() {
        return (1.0 / 3.0) * hitungLuas() * tinggiLimas;
    }

    public double hitungLuasPermukaan() {
        double sisiMiring = Math.sqrt(Math.pow(alas / 2, 2) + Math.pow(tinggiLimas, 2));
        double luasTegak = 0.5 * alas * sisiMiring;
        return hitungLuas() + 3 * luasTegak;
    }

    public double hitungVolume(double newAlas, double newTinggiSegitiga, double tinggiLimas) {
        return  (1.0 / 3.0) * (0.5 * newAlas * newTinggiSegitiga) * tinggiLimas;
    }

    public double hitungLuasPermukaan(double newAlas, double newTinggiSegitiga, double tinggiLimas) {
        double sisiMiring = Math.sqrt(Math.pow(newAlas / 2, 2) + Math.pow(tinggiLimas, 2));
        double luasTegak = 0.5 * newAlas * sisiMiring;
        double luasAlas = 0.5 * newAlas * newTinggiSegitiga;
        return luasAlas + 3 * luasTegak;
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

                        System.out.print("Masukkan tinggi limas: ");
                        double newTinggiLimas = inp.nextDouble();
                        inp.nextLine();
                        if (newTinggiLimas <= 0) {
                            System.out.println("Tinggi limas harus lebih dari nol.\n");
                            continue;
                        }

                        super.alas = newAlas;
                        super.tinggiSegitiga = newTinggiSegitiga;
                        this.tinggiLimas = newTinggiLimas;
                        super.luas = super.hitungLuas();
                        this.volume = hitungVolume(newAlas, newTinggiSegitiga, newTinggiLimas);
                        this.luasPermukaan = hitungLuasPermukaan(newAlas, newTinggiSegitiga, newTinggiLimas);
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
                        double newTinggiLimas = inp.nextDouble();
                        inp.nextLine();
                        if (newTinggiLimas <= 0) {
                            System.out.println("Tinggi limas harus lebih dari nol.\n");
                            continue;
                        }

                        this.tinggiLimas = newTinggiLimas;
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

    public double getTinggiLimas() {
        return tinggiLimas;
    }
}
