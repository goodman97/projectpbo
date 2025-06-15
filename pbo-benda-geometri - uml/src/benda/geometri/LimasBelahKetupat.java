package benda.geometri;

public class LimasBelahKetupat extends BelahKetupat{
    private double tinggiLimas;
    private double volume;
    private double luasPermukaan;

    public LimasBelahKetupat(double diagonal1, double diagonal2, double sisi, double tinggiLimas) {
        super(diagonal1, diagonal2, sisi);
        this.tinggiLimas = tinggiLimas;
    }

    @Override
    public String getNama() {
        return "Limas Belah Ketupat";
    }
    
    public double hitungVolume() {
        return volume;
    }

    public double hitungLuasPermukaan() {
        return luasPermukaan;
    }
}