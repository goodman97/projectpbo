package main;

import benda.geometri.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== HITUNG LINGKARAN, JURING, DAN TEMBERENG ===");
        
        System.out.print("Masukkan jari-jari lingkaran: ");
        double r = input.nextDouble();

        System.out.print("Masukkan besar sudut (derajat): ");
        double sudut = input.nextDouble();

        System.out.println("\n--- HASIL PERHITUNGAN ---");

        Lingkaran lingkaran = new Lingkaran(r);
        System.out.println("\n[" + lingkaran.getNama() + "]");
        System.out.println("Luas: " + lingkaran.hitungLuas());
        System.out.println("Keliling: " + lingkaran.hitungKeliling());

        JuringLingkaran juring = new JuringLingkaran(r, sudut);
        System.out.println("\n[" + juring.getNama() + "]");
        System.out.println("Luas: " + juring.hitungLuas());
        System.out.println("Keliling: " + juring.hitungKeliling());

        TemberengLingkaran tembereng = new TemberengLingkaran(r, sudut);
        System.out.println("\n[" + tembereng.getNama() + "]");
        System.out.println("Luas: " + tembereng.hitungLuas());
        System.out.println("Keliling: " + tembereng.hitungKeliling());

        input.close();
    }
}