package benda.ruang;

import benda.datar.LayangLayang;

public class LimasLayangLayang extends LayangLayang{
    protected double tinggiLimas;
    protected double volume;
    protected double luasPermukaan;

    public LimasLayangLayang(double diagonal1, double diagonal2, double sisiPanjang, double sisiPendek, double tinggiLimas) {
        super(diagonal1, diagonal2, sisiPanjang, sisiPendek);
        this.tinggiLimas = tinggiLimas;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Limas Layang-Layang";
    }
    
    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.luas * tinggiLimas;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double luasTegakPanjang = 0.5 * sisiPanjang * tinggiLimas;
        double luasTegakPendek = 0.5 * sisiPendek * tinggiLimas;
        luasPermukaan = super.luas + 2 * luasTegakPanjang + 2 * luasTegakPendek;
        return luasPermukaan;
    }
}