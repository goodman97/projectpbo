package datar;

import geometri.BangunDatar;
import java.util.Scanner;

public class JajaranGenjang extends BangunDatar{
    protected double alas;
    protected double tinggi;
    protected double sisiMiring;
    protected double luas;
    protected double keliling;
    
    public JajaranGenjang(double alas, double tinggi, double sisiMiring) {
        this.alas = alas;
        this.tinggi = tinggi;
        this.sisiMiring = sisiMiring;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    @Override
    public String getNama() {
        return "Jajaran Genjang";
    }
    
    @Override
    public double hitungLuas() {
        this.luas = alas * tinggi;
        return luas;
    }
    
    @Override
    public double hitungKeliling() {
        this.keliling = alas * 2 + sisiMiring * 2;
        return keliling;
    }
    
     public double hitungLuas(double alasBaru, double tinggiBaru) {
        luas = alasBaru * tinggiBaru;
        return luas;
    }

    public double hitungKeliling(double alasBaru, double sisiMiringBaru) {
        keliling = alasBaru *2 + sisiMiring * 2;
        return keliling;
    }
    
     public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai sisi A dan B? (Y/N): ");
            String jawab = inp.nextLine();
            
            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukan alas baru: ");
                        double newAlas = inp.nextDouble();
                        System.out.print("Masukan tinggi baru: ");
                        double newTinggi = inp.nextDouble();
                        System.out.print("Masukan sisi Miring baru: ");
                        double newSisiMiring = inp.nextDouble();
                      
                        
                        if (newAlas <= 0 || newTinggi <= 0 || newSisiMiring <= 0 ) {
                            System.out.println("Alas, tinggi, dan sisi Miring B harus lebih dari nol.\n");
                            continue;
                        }
                        
                        alas = newAlas;
                        tinggi = newTinggi;
                        sisiMiring = newSisiMiring;
                        
                        luas = hitungLuas(newAlas, newTinggi);
                        keliling = hitungKeliling(newAlas, newSisiMiring);
                        
                        System.out.printf("\nLuas Jajar Genjang: %.2f\n", luas);
                        System.out.printf("Keliling Jajar Genjang: %.2f\n", keliling);
                        break;
                    } catch (Exception e) {
                        System.out.println("Input tidak valid. Silakan coba lagi.");
                        inp.nextLine(); // Clear the invalid input
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                luas = hitungLuas();
                keliling = hitungKeliling();
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan masukkan Y atau N.");
            }
        }
    }

    public double getAlas() {
        return alas;
    }

    public double getTinggi() {
        return tinggi;
    }

    public double getSisiMiring(){
        return sisiMiring;
    }
}
