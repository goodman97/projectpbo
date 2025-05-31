package benda.ruang;

import benda.datar.Trapesium;

public class LimasTrapesium extends Trapesium{
    protected double tinggiLimas;

    public LimasTrapesium(double atas, double bawah, double tinggiAlas, double sisiMiring, double tinggiLimas) {
        super(atas, bawah, tinggiAlas, sisiMiring);
        this.tinggiLimas = tinggiLimas;
    }
    
    @Override
    public String getNama() {
        return "Limas Trapesium";
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * hitungLuas() * tinggiLimas;
    }

    public double hitungLuasPermukaan() {
        double luasSegitiga = 0.5 * hitungKeliling() * tinggiLimas / 4;
        return hitungLuas() + 4 * luasSegitiga;
    }
}
