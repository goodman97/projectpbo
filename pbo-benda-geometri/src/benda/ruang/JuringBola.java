package benda.ruang;

import java.util.*;

public class JuringBola extends Bola {
    private double sudut; // dalam derajat
    private double volume;
    private double luasPermukaan;

    public JuringBola(double jariJari, double sudut) {
        super(jariJari);
        this.sudut = sudut;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }
    
    @Override
    public String getNama() {
        return "Juring Bola";
    }
    
    @Override
    protected double hitungVolume() {
        volume = (sudut / 360.0) * super.volume;
        return volume;
    }

    // Overload
    protected double hitungVolume(double newJariJari, double sudut){
        volume = (sudut/360.0) * (4.0/3.0) * Math.PI * Math.pow(newJariJari, 3);
        return volume;
    }

    @Override
    protected double hitungLuasPermukaan() {
        luasPermukaan = (sudut / 360.0) * super.luasPermukaan + super.luas;
        return luasPermukaan;
    }

    // Overload
    protected double hitungLuasPermukaan(double newJariJari, double sudut){
        luasPermukaan = ((sudut / 360.0) * 4 * Math.PI * Math.pow(newJariJari, 2)) + (Math.PI * Math.pow(newJariJari, 2));
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("Nilai jari-jari Bola saat ini adalah " + super.jariJari + ". Apakah ingin mengubah nilai jari-jari? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan jari-jari baru: ");
                        double newJariJari = inp.nextDouble();
                        inp.nextLine();
                        System.out.print("Masukkan besar sudut pusat: ");
                        sudut = inp.nextDouble();
                        inp.nextLine();
                        if (newJariJari <= 0 || sudut <= 0) {
                            System.out.println("Jari-jari dan Sudut Pusat harus lebih dari nol.\n");
                            continue;
                        }
                        super.jariJari = newJariJari;
                        this.sudut = sudut;
                        this.volume = hitungVolume(newJariJari, sudut);
                        this.luasPermukaan = hitungLuasPermukaan(newJariJari, sudut);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input jari-jari harus berupa angka.");
                        inp.nextLine();
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                System.out.print("Masukkan besar sudut pusat: ");
                this.sudut = inp.nextDouble();
                this.volume = hitungVolume();
                this.luasPermukaan = hitungLuasPermukaan();
                break;
            } else {
                System.out.println("Jawaban hanya boleh Y atau N.\n");
            }
        }
    }

    public double getVolume(){
        return volume;
    }

    public double getLuasPermukaan(){
        return luasPermukaan;
    }
}