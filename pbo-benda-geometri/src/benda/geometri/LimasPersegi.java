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
        volume = (1.0 / 3.0) * hitungLuas() * tinggiLimas;
        return volume;
    }

    @Override
    public double hitungLuasPermukaan() {
        double luasSegitiga = 0.5 * sisi * Math.sqrt(Math.pow((sisi / 2), 2) + Math.pow(tinggiLimas, 2));
        luasPermukaan = hitungLuas() + 4 * luasSegitiga;
        return luasPermukaan;
    }

    @Override
    public String getNama() {
        return "Limas Persegi";
    }
}
