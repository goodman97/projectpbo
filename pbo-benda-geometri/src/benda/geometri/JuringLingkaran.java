package benda.geometri;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class JuringLingkaran extends Lingkaran{
    protected double sudut;
    protected double luas;
    protected double keliling;
    protected double panjangBusur;
    
    public JuringLingkaran(double jariJari, double sudut) {
        super(jariJari);
        this.sudut = sudut;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }
    
    @Override
    public String getNama() {
        return "Juring Lingkaran";
    }

    @Override
    public double hitungLuas() {
        luas = (sudut / 360.0) * super.luas;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        panjangBusur = (sudut / 360.0) * super.keliling;
        keliling = 2 * jariJari + panjangBusur;
        return keliling;
    }

    public double hitungLuas(double newJarijari){
        luas = (sudut / 360.0) * (Math.pow(newJarijari, 2) * Math.PI);
        return luas;
    }

    public double hitungKeliling(double newJarijari){
        panjangBusur = (sudut / 360.0) * (2 * Math.PI * newJarijari);
        keliling = 2 * newJarijari + panjangBusur;
        return keliling;
    }

    public void ProsesPerhitungan(){
        Scanner inp = new Scanner(System.in);
        System.out.print("Apakah ingin mengubah nilai jari-jari Juring Lingkarean? (Y/N): ");
        String jawab = inp.nextLine();


        if (jawab.equalsIgnoreCase("Y")) {
            try {
                System.out.print("Masukkan jari-jari baru: ");
                double newJarijari = inp.nextDouble();
                if (newJarijari <= 0) {
                    throw new IllegalArgumentException("Jari-jari harus lebih dari nol.");
                }
                luas = hitungLuas(newJarijari);
                keliling = hitungKeliling(newJarijari);
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("Input jari-jari harus berupa angka.");
            }finally{
                inp.close();
            }
        } else if (jawab.equalsIgnoreCase("N")) {
                luas = hitungLuas();
                keliling = hitungKeliling();
        } else {
            throw new IllegalArgumentException(" Jawaban hanya boleh Y atau N.");
        }
    }

    public double luas() {
        return luas;
    }

    public double keliling() {
        return keliling;
    }

}
