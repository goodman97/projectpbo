package benda.geometri;

import java.util.Scanner;

public class Bola extends Lingkaran {
    protected double volume;
    protected double luasPermukaan;
    protected double newR;
    char  jawab  = 'Y';

    public Bola(double jariJari) {
        super(jariJari);
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Bola";
    }

    public double hitungVolume() {
        volume = (4.0 / 3.0) * super.jariJari * super.luas;
        return volume;
    }

    public double hitungVolume(double newR){
        System.out.println("apakah anda akan mengedit value jari-jari?");
        if(jawab == 'Y' || jawab =='y'){
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukan nilai jari-jari baru");
            newR = inp.nextDouble();           
            volume = (4.0 / 3.0) * Math.PI * Math.pow(newR, 3);
            return volume;
        }else{
            volume = (4.0 / 3.0) * super.jariJari * super.luas;
            return volume;
        }
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = 4 * super.luas;
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newR) {
        System.out.println("apakah anda akan mengedit value jari-jari?");
        if(jawab == 'Y' || jawab =='y'){
            Scanner inp = new Scanner(System.in);
            System.out.println("Masukan nilai jari-jari baru");
            newR = inp.nextDouble();
            
            luasPermukaan = 4 * super.hitungLuas(newR);
            return luasPermukaan;
        }else{
            luasPermukaan = 4 * super.luas;
            return luasPermukaan;
        }
    }
}
