package main;

import benda.geometri.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double r = 0, sudut = 0;

        System.out.println("=== HITUNG LINGKARAN, JURING, DAN TEMBERENG ===");

        try {
            // Input jari-jari
            System.out.print("Masukkan jari-jari lingkaran: ");
            r = input.nextDouble();
            if (r <= 0) {
                throw new IllegalArgumentException("Jari-jari harus lebih dari 0!");
            }

            // Input sudut
            System.out.print("Masukkan besar sudut (derajat): ");
            sudut = input.nextDouble();
            if (sudut <= 0 || sudut > 360) {
                throw new IllegalArgumentException("Sudut harus di antara 0 dan 360 derajat!");
            }

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

        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid! Harus berupa angka.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            input.close();
            System.out.println("\nProgram selesai.");
        }
    }
}
