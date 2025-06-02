package benda.datar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TemberengLingkaran extends JuringLingkaran{
    private double taliBusur;
    protected double luas;
    protected double keliling;

    public TemberengLingkaran(double jariJari, double sudut) {
        super(jariJari, sudut);
        double sudutRad = Math.toRadians(sudut);
        this.taliBusur = 2 * jariJari * Math.sin(sudutRad / 2);
    }

    @Override
    public String getNama() {
        return "Tembereng Lingkaran";
    }

    @Override
    public double hitungLuas() {
        double sudutRad = Math.toRadians(sudut);
        double luasJuring = (sudutRad / 2) * Math.pow(jariJari, 2);
        double luasSegitiga = 0.5 * Math.pow(jariJari, 2) * Math.sin(sudutRad);
        luas = luasJuring - luasSegitiga;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        keliling = super.panjangBusur + taliBusur;
        return keliling;
    }

    // Overload hitungLuas dengan parameter baru
    public double hitungLuas(double newJariJari, double taliBusur) {
        double sudutRad = Math.toRadians(sudut);
        double luasJuring = (sudutRad / 2) * Math.pow(newJariJari, 2);
        double luasSegitiga = 0.5 * Math.pow(newJariJari, 2) * Math.sin(sudutRad);
        return luasJuring - luasSegitiga;
    }

    public double hitungKeliling(double newJariJari, double taliBusur) {
        double sudutRad = Math.toRadians(sudut);
        double panjangBusur = sudutRad * newJariJari;
        return panjangBusur + taliBusur;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Apakah ingin mengubah nilai jari-jari Tembereng Lingkaran? (Y/N): ");
        String jawab = inp.nextLine();

        if (jawab.equalsIgnoreCase("Y")) {
            try {
                System.out.print("Masukkan jari-jari baru: ");
                double newJariJari = inp.nextDouble();
                if (newJariJari <= 0) {
                    throw new IllegalArgumentException("Jari-jari harus lebih dari nol.");
                }

                System.out.print("Masukkan panjang tali busur baru: ");
                double newTaliBusur = inp.nextDouble();
                if (newTaliBusur <= 0) {
                    throw new IllegalArgumentException("Tali busur harus lebih dari nol.");
                }

                luas = hitungLuas(newJariJari, newTaliBusur);
                keliling = hitungKeliling(newJariJari, newTaliBusur);

                System.out.println("Luas Tembereng Lingkaran: " + luas);
                System.out.println("Keliling Tembereng Lingkaran: " + keliling);

            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("Input harus berupa angka.");
            }
        } else if (jawab.equalsIgnoreCase("N")) {
            try {
                luas = hitungLuas();
                keliling = hitungKeliling();

                System.out.println("Luas Tembereng Lingkaran: " + luas);
                System.out.println("Keliling Tembereng Lingkaran: " + keliling);

            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("Input harus berupa angka.");
            }
        } else {
            throw new IllegalArgumentException("Jawaban hanya boleh Y atau N.");
        }
    }

    public double luas() {
        return luas;
    }

    public double keliling() {
        return keliling;
    }
}
