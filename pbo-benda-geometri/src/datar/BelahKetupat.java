package datar;

import geometri.BangunDatar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BelahKetupat extends BangunDatar {
    protected double diagonal1;
    protected double diagonal2;
    protected double sisi;
    protected double luas;
    protected double keliling;

    public BelahKetupat(double diagonal1, double diagonal2) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisi = Math.sqrt(Math.pow(diagonal1 / 2, 2) + Math.pow(diagonal2 / 2, 2));
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }
    
        
    @Override
    public String getNama() {
        return "Belah Ketupat";
    }
    
    public double hitungLuas() {
        this.luas = 0.5 * diagonal1 * diagonal2;
        return luas;
    }

    public double hitungKeliling() {
        this.keliling = sisi * 4;
        return keliling;
    }
    
    public double hitungLuas(double newDiagonal1, double newDiagonal2){
        luas = (newDiagonal1 * newDiagonal2) / 2;
        return luas;
    }
    
    public double hitungKeliling(double newDiagonal1, double newDiagonal2) {
        keliling = (2 * newDiagonal1) + (2 * newDiagonal2);
        return keliling;
    }

    public void prosesInputDanValidasi() {
       Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai diagonal? (Y/N): ");
            String jawab = inp.nextLine();
            
            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukan diagonal 1 baru: ");
                        double newDiagonal1 = inp.nextDouble();
                        System.out.print("Masukan diagonal 2 baru: ");
                        double newDiagonal2 = inp.nextDouble();
                        inp.nextLine();
                        if (newDiagonal1 <= 0 || newDiagonal2 <= 0) {
                            System.out.println("Diagonal harus lebih dari nol.\n");
                            continue;
                        }
                        diagonal1 = newDiagonal1;
                        diagonal2 = newDiagonal2;
                        luas = hitungLuas(newDiagonal1, newDiagonal2);
                        keliling = hitungKeliling(newDiagonal1, newDiagonal2);
                        System.out.printf("\nLuas Belah Ketupat: %.2f\n", luas);
                        System.out.printf("Keliling Belah Ketupat: %.2f\n", keliling);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid. Silakan masukkan angka.");
                        inp.nextLine(); // Clear the invalid input
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan masukkan Y atau N.");
            }
        }
    }

    // Getter
    public double getDiagonal1() {
        return diagonal1;
    }

    public double getDiagonal2() {
        return diagonal2;
    }

    public double getSisi() {
        return sisi;
    }  
}