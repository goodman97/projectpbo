package datar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JuringLingkaran extends Lingkaran {
    protected double sudut;
    protected double luasJuring;
    protected double kelilingJuring;
    protected double panjangBusur;

    public JuringLingkaran(double jariJari, double sudut) {
        super(jariJari);
        this.sudut = sudut;
        this.luasJuring = hitungLuas();
        this.kelilingJuring = hitungKeliling();
    }

    @Override
    public String getNama() {
        return "Juring Lingkaran";
    }

    @Override
    public double hitungLuas() {
        luasJuring = (sudut / 360.0) * super.hitungLuas();
        return luasJuring;
    }

    public double hitungLuas(double newJariJari, double newSudut) {
        return (newSudut / 360.0) * Math.PI * Math.pow(newJariJari, 2);
    }

    @Override
    public double hitungKeliling() {
        panjangBusur = (sudut / 360.0) * super.hitungKeliling();
        kelilingJuring = (2 * jariJari) + panjangBusur;
        return kelilingJuring;
    }

    public double hitungKeliling(double newJariJari, double newSudut) {
        double busur = (newSudut / 360.0) * (2 * Math.PI * newJariJari);
        return (2 * newJariJari) + busur;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.printf("\nNilai jari-jari saat ini adalah %.2f dan sudut %.2f derajat. Apakah ingin mengubah nilai? (Y/N): ",
                    super.jariJari, this.sudut);
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan Jari-jari Baru: ");
                        double newJariJari = inp.nextDouble();
                        System.out.print("Masukkan Sudut (derajat): ");
                        double newSudut = inp.nextDouble();
                        inp.nextLine();

                        if (newJariJari <= 0 || newSudut <= 0) {
                            System.out.println("Nilai jari-jari dan sudut harus lebih dari nol.\n");
                            continue;
                        }

                        this.jariJari = newJariJari;
                        this.sudut = newSudut;
                        this.luasJuring = hitungLuas(newJariJari, newSudut);
                        this.kelilingJuring = hitungKeliling(newJariJari, newSudut);

                        System.out.printf("\nLuas Juring Lingkaran: %.2f\n", this.luasJuring);
                        System.out.printf("Keliling Juring Lingkaran: %.2f\n", this.kelilingJuring);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid. Silakan masukkan angka.");
                        inp.nextLine();
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                this.luasJuring = hitungLuas();
                this.kelilingJuring = hitungKeliling();
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan masukkan Y atau N.");
            }
        }
    }

    // Getter
    public double getSudut() {
        return sudut;
    }

    public double getLuasJuring() {
        return luasJuring;
    }

    public double getKelilingJuring() {
        return kelilingJuring;
    }

    public double getPanjangBusur() {
        return panjangBusur;
    }
}
