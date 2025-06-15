package benda.geometri;

public class LimasPersegi extends Persegi{
    private double tinggiLimas;
    private double volume;
    private double luasPermukaan;

    public LimasPersegi(double sisi, double tinggiLimas) {
        super(sisi);
        this.tinggiLimas = tinggiLimas;
        
    }

    @Override
    public String getNama() {
        return "Limas Persegi";
    }

    public double hitungVolume() {
        return volume;
    }

    public double hitungLuasPermukaan() {
        return luasPermukaan;
    }
}
