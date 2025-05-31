package benda.ruang;

import benda.datar.Lingkaran;
import java.util.*;

public class Bola extends Lingkaran {
    protected double volume;
    protected double luasPermukaan;

    public Bola(double jariJari) {
        super(jariJari);
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Bola";
    }

    public double hitungVolume() {
        volume = (4.0 / 3.0) * super.luas * super.jariJari;
        return volume;
    }

    public double hitungVolume(double newJariJari) {
        volume = (4.0 / 3.0) * Math.PI * Math.pow(newJariJari, 3);
        return volume;
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = 4 * super.luas;
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newJariJari) {
        luasPermukaan = 4 * Math.PI * Math.pow(newJariJari, 2);
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai jari-jari bola? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan jari-jari baru: ");
                        double newJariJari = inp.nextDouble();
                        inp.nextLine();
                        if (newJariJari <= 0) {
                            System.out.println("Jari-jari harus lebih dari nol.\n");
                            continue;
                        }
                        super.jariJari = newJariJari;
                        super.luas = super.hitungLuas();
                        this.volume = hitungVolume(newJariJari);
                        this.luasPermukaan = hitungLuasPermukaan(newJariJari);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input jari-jari harus berupa angka.");
                        inp.nextLine();
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                this.volume = hitungVolume();
                this.luasPermukaan = hitungLuasPermukaan();
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