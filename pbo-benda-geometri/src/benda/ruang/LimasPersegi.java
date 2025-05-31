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

    public double hitungLuasPermukaan() {
        double luasSegitiga = 0.5 * sisi * Math.sqrt(Math.pow((sisi / 2), 2) + Math.pow(tinggiLimas, 2));
        luasPermukaan = super.luas + 4 * luasSegitiga;
        return luasPermukaan;
    }
}
