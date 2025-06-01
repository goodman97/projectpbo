package main;

import benda.datar.*;
import benda.ruang.*;

public class Main {
    public static void main(String[] args) {
        // Input semua nilai terlebih dahulu
        Lingkaran lingkaran = new Lingkaran(0);
        lingkaran.prosesInputDanValidasi();

        Bola bola = new Bola(lingkaran.getJariJari());
        bola.prosesInputDanValidasi();

        JuringBola juringBola = new JuringBola(bola.getJariJari(), 0);
        juringBola.prosesInputDanValidasi();

        TemberengBola temberengBola = new TemberengBola(bola.getJariJari(), 0);
        temberengBola.prosesInputDanValidasi();

        Segitiga segitiga = new Segitiga(1, 1);
        segitiga.prosesInputDanValidasi();

        LimasSegitiga limasSegitiga = new LimasSegitiga(segitiga.getAlas(), segitiga.getTinggiSegitiga(), 0);
        limasSegitiga.prosesInputDanValidasi();

        LimasPersegi limasPersegi = new LimasPersegi(segitiga.getAlas(), segitiga.getTinggiSegitiga(), 0);
        limasPersegi.prosesInputDanValidasi();

        Persegi persegi = new Persegi (0);
        persegi.prosesInputDanValidasi();

        PersegiPanjang persegiPanjang = new PersegiPanjang(0, 0);
        persegiPanjang.prosesInputDanValidasi();

        LimasPersegiPanjang limasPersegiPanjang = new LimasPersegiPanjang(0, 0, 0);
        limasPersegiPanjang.prosesInputDanValidasi();

        BelahKetupat belahKetupat = new BelahKetupat(0, 0, 0);
        belahKetupat.prosesInputDanValidasi();

        Trapesium trapesium = new Trapesium(0, 0, 0, 0);
        trapesium.prosesInputDanValidasi();


        System.out.println("\n=== Memulai Proses Perhitungan Multithreading ===\n");

        // Proses perhitungan menggunakan thread
        try {
            PerhitunganThread lingkaranThread = new PerhitunganThread(() -> {
                System.out.println("Hitung: " + lingkaran.getNama());
                System.out.printf("Luas Lingkaran: %.2f\n", lingkaran.getLuas());
                System.out.printf("Keliling Lingkaran: %.2f\n", lingkaran.getKeliling());
            }, "Perhitungan Lingkaran");

            PerhitunganThread bolaThread = new PerhitunganThread(() -> {
                System.out.println("Hitung: " + bola.getNama());
                System.out.printf("Volume Bola: %.2f\n", bola.getVolume());
                System.out.printf("Luas Permukaan Bola: %.2f\n", bola.getLuasPermukaan());
            }, "Perhitungan Bola");

            PerhitunganThread juringBolaThread = new PerhitunganThread(() -> {
                System.out.println("Hitung: " + juringBola.getNama());
                System.out.printf("Volume Juring Bola: %.2f\n", juringBola.getVolume());
                System.out.printf("Luas Permukaan Juring Bola: %.2f\n", juringBola.getLuasPermukaan());
            }, "Perhitungan Juring Bola");

            PerhitunganThread temberengBolaThread = new PerhitunganThread(() -> {
                System.out.println("Hitung: " + temberengBola.getNama());
                System.out.printf("Volume Tembereng Bola: %.2f\n", temberengBola.getVolume());
                System.out.printf("Luas Permukaan Tembereng Bola: %.2f\n", temberengBola.getLuasPermukaan());
            }, "Perhitungan Tembereng Bola");

            PerhitunganThread segitigaThread = new PerhitunganThread(() -> {
                System.out.println("Hitung: " + segitiga.getNama());
                System.out.printf("Luas Segitiga: %.2f\n", segitiga.getLuas());
                System.out.printf("Keliling Segitiga: %.2f\n", segitiga.getKeliling());
            }, "Perhitungan Segitiga");

            PerhitunganThread limasSegitigaThread = new PerhitunganThread(() -> {
                System.out.println("Hitung: " + limasSegitiga.getNama());
                System.out.printf("Volume Limas Segitiga: %.2f\n", limasSegitiga.getVolume());
                System.out.printf("Luas Permukaan Limas Segitiga: %.2f\n", limasSegitiga.getLuasPermukaan());
            }, "Perhitungan Limas Segitiga");

            PerhitunganThread persegiThread = new PerhitunganThread(() -> {
                System.out.println("Hitung: " + persegi.getNama());
                System.out.printf("Luas persegi: %.2f\n", persegi.getLuas());
                System.out.printf("Keliling persegi: %.2f\n", persegi.getKeliling());
            }, "Perhitungan persegi");

                PerhitunganThread limasPersegiThread = new PerhitunganThread(() -> {
                System.out.println("Hitung: " + limasPersegi.getNama());
                System.out.printf("Volume Limas Persegi: %.2f\n", limasPersegi.getVolume());
                System.out.printf("Luas Permukaan Limas Persegi: %.2f\n", limasPersegi.getLuasPermukaan());
            }, "Perhitungan Limas Persegi");

            PerhitunganThread persegiPanjangThread = new PerhitunganThread(() -> {
                System.out.println("Hitung: " + persegiPanjang.getNama());
                System.out.printf("Luas persegi panjang: %.2f\n", persegiPanjang.getLuas());
                System.out.printf("Keliling persegi panjang: %.2f\n", persegiPanjang.getKeliling());
            }, "Perhitungan persegi panjang");

            PerhitunganThread limasPersegiPanjangThread = new PerhitunganThread(() -> {
                System.out.println("Hitung: " + limasPersegiPanjang.getNama());
                System.out.printf("Volume limas persegi panjang: %.2f\n", limasPersegiPanjang.getLuas());
                System.out.printf("Luas Permukaan limas persegi panjang: %.2f\n", limasPersegiPanjang.getKeliling());
            }, "Perhitungan limas persegi panjang");

            PerhitunganThread belahKetupatThread = new PerhitunganThread(() -> {
                System.out.println("Hitung: " + belahKetupat.getNama());
                System.out.printf("Luas belah ketupat: %.2f\n", belahKetupat.getLuas());
                System.out.printf("Keliling belah ketupat: %.2f\n", belahKetupat.getKeliling());
            }, "Perhitungan belah ketupat");

            PerhitunganThread trapesiumThread = new PerhitunganThread(() -> {
                System.out.println("Hitung: " + trapesium.getNama());
                System.out.printf("Luas trapesium: %.2f\n", trapesium.getLuas());
                System.out.printf("Keliling trapesium: %.2f\n", trapesium.getKeliling());
            }, "Perhitungan trapesium");

            // Mulai semua thread
            lingkaranThread.start();
            bolaThread.start();
            juringBolaThread.start();
            temberengBolaThread.start();
            segitigaThread.start();
            limasSegitigaThread.start();
            persegiThread.start();
            limasPersegiThread.start();
            persegiPanjangThread.start();
            limasPersegiPanjangThread.start();
            belahKetupatThread.start();
            trapesiumThread.start();
            

            // Tunggu semua thread selesai
            lingkaranThread.join();
            bolaThread.join();
            juringBolaThread.join();
            temberengBolaThread.join();
            segitigaThread.join();
            limasSegitigaThread.join();
            persegiThread.start();
            limasPersegiThread.start();
            persegiPanjangThread.join();
            limasPersegiPanjangThread.join();
            belahKetupatThread.join();
            trapesiumThread.join();

            System.out.println("\n=== Semua Proses Selesai ===");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
