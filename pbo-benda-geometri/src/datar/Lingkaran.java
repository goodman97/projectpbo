package datar;

import geometri.BangunDatar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lingkaran extends BangunDatar {
    protected double jariJari;
    protected double luas;
    protected double keliling;

    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    @Override
    public String getNama() {
        return "Lingkaran";
    }

    @Override
    public double hitungLuas() {
        this.luas = Math.PI * Math.pow(jariJari, 2);
        return luas;
    }

    public double hitungLuas(double newJariJari) {
        return Math.PI * Math.pow(newJariJari, 2);
    }

    @Override
    public double hitungKeliling() {
        this.keliling = 2 * Math.PI * jariJari;
        return keliling;
    }

    public double hitungKeliling(double newJariJari) {
        return 2 * Math.PI * newJariJari;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai jari-jari lingkaran? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan Jari-jari Baru: ");
                        double newJariJari = inp.nextDouble();
                        inp.nextLine();

                        if (newJariJari <= 0) {
                            System.out.println("Jari-jari harus lebih dari nol.\n");
                            continue;
                        }

                        this.jariJari = newJariJari;
                        this.luas = hitungLuas(newJariJari);
                        this.keliling = hitungKeliling(newJariJari);
                        System.out.printf("\nLuas Lingkaran: %.2f\n", this.luas);
                        System.out.printf("Keliling Lingkaran: %.2f\n", this.keliling);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid. Silakan masukkan angka.");
                        inp.nextLine();
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan masukkan Y atau N.");
            }
        }
    }

    // Getter
    public double getJariJari() {
        return jariJari;
    }

    public double getLuas() {
        return luas;
    }

    public double getKeliling() {
        return keliling;
    }
}
