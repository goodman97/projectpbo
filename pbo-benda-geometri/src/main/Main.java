package main;

import benda.datar.*;
import benda.ruang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Lingkaran ling = new Lingkaran(1); // nilai default
        System.out.println("\nHitung Benda Geometri: " + ling.getNama());
        ling.prosesInputDanValidasi();
        System.out.printf("Luas Lingkaran: %.2f\n", ling.getLuas());
        System.out.printf("Keliling Lingkaran: %.2f\n", ling.getKeliling());

        Bola bola = new Bola(1);    
        bola.prosesInputDanValidasi();
        System.out.println("\nHitung Benda Geometri: " + bola.getNama());
        System.out.printf("Volume Bola: %.2f\n", bola.getVolume());
        System.out.printf("Luas Permukaan Bola: %.2f\n", bola.getLuasPermukaan());
    }
}