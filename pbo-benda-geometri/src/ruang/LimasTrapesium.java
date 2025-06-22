package ruang;

import datar.Trapesium;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LimasTrapesium extends Trapesium {
    protected double tinggiLimas;
    protected double volume;
    protected double luasPermukaan;

    // Konstruktor untuk inisialisasi limas trapesium
    public LimasTrapesium(double atas, double bawah, double tinggiAlas, double tinggiLimas) {
        super(atas, bawah, tinggiAlas);
        this.tinggiLimas = tinggiLimas;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    // Implementasi metode getNama dari BangunDatar
    @Override
    public String getNama() {
        return "Limas Trapesium";
    }

    // Menghitung volume limas
    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.luas * tinggiLimas;
        return volume;
    }

    // Metode overloaded untuk menghitung volume dengan nilai baru
    public double hitungVolume(double atasBaru, double bawahBaru, double tinggiAlasBaru, double tinggiLimasBaru) {
        this.atas = atasBaru;
        this.bawah = bawahBaru;
        this.tinggi = tinggiAlasBaru;
        this.tinggiLimas = tinggiLimasBaru;
        this.sisiMiring = Math.sqrt(Math.pow((bawahBaru - atasBaru) / 2.0, 2) + Math.pow(tinggiAlasBaru, 2));
        this.luas = super.hitungLuas(atasBaru, bawahBaru, tinggiAlasBaru);
        this.keliling = super.hitungKeliling(atasBaru, bawahBaru);
        return (1.0 / 3.0) * this.luas * tinggiLimasBaru;
    }

    // Menghitung luas permukaan limas
    public double hitungLuasPermukaan() {
        // Tinggi miring untuk sisi dengan alas atas dan bawah
        double slantHeightAtasBawah = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow((bawah - atas) / 2.0, 2));
        // Tinggi miring untuk sisi dengan alas sisiMiring
        double slantHeightSisiMiring = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(tinggi / 2.0, 2));
        // Luas dua sisi tegak dengan alas atas dan bawah
        double luasSisiAtasBawah = 0.5 * (atas + bawah) * slantHeightAtasBawah * 2;
        // Luas dua sisi tegak dengan alas sisiMiring
        double luasSisiMiring = 0.5 * (sisiMiring + sisiMiring) * slantHeightSisiMiring * 2;
        luasPermukaan = super.luas + luasSisiAtasBawah + luasSisiMiring;
        return luasPermukaan;
    }

    // Metode overloaded untuk menghitung luas permukaan dengan nilai baru
    public double hitungLuasPermukaan(double atasBaru, double bawahBaru, double tinggiAlasBaru, double tinggiLimasBaru) {
        this.atas = atasBaru;
        this.bawah = bawahBaru;
        this.tinggi = tinggiAlasBaru;
        this.tinggiLimas = tinggiLimasBaru;
        this.sisiMiring = Math.sqrt(Math.pow((bawahBaru - atasBaru) / 2.0, 2) + Math.pow(tinggiAlasBaru, 2));
        this.luas = super.hitungLuas(atasBaru, bawahBaru, tinggiAlasBaru);
        this.keliling = super.hitungKeliling(atasBaru, bawahBaru);
        // Tinggi miring untuk sisi dengan alas atas dan bawah
        double slantHeightAtasBawah = Math.sqrt(Math.pow(tinggiLimasBaru, 2) + Math.pow((bawahBaru - atasBaru) / 2.0, 2));
        // Tinggi miring untuk sisi dengan alas sisiMiring
        double slantHeightSisiMiring = Math.sqrt(Math.pow(tinggiLimasBaru, 2) + Math.pow(tinggiAlasBaru / 2.0, 2));
        // Luas dua sisi tegak dengan alas atas dan bawah
        double luasSisiAtasBawah = 0.5 * (atasBaru + bawahBaru) * slantHeightAtasBawah * 2;
        // Luas dua sisi tegak dengan alas sisiMiring
        double luasSisiMiring = 0.5 * (sisiMiring + sisiMiring) * slantHeightSisiMiring * 2;
        return this.luas + luasSisiAtasBawah + luasSisiMiring;
    }

    // Memproses input pengguna dengan validasi
    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.printf("\nNilai alas atas saat ini adalah %.2f, alas bawah %.2f, tinggi alas %.2f, dan tinggi limas %.2f. Apakah ingin mengubah nilai? (Y/N): ", 
                              super.atas, super.bawah, super.tinggi, this.tinggiLimas);
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan Alas Atas Baru: ");
                        double atasBaru = inp.nextDouble();
                        System.out.print("Masukkan Alas Bawah Baru: ");
                        double bawahBaru = inp.nextDouble();
                        System.out.print("Masukkan Tinggi Alas Baru: ");
                        double tinggiAlasBaru = inp.nextDouble();
                        System.out.print("Masukkan Tinggi Limas Baru: ");
                        double tinggiLimasBaru = inp.nextDouble();
                        inp.nextLine();

                        // Validasi input
                        if (atasBaru <= 0 || bawahBaru <= 0 || tinggiAlasBaru <= 0 || tinggiLimasBaru <= 0) {
                            System.out.println("Nilai harus lebih dari nol.\n");
                            continue;
                        }

                        // Update nilai
                        this.atas = atasBaru;
                        this.bawah = bawahBaru;
                        this.tinggi = tinggiAlasBaru;
                        this.tinggiLimas = tinggiLimasBaru;
                        this.sisiMiring = Math.sqrt(Math.pow((bawahBaru - atasBaru) / 2.0, 2) + Math.pow(tinggiAlasBaru, 2));
                        this.luas = super.hitungLuas(atasBaru, bawahBaru, tinggiAlasBaru);
                        this.keliling = super.hitungKeliling(atasBaru, bawahBaru);
                        this.volume = hitungVolume(atasBaru, bawahBaru, tinggiAlasBaru, tinggiLimasBaru);
                        this.luasPermukaan = hitungLuasPermukaan(atasBaru, bawahBaru, tinggiAlasBaru, tinggiLimasBaru);

                        System.out.printf("\nLuas Alas Trapesium: %.2f\n", this.luas);
                        System.out.printf("Keliling Alas Trapesium: %.2f\n", this.keliling);
                        System.out.printf("Volume Limas Trapesium: %.2f\n", this.volume);
                        System.out.printf("Luas Permukaan Limas Trapesium: %.2f\n", this.luasPermukaan);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid. Silakan masukkan angka yang benar.\n");
                        inp.nextLine();
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                this.volume = hitungVolume();
                this.luasPermukaan = hitungLuasPermukaan();
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan masukkan Y atau N.\n");
            }
        }
    }

    // Getter
    public double getTinggiLimas() {
        return tinggiLimas;
    }

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }

    public double getAtas() {
        return atas;
    }

    public double getBawah() {
        return bawah;
    }

    public double getTinggi() {
        return tinggi;
    }

    public double getSisiMiring() {
        return sisiMiring;
    }

    public double getLuas() {
        return luas;
    }

    public double getKeliling() {
        return keliling;
    }
}
