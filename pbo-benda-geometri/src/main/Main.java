package main;

import benda.datar.*;
import benda.ruang.*;

public class Main {
    public static void main(String[] args) {
        /*
        Lingkaran lingkaran = new Lingkaran(0);
        lingkaran.prosesInputDanValidasi();
        System.out.println("\nHitung Benda Geometri: " + lingkaran.getNama());
        System.out.printf("Luas Lingkaran: %.2f\n", lingkaran.getLuas());
        System.out.printf("Keliling Lingkaran: %.2f\n", lingkaran.getKeliling());

        Bola bola = new Bola(lingkaran.getJariJari());    
        bola.prosesInputDanValidasi();
        System.out.println("\nHitung Benda Geometri: " + bola.getNama());
        System.out.printf("Volume Bola: %.2f\n", bola.getVolume());
<<<<<<< HEAD
        System.out.printf("Luas Permukaan Bola: %.2f\n", bola.getLuasPermukaan());

        JuringBola JBola = new JuringBola(bola.getJariJari(), 0);
        JBola.prosesInputDanValidasi();
        System.out.println("\nHitung Benda Geometri: " + JBola.getNama());
        System.out.printf("Volume Juring Bola: %.2f\n", JBola.getVolume());
        System.out.printf("Luas Permukaan Juring Bola: %.2f\n", JBola.getLuasPermukaan());

        TemberengBola TBola = new TemberengBola(bola.getJariJari(), 0);
        TBola.prosesInputDanValidasi();
        System.out.println("\nHitung Benda Geometri: " + TBola.getNama());
        System.out.printf("Volume Tembereng Bola: %.2f\n", TBola.getVolume());
        System.out.printf("Luas Permukaan Tembereng Bola: %.2f\n", TBola.getLuasPermukaan());
=======
        System.out.printf("Luas Permukaan Bola: %.2f\n\n", bola.getLuasPermukaan());
        */

        Segitiga segitiga = new Segitiga(1, 1);
        segitiga.prosesInputDanValidasi();
        System.out.println("\nHitung Benda Geometri: " + segitiga.getNama());
        System.out.printf("Luas segitiga: %.2f\n", segitiga.getLuas());
        System.out.printf("Keliling segitiga: %.2f\n", segitiga.getKeliling());

        LimasSegitiga limasSegitiga = new LimasSegitiga(segitiga.getAlas(), segitiga.getTinggiSegitiga(), 0);
        limasSegitiga.prosesInputDanValidasi();
        System.out.println("\nHitung Benda Geometri: " + limasSegitiga.getNama());
        System.out.printf("Volume Limas Segitiga: %.2f\n", limasSegitiga.getVolume());
        System.out.printf("Luas Permukaan Limas Segitiga: %.2f\n", limasSegitiga.getLuasPermukaan());
>>>>>>> 5332e90a469e2a039633593b96ac4ee86d0853b1
    }
}