package benda.ruang;

import benda.datar.Persegi;

public class LimasPersegi extends Persegi{
    protected double tinggiLimas;
    protected double volume;
    protected double luasPermukaan;

    public LimasPersegi(double sisi, double tinggiLimas) {
        super(sisi);
        this.tinggiLimas = tinggiLimas;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
        
    }

    @Override
    public String getNama() {
        return "Limas Persegi";
    }

    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.luas * tinggiLimas;
        return volume;
    }

    public double hitungVolume(double newSisi, double tinggiLimas) {
        volume = (1.0 / 3.0) * Math.pow(newSisi, 2) * tinggiLimas;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double luasSegitigaTegak = 0.5 * super.sisi * Math.sqrt(Math.pow((0.5 * super.sisi), 2) + Math.pow(tinggiLimas, 2));
        luasPermukaan = super.luas + 4 * luasSegitigaTegak;
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newSisi, double tinggiLimas) {
        double luasSegitigaTegak = 0.5 * newSisi * Math.sqrt(Math.pow((0.5 * newSisi), 2) + Math.pow(tinggiLimas, 2));
        luasPermukaan = Math.pow(newSisi, 2) + 4 * luasSegitigaTegak;
        return luasPermukaan;
    }
}
