package ruang;

import datar.JajaranGenjang;

public class LimasJajaranGenjang extends JajaranGenjang{
    private double tinggiLimas;
    private double volume;
    private double luasPermukaan;

    public LimasJajaranGenjang(double alas, double tinggiAlas, double sisiMiring, double tinggiLimas) {
        super(alas, tinggiAlas, sisiMiring);
        this.tinggiLimas = tinggiLimas;
    }

    @Override
    public String getNama() {
        return "Limas Jajaran Genjang";
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * hitungLuas() * tinggiLimas;
    }

    public double hitungLuasPermukaan() {
        double luasSegitiga = 0.5 * alas * tinggiLimas;
        return hitungLuas() + 2 * luasSegitiga + 2 * (0.5 * sisiMiring * tinggiLimas);
    }
}