package benda.geometri;

public class LimasTrapesium extends Trapesium{
    private double tinggiLimas;
    private double volume;
    private double luasPermukaan;

    public LimasTrapesium(double atas, double bawah, double tinggiAlas, double sisiMiring, double tinggiLimas) {
        super(atas, bawah, tinggiAlas, sisiMiring);
        this.tinggiLimas = tinggiLimas;
    }
    
    @Override
    public String getNama() {
        return "Limas Trapesium";
    }

    public double hitungVolume() {
        return volume;
    }

    public double hitungLuasPermukaan() {
        return luasPermukaan;
    }
}
