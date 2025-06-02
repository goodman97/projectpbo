package benda.ruang;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TemberengBola extends Bola {
    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public TemberengBola(double jariJari, double tinggi) {
        super(jariJari);
        this.tinggi = tinggi;
    }

    @Override
    public String getNama() {
        return "Tembereng Bola";
    }

    @Override
    protected double hitungVolume() {
        volume = ((Math.PI * Math.pow(tinggi, 2))/3 * (3 * super.jariJari - tinggi));
        return volume;    
    }

    // overload
    protected double hitungVolume(double newJariJari, double tinggi) {
        volume = ((Math.PI * Math.pow(tinggi, 2))/3) * (3 * newJariJari - tinggi);
        return volume;    
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaan = super.keliling * tinggi; // luas permukaan tanpa alas
        return luasPermukaan; 
    }

    // Overload
    public double hitungLuasPermukaan(double newJariJari, double tinggi) {
        luasPermukaan = 2 * Math.PI * newJariJari * tinggi; // luas permukaan tanpa alas
        return luasPermukaan; 
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("Nilai jari-jari Bola saat ini adalah " + super.jariJari + ". Apakah ingin mengubah nilai jari-jari? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan jari-jari baru: ");
                        double newJariJari = inp.nextDouble();
                        inp.nextLine();
                        System.out.print("Masukkan tinggi tembereng: ");
                        tinggi = inp.nextDouble();
                        inp.nextLine();
                        if (newJariJari <= 0 || tinggi <= 0) {
                            System.out.println("Jari-jari dan tinggi tembereng harus lebih dari nol.\n");
                            continue;
                        }
                        super.jariJari = newJariJari;
                        this.tinggi = tinggi;
                        this.volume = hitungVolume(newJariJari, tinggi);
                        this.luasPermukaan = hitungLuasPermukaan(newJariJari, tinggi);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input jari-jari harus berupa angka.");
                        inp.nextLine();
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                System.out.print("Masukkan tinggi tembereng bola: ");
                this.tinggi = inp.nextDouble();
                this.volume = hitungVolume();
                this.luasPermukaan = hitungLuasPermukaan();
                break;
            } else {
                System.out.println("Jawaban hanya boleh Y atau N.\n");
            }
        }
    }

    @Override
    public double getVolume() {
        return volume;
    }

    @Override
    public double getLuasPermukaan() {
        return luasPermukaan;
    }
}
