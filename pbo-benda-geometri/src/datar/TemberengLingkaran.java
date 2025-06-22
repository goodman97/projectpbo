package datar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TemberengLingkaran extends JuringLingkaran {
    private double taliBusur;
    private double luasTembereng;
    private double kelilingTembereng;

    public TemberengLingkaran(double jariJari, double sudut) {
        super(jariJari, sudut);
        this.taliBusur = hitungTaliBusur(jariJari, sudut);
        this.luasTembereng = hitungLuas();
        this.kelilingTembereng = hitungKeliling();
    }

    @Override
    public String getNama() {
        return "Tembereng Lingkaran";
    }

    private double hitungTaliBusur(double jariJari, double sudutDerajat) {
        double sudutRad = Math.toRadians(sudutDerajat);
        return 2 * jariJari * Math.sin(sudutRad / 2.0);
    }

    @Override
    public double hitungLuas() {
        double sudutRad = Math.toRadians(sudut);
        double luasJuring = (sudutRad / 2) * Math.pow(jariJari, 2);
        double luasSegitiga = 0.5 * Math.pow(jariJari, 2) * Math.sin(sudutRad);
        luasTembereng = luasJuring - luasSegitiga;
        return luasTembereng;
    }

    public double hitungLuas(double jariJariBaru, double sudutBaru) {
        double sudutRad = Math.toRadians(sudutBaru);
        double luasJuring = (sudutRad / 2) * Math.pow(jariJariBaru, 2);
        double luasSegitiga = 0.5 * Math.pow(jariJariBaru, 2) * Math.sin(sudutRad);
        return luasJuring - luasSegitiga;
    }

    @Override
    public double hitungKeliling() {
        double sudutRad = Math.toRadians(sudut);
        double panjangBusur = sudutRad * jariJari;
        kelilingTembereng = panjangBusur + taliBusur;
        return kelilingTembereng;
    }

    public double hitungKeliling(double jariJariBaru, double sudutBaru) {
        double sudutRad = Math.toRadians(sudutBaru);
        double panjangBusur = sudutRad * jariJariBaru;
        double taliBaru = hitungTaliBusur(jariJariBaru, sudutBaru);
        return panjangBusur + taliBaru;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.printf("\nNilai jari-jari saat ini: %.2f, sudut: %.2f. Apakah ingin mengubah nilai? (Y/N): ",
                    jariJari, sudut);
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan Jari-jari Baru: ");
                        double newJariJari = inp.nextDouble();
                        System.out.print("Masukkan Sudut Baru (dalam derajat): ");
                        double newSudut = inp.nextDouble();
                        inp.nextLine();

                        if (newJariJari <= 0 || newSudut <= 0) {
                            System.out.println("Jari-jari dan sudut harus lebih dari nol.\n");
                            continue;
                        }

                        this.jariJari = newJariJari;
                        this.sudut = newSudut;
                        this.taliBusur = hitungTaliBusur(newJariJari, newSudut);
                        this.luasTembereng = hitungLuas(newJariJari, newSudut);
                        this.kelilingTembereng = hitungKeliling(newJariJari, newSudut);

                        System.out.printf("\nLuas Tembereng Lingkaran: %.2f\n", this.luasTembereng);
                        System.out.printf("Keliling Tembereng Lingkaran: %.2f\n", this.kelilingTembereng);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid. Silakan masukkan angka.");
                        inp.nextLine();
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                this.taliBusur = hitungTaliBusur(jariJari, sudut);
                this.luasTembereng = hitungLuas();
                this.kelilingTembereng = hitungKeliling();
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan masukkan Y atau N.");
            }
        }
    }

    // Getter
    public double getTaliBusur() {
        return taliBusur;
    }

    public double getLuasTembereng() {
        return luasTembereng;
    }

    public double getKelilingTembereng() {
        return kelilingTembereng;
    }
}
