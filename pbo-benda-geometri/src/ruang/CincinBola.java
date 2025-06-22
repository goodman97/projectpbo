package ruang;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CincinBola extends Bola {
    private double jariJariDalam;
    private double volumeCincin;
    private double luasPermukaanCincin;

    public CincinBola(double jariJariLuar, double jariJariDalam) {
        super(jariJariLuar);
        if (jariJariDalam <= 0 || jariJariDalam >= jariJariLuar) {
            throw new IllegalArgumentException("Jari-jari dalam harus lebih dari 0 dan lebih kecil dari jari-jari luar.");
        }
        this.jariJariDalam = jariJariDalam;
        this.volumeCincin = hitungVolume();
        this.luasPermukaanCincin = hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Cincin Bola";
    }

    @Override
    public double hitungVolume() {
        volumeCincin = (4.0 / 3.0) * Math.PI * (Math.pow(jariJari, 3) - Math.pow(jariJariDalam, 3));
        return volumeCincin;
    }

    public double hitungVolume(double jariLuar, double jariDalam) {
        return (4.0 / 3.0) * Math.PI * (Math.pow(jariLuar, 3) - Math.pow(jariDalam, 3));
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaanCincin = 4 * Math.PI * (Math.pow(jariJari, 2) - Math.pow(jariJariDalam, 2));
        return luasPermukaanCincin;
    }

    public double hitungLuasPermukaan(double jariLuar, double jariDalam) {
        return 4 * Math.PI * (Math.pow(jariLuar, 2) - Math.pow(jariDalam, 2));
    }

    public void prosesInputDanValidasi() {
        try (Scanner inp = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.print("Masukkan jari-jari luar bola: ");
                    double jariLuar = inp.nextDouble();
                    System.out.print("Masukkan jari-jari dalam bola: ");
                    double jariDalam = inp.nextDouble();
                    inp.nextLine();

                    if (jariLuar <= 0 || jariDalam <= 0) {
                        System.out.println("Nilai jari-jari harus lebih dari 0.\n");
                        continue;
                    }
                    if (jariDalam >= jariLuar) {
                        System.out.println("Jari-jari dalam harus lebih kecil dari jari-jari luar.\n");
                        continue;
                    }

                    this.jariJari = jariLuar;
                    this.jariJariDalam = jariDalam;
                    this.volumeCincin = hitungVolume(jariLuar, jariDalam);
                    this.luasPermukaanCincin = hitungLuasPermukaan(jariLuar, jariDalam);

                    System.out.printf("\nVolume Cincin Bola: %.2f\n", volumeCincin);
                    System.out.printf("Luas Permukaan Cincin Bola: %.2f\n", luasPermukaanCincin);
                    break;

                } catch (InputMismatchException e) {
                    System.out.println("Input tidak valid. Silakan masukkan angka.\n");
                    inp.nextLine(); // clear buffer
                }
            }
        }
    }

    // Getter
    public double getVolumeCincin() {
        return volumeCincin;
    }

    public double getLuasPermukaanCincin() {
        return luasPermukaanCincin;
    }

    public double getJariJariDalam() {
        return jariJariDalam;
    }
}
