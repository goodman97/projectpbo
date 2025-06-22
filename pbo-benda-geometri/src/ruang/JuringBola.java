package ruang;

import java.util.*;

public class JuringBola extends Bola implements Runnable {
    private double sudut; // dalam derajat
    private double volume;
    private double luasPermukaan;
    private Thread thread;
    private String namaProses;

    public JuringBola(double jariJari, double sudut, String namaProses) {
        super(jariJari);
        this.sudut = sudut;
        this.namaProses = namaProses;
    }

    @Override
    public String getNama() {
        return "Juring Bola";
    }

    @Override
    protected double hitungVolume() {
        volume = (sudut / 360.0) * ((4.0 / 3.0) * Math.PI * Math.pow(super.jariJari, 3));
        return volume;
    }

    protected double hitungVolume(double newJariJari, double sudut) {
        double volumeBola = (4.0 / 3.0) * Math.PI * Math.pow(newJariJari, 3);
        return (sudut / 360.0) * volumeBola;
    }

    @Override
    protected double hitungLuasPermukaan() {
        luasPermukaan = (sudut / 360.0) * super.luasPermukaan + super.luas;
        return luasPermukaan;
    }

    protected double hitungLuasPermukaan(double newJariJari, double sudut) {
        return ((sudut / 360.0) * 4 * Math.PI * Math.pow(newJariJari, 2)) + (Math.PI * Math.pow(newJariJari, 2));
    }

    public void prosesInputDanValidasi() {
        try (Scanner inp = new Scanner(System.in)) {
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
                            double sudutBaru = inp.nextDouble();
                            inp.nextLine(); // Buang newline

                            if (newJariJari <= 0 || sudutBaru <= 0) {
                                System.out.println("Jari-jari dan sudut pusat harus lebih dari nol.\n");
                                continue;
                            }

                            super.jariJari = newJariJari;
                            this.sudut = sudutBaru;
                            super.volume = super.hitungVolume(newJariJari);
                            super.luasPermukaan = super.hitungLuasPermukaan(newJariJari);
                            this.volume = hitungVolume(newJariJari, sudutBaru);
                            this.luasPermukaan = hitungLuasPermukaan(newJariJari, sudutBaru);
                            break;

                        } catch (InputMismatchException e) {
                            System.out.println("Input harus berupa angka.\n");
                            inp.nextLine();
                        }
                    }
                    break;

                } else if (jawab.equalsIgnoreCase("N")) {
                    while (true) {
                        try {
                            System.out.print("Masukkan besar sudut pusat: ");
                            double sudutBaru = inp.nextDouble();
                            inp.nextLine();
                            if (sudutBaru <= 0) {
                                System.out.println("Sudut pusat harus lebih dari nol.\n");
                                continue;
                            }
                            this.sudut = sudutBaru;
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
    }

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }

    public void startCalculationThread() {
        if (thread == null) {
            thread = new Thread(this, namaProses);
            thread.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread " + namaProses + " mulai...");
        System.out.println("Hitung: " + getNama());

        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();

        System.out.printf("Volume Juring Bola: %.2f\n", volume);
        System.out.printf("Luas Permukaan Juring Bola: %.2f\n", luasPermukaan);

        System.out.println("Thread " + namaProses + " selesai.\n");
        thread = null;
    }

    public Thread getThread() {
        return thread;
    }
}
