package ruang;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JuringBola extends Bola {
    private double sudut; // dalam derajat
    private double volumeJuring;
    private double luasPermukaanJuring;

    public JuringBola(double jariJari, double sudut) {
        super(jariJari);
        this.sudut = sudut;
        this.volumeJuring = hitungVolume();
        this.luasPermukaanJuring = hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Juring Bola";
    }

    @Override
    protected double hitungVolume() {
        volumeJuring = (sudut / 360.0) * ((4.0 / 3.0) * Math.PI * Math.pow(jariJari, 3));
        return volumeJuring;
    }

    protected double hitungVolume(double newJariJari, double sudutBaru) {
        return (sudutBaru / 360.0) * ((4.0 / 3.0) * Math.PI * Math.pow(newJariJari, 3));
    }

    @Override
    protected double hitungLuasPermukaan() {
        double luasPenampang = Math.PI * Math.pow(jariJari, 2);
        luasPermukaanJuring = (sudut / 360.0) * (4 * Math.PI * Math.pow(jariJari, 2)) + luasPenampang;
        return luasPermukaanJuring;
    }

    protected double hitungLuasPermukaan(double newJariJari, double sudutBaru) {
        return (sudutBaru / 360.0) * (4 * Math.PI * Math.pow(newJariJari, 2)) + (Math.PI * Math.pow(newJariJari, 2));
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.printf("\nNilai jari-jari saat ini adalah %.2f. Apakah ingin mengubah nilai jari-jari? (Y/N): ", jariJari);
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan Jari-jari Baru: ");
                        double newJariJari = inp.nextDouble();
                        System.out.print("Masukkan Sudut Baru (derajat): ");
                        double newSudut = inp.nextDouble();
                        inp.nextLine();

                        if (newJariJari <= 0 || newSudut <= 0) {
                            System.out.println("Jari-jari dan sudut harus lebih dari nol.\n");
                            continue;
                        }

                        this.jariJari = newJariJari;
                        this.sudut = newSudut;
                        this.volumeJuring = hitungVolume(newJariJari, newSudut);
                        this.luasPermukaanJuring = hitungLuasPermukaan(newJariJari, newSudut);

                        System.out.printf("\nVolume Juring Bola: %.2f\n", volumeJuring);
                        System.out.printf("Luas Permukaan Juring Bola: %.2f\n", luasPermukaanJuring);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid. Silakan masukkan angka.");
                        inp.nextLine();
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                while (true) {
                    try {
                        System.out.print("Masukkan Sudut (derajat): ");
                        double newSudut = inp.nextDouble();
                        inp.nextLine();
                        if (newSudut <= 0) {
                            System.out.println("Sudut harus lebih dari nol.\n");
                            continue;
                        }

                        this.sudut = newSudut;
                        this.volumeJuring = hitungVolume();
                        this.luasPermukaanJuring = hitungLuasPermukaan();

                        System.out.printf("\nVolume Juring Bola: %.2f\n", volumeJuring);
                        System.out.printf("Luas Permukaan Juring Bola: %.2f\n", luasPermukaanJuring);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid. Silakan masukkan angka.");
                        inp.nextLine();
                    }
                }
                break;
            } else {
                System.out.println("Jawaban hanya boleh Y atau N.\n");
            }
        }
    }

    // Getter
    public double getSudut() {
        return sudut;
    }

    public double getVolumeJuring() {
        return volumeJuring;
    }

    public double getLuasPermukaanJuring() {
        return luasPermukaanJuring;
    }
}
