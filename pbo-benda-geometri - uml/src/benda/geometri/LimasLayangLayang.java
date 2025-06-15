package benda.geometri;

public class LimasLayangLayang extends LayangLayang{
    private double tinggiLimas;
    private double volume;
    private double luasPermukaan;

    public LimasLayangLayang(double diagonal1, double diagonal2, double sisiPanjang, double sisiPendek, double tinggiLimas) {
        super(diagonal1, diagonal2, sisiPanjang, sisiPendek);
        this.tinggiLimas = tinggiLimas;
    }

    @Override
    public String getNama() {
        return "Limas Layang-Layang";
    }
    
    public double hitungVolume() {
        return volume;
    }

    public double hitungLuasPermukaan() {
        return luasPermukaan;
    }
}