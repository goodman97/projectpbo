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

            // Mulai semua thread
            lingkaranThread.start();
            bolaThread.start();
            juringBolaThread.start();
            temberengBolaThread.start();
            segitigaThread.start();
            limasSegitigaThread.start();

            // Tunggu semua thread selesai
            lingkaranThread.join();
            bolaThread.join();
            juringBolaThread.join();
            temberengBolaThread.join();
            segitigaThread.join();
            limasSegitigaThread.join();

            System.out.println("\n=== Semua Proses Selesai ===");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
