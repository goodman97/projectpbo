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
        return (1.0 / 3.0) * super.luas * tinggiLimas;
    }

    public double hitungVolume(double newAtas, double newBawah, double newTinggi, double tinggiLimas) {
        return (1.0 / 3.0) * (newAtas + newBawah) * 0.5 * newTinggi * tinggiLimas;
    }

    public double hitungLuasPermukaan() {
        double luasSegitigaTegak = 0.5 * super.keliling * tinggiLimas / 4;
        return hitungLuas() + 4 * luasSegitigaTegak;
    }

    public double hitungLuasPermukaan(double newAtas, double newBawah, double newTinggi, double tinggiLimas) {
        double luasSegitigaTegak = 0.5 * super.keliling * tinggiLimas / 4;
        return hitungLuas() + 4 * luasSegitigaTegak;
    }
}
