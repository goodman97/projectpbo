package benda.geometri;

public class LimasPersegi extends Persegi implements BangunRuang {
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
    public double hitungVolume() {
        return (1.0 / 3.0) * hitungLuas() * tinggiLimas;
    }

    @Override
    public double hitungLuasPermukaan() {
        double luasSegitiga = 0.5 * sisi * Math.sqrt(Math.pow((sisi / 2), 2) + Math.pow(tinggiLimas, 2));
        return hitungLuas() + 4 * luasSegitiga;
    }

    @Override
    public String getNama() {
        return "Limas Persegi";
    }
}
