package ruang;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TemberengBola extends Bola {
    private double tinggi;
    private double volumeTembereng;
    private double luasPermukaanTembereng;

    public TemberengBola(double jariJari, double tinggi) {
        super(jariJari);
        this.tinggi = tinggi;
        this.volumeTembereng = hitungVolume();
        this.luasPermukaanTembereng = hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Tembereng Bola";
    }

    @Override
    protected double hitungVolume() {
        volumeTembereng = ((Math.PI * Math.pow(tinggi, 2)) / 3) * (3 * jariJari - tinggi);
        return volumeTembereng;
    }

    protected double hitungVolume(double newJariJari, double tinggiBaru) {
        return ((Math.PI * Math.pow(tinggiBaru, 2)) / 3) * (3 * newJariJari - tinggiBaru);
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaanTembereng = 2 * Math.PI * jariJari * tinggi;
        return luasPermukaanTembereng;
    }

    public double hitungLuasPermukaan(double newJariJari, double tinggiBaru) {
        return 2 * Math.PI * newJariJari * tinggiBaru;
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
                        System.out.print("Masukkan Tinggi Tembereng Baru: ");
                        double tinggiBaru = inp.nextDouble();
                        inp.nextLine();

                        if (newJariJari <= 0 || tinggiBaru <= 0) {
                            System.out.println("Nilai harus lebih dari nol.\n");
                            continue;
                        }

                        this.jariJari = newJariJari;
                        this.tinggi = tinggiBaru;
                        this.volumeTembereng = hitungVolume(newJariJari, tinggiBaru);
                        this.luasPermukaanTembereng = hitungLuasPermukaan(newJariJari, tinggiBaru);

                        System.out.printf("\nVolume Tembereng Bola: %.2f\n", volumeTembereng);
                        System.out.printf("Luas Permukaan Tembereng Bola: %.2f\n", luasPermukaanTembereng);
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
                        System.out.print("Masukkan Tinggi Tembereng: ");
                        double tinggiBaru = inp.nextDouble();
                        inp.nextLine();

                        if (tinggiBaru <= 0) {
                            System.out.println("Tinggi harus lebih dari nol.\n");
                            continue;
                        }

                        this.tinggi = tinggiBaru;
                        this.volumeTembereng = hitungVolume();
                        this.luasPermukaanTembereng = hitungLuasPermukaan();

                        System.out.printf("\nVolume Tembereng Bola: %.2f\n", volumeTembereng);
                        System.out.printf("Luas Permukaan Tembereng Bola: %.2f\n", luasPermukaanTembereng);
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
    public double getTinggi() {
        return tinggi;
    }

    public double getVolumeTembereng() {
        return volumeTembereng;
    }

    public double getLuasPermukaanTembereng() {
        return luasPermukaanTembereng;
    }
}
