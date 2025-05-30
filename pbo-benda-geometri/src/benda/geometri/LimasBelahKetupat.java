package benda.geometri;

public class LimasBelahKetupat extends BelahKetupat{
    private double tinggiLimas;
    private double volume;
    private double luasPermukaan;

    public LimasBelahKetupat(double diagonal1, double diagonal2, double sisi, double tinggiLimas) {
        super(diagonal1, diagonal2, sisi);
        this.tinggiLimas = tinggiLimas;
        this.volume =  hitungVolume();
        this.luasPermukaan =  hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Limas Belah Ketupat";
    }
    
    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.luas * tinggiLimas;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double luasSegitiga = 0.5 * sisi * Math.sqrt(Math.pow(sisi, 2) - Math.pow(diagonal1 / 2, 2));
        luasPermukaan = super.luas + 4 * luasSegitiga;
        return luasPermukaan;
    }
}