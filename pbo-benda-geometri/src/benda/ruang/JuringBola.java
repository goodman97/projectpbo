package benda.ruang;

import java.util.*;

public class JuringBola extends Bola {
    private double sudut; // dalam derajat
    private double volume;
    private double luasPermukaan;

    // Konstruktor tanpa langsung menghitung volume & luasPermukaan
    public JuringBola(double jariJari, double sudut) {
        super(jariJari);
        this.sudut = sudut;
    }

    @Override
    public String getNama() {
        return "Juring Bola";
    }

    @Override
    protected double hitungVolume() {
        volume = (sudut / 360.0) * ((4.0/3.0) * Math.PI * Math.pow(super.jariJari, 3));
        return volume;
    }

    // Overload untuk jari-jari & sudut baru
    protected double hitungVolume(double newJariJari, double sudut) {
        double volumeBola = (4.0 / 3.0) * Math.PI * Math.pow(newJariJari, 3);
        volume = (sudut / 360.0) * volumeBola;
        return volume;
    }

    @Override
    protected double hitungLuasPermukaan() {
        luasPermukaan = (sudut / 360.0) * super.luasPermukaan + super.luas;
        return luasPermukaan;
    }

    // Overload untuk jari-jari & sudut baru
    protected double hitungLuasPermukaan(double newJariJari, double sudut) {
        luasPermukaan = ((sudut / 360.0) * 4 * Math.PI * Math.pow(newJariJari, 2))   + (Math.PI * Math.pow(newJariJari, 2));
        return luasPermukaan;
    }

    // Proses input dengan validasi aman
    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("Nilai jari-jari Bola saat ini adalah " + super.jariJari 
                             + ". Apakah ingin mengubah nilai jari-jari? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan jari-jari baru: ");
                        double newJariJari = inp.nextDouble();
                        System.out.print("Masukkan besar sudut pusat: ");
                        double sudut = inp.nextDouble();
                        inp.nextLine(); // Buang newline

                        if (newJariJari <= 0 || sudut <= 0) {
                            System.out.println("Jari-jari dan sudut pusat harus lebih dari nol.\n");
                            continue;
                        }

                        super.jariJari = newJariJari;
                        this.sudut = sudut;
                        super.volume = super.hitungVolume(newJariJari); // Update volume bola
                        super.luasPermukaan = super.hitungLuasPermukaan(newJariJari); // Update luas bola
                        this.volume = hitungVolume(newJariJari, sudut);
                        this.luasPermukaan = hitungLuasPermukaan(newJariJari, sudut);
                        break;

                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka.\n");
                        inp.nextLine(); // Buang input salah
                    }
                }
                break;

            } else if (jawab.equalsIgnoreCase("N")) {
                while (true) {
                    try {
                        System.out.print("Masukkan besar sudut pusat: ");
                        sudut = inp.nextDouble();
                        inp.nextLine();
                        if (sudut <= 0) {
                            System.out.println("Sudut pusat harus lebih dari nol.\n");
                            continue;
                        }
                        this.sudut = sudut;
                        this.volume = hitungVolume();
                        this.luasPermukaan = hitungLuasPermukaan();
                        break;

                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka.\n");
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