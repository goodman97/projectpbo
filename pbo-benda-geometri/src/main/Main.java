package main;
import benda.geometri.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Masukkan jari-jari lingkaran: ");
            double r = input.nextDouble();
            input.nextLine(); // flush newline

            Lingkaran ling = new Lingkaran(r);
            Bola bola = new Bola(r);

            System.out.printf("Luas Lingkaran: %.2f\n", ling.hitungLuas());
            System.out.printf("Keliling Lingkaran: %.2f\n", ling.hitungKeliling());

            bola.prosesHitungVolumeDanLuasPermukaan();

            System.out.printf("Volume Bola: %.2f\n", bola.getVolume());
            System.out.printf("Luas Permukaan Bola: %.2f\n", bola.getLuasPermukaan());

        } catch (InputMismatchException e) {
            System.out.println("❌ Error: Input jari-jari harus berupa angka.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            input.close();
        }
    }
}