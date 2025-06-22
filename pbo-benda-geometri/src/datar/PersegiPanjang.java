package datar;

import geometri.BangunDatar;
import java.util.*;

public class PersegiPanjang extends BangunDatar {
    protected double panjang;
    protected double lebar;
    protected double luas;
    protected double keliling;
 

    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    @Override
    public String getNama() {
        return "Persegi Panjang";
    }

    @Override
    public double hitungLuas() {
        luas =  panjang * lebar;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        keliling = 2 * (panjang + lebar);
        return keliling;
    }

    public double hitungLuas(double newpanjang, double newlebar) {
        luas = newpanjang * newlebar;
        return luas;
    }
    
    public double hitungKeliling(double newpanjang,double newlebar){
        keliling = 2 * (newpanjang + newlebar);
        return keliling;
    }

    public void prosesInputDanValidasi() {
    Scanner inp = new Scanner(System.in);
    
    while (true) {
        try {
            System.out.print("Masukkan Panjang : ");
            double newpanjang = inp.nextDouble();
            inp.nextLine(); // consume newline
            
            if (panjang <= 0) {
                System.out.println("Panjang harus lebih dari nol.\n");
                continue;
            }

            System.out.print("Masukkan Lebar : ");
            double newlebar = inp.nextDouble();
            inp.nextLine(); 
            
            if (lebar <= 0) {
                System.out.println("Lebar harus lebih dari nol.\n");
                continue;
            }
            lebar = newlebar;
            panjang = newpanjang;
            luas = hitungLuas(newpanjang, newlebar);
            keliling = hitungKeliling(newpanjang, newlebar);
            break;
        } catch (InputMismatchException e) {
            System.out.println("Input panjang harus berupa angka.\n");
            inp.nextLine(); 
        }
    }
   
    }

    public double getPanjang(){
        return panjang;
    }

    public double getLebar(){
        return lebar;
    }

}