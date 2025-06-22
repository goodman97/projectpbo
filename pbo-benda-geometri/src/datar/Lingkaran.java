package datar;

import geometri.BangunDatar;
import java.util.*;

public class Lingkaran extends BangunDatar {
    protected double jariJari;
    protected double luas;
    protected double keliling;

    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }
  
    @Override
    public String getNama() {
        return "Lingkaran";
    }

    @Override
    public double hitungLuas() {
        luas = Math.PI * Math.pow(jariJari, 2);
        return luas;
    }

    @Override
    public double hitungKeliling() {
        keliling = 2 * Math.PI * jariJari;
        return keliling;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Masukkan jari-jari lingkaran: ");
                double jariJari = inp.nextDouble();
                inp.nextLine();
                if (jariJari <= 0) {
                    System.out.println("Jari-jari harus lebih dari nol.\n");
                    continue;
                }
                this.jariJari = jariJari;
                this.luas = hitungLuas();
                this.keliling = hitungKeliling();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input jari-jari harus berupa angka.\n");
                inp.nextLine();
            }
        }
    }

    public double getLuas(){
        return luas;
    }

    public double getKeliling(){
        return keliling;
    }

    public double getJariJari(){
        return jariJari;
    }
}