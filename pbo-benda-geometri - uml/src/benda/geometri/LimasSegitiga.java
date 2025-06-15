package benda.geometri;

public class LimasSegitiga extends Segitiga{
    private double tinggiLimas;
    private double volume;
    private double luasPermukaan;

    public LimasSegitiga(double alas, double tinggiSegitiga, double tinggiLimas) {
        super(alas, tinggiSegitiga);
        this.tinggiLimas = tinggiLimas;
    }

    @Override
    public String getNama() {
        return "Limas Segitiga";
    }
    
    public double hitungVolume() {
        return volume;
    }
    
    public double hitungLuasPermukaan() {
        return luasPermukaan;
    }
}
