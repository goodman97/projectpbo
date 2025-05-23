package benda.geometri;

public class LimasJajaranGenjang extends JajaranGenjang implements BangunRuang {
    protected double tinggiLimas;
    protected double volume;
    protected double luasPermukaan;

    public LimasJajaranGenjang(double alas, double tinggiAlas, double sisiMiring, double tinggiLimas) {
        super(alas, tinggiAlas, sisiMiring);
        this.tinggiLimas = tinggiLimas;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Limas Jajaran Genjang";
    }

    @Override
    public double hitungVolume() {
        return (1.0 / 3.0) * hitungLuas() * tinggiLimas;
    }

    @Override
    public double hitungLuasPermukaan() {
        double luasSegitiga = 0.5 * alas * tinggiLimas;
        return hitungLuas() + 2 * luasSegitiga + 2 * (0.5 * sisiMiring * tinggiLimas);
    }
}