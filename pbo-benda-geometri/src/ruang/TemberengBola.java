package ruang;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TemberengBola extends Bola implements Runnable {
    private double tinggi;
    private double volume;
    private double luasPermukaan;
    private Thread thread;
    private String namaProses;

    public TemberengBola(double jariJari, double tinggi, String namaProses) {
        super(jariJari);
        this.tinggi = tinggi;
        this.namaProses = namaProses;
    }

    @Override
    public String getNama() {
        return "Tembereng Bola";
    }

    @Override
    protected double hitungVolume() {
        volume = ((Math.PI * Math.pow(tinggi, 2)) / 3) * (3 * super.jariJari - tinggi);
        return volume;
    }

    protected double hitungVolume(double newJariJari, double tinggi) {
        return ((Math.PI * Math.pow(tinggi, 2)) / 3) * (3 * newJariJari - tinggi);
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaan = 2 * Math.PI * super.jariJari * tinggi;
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newJariJari, double tinggi) {
        return 2 * Math.PI * newJariJari * tinggi;
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
                            System.out.print("Masukkan tinggi tembereng: ");
                            double tinggiBaru = inp.nextDouble();
                            inp.nextLine();

                            if (newJariJari <= 0 || tinggiBaru <= 0) {
                                System.out.println("Jari-jari dan tinggi tembereng harus lebih dari nol.\n");
                                continue;
                            }

                            super.jariJari = newJariJari;
                            this.tinggi = tinggiBaru;
                            this.volume = hitungVolume(newJariJari, tinggiBaru);
                            this.luasPermukaan = hitungLuasPermukaan(newJariJari, tinggiBaru);
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
                            System.out.print("Masukkan tinggi tembereng bola: ");
                            double tinggiBaru = inp.nextDouble();
                            inp.nextLine();

                            if (tinggiBaru <= 0) {
                                System.out.println("Tinggi harus lebih dari nol.\n");
                                continue;
                            }

                            this.tinggi = tinggiBaru;
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

    @Override
    public double getVolume() {
        return volume;
    }

    @Override
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

        System.out.printf("Volume Tembereng Bola: %.2f\n", volume);
        System.out.printf("Luas Permukaan Tembereng Bola: %.2f\n", luasPermukaan);

        System.out.println("Thread " + namaProses + " selesai.\n");
        thread = null;
    }

    public Thread getThread() {
        return thread;
    }
}
