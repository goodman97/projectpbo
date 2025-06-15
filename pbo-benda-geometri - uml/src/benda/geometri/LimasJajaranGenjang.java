package benda.geometri;

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
        return volume;
    }

    public double hitungLuasPermukaan() {
        return luasPermukaan;
    }
}