package benda.geometri;

public class LimasBelahKetupat extends BelahKetupat implements BangunRuang {
    protected double tinggiLimas;
    protected double volume;
    protected double luasPermukaan;

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
    
    @Override
    public double hitungVolume() {
        return (1.0 / 3.0) * luas * tinggiLimas;
    }

    @Override
    public double hitungLuasPermukaan() {
        double luasSegitiga = 0.5 * sisi * Math.sqrt(Math.pow(sisi, 2) - Math.pow(diagonal1 / 2, 2));
        return hitungLuas() + 4 * luasSegitiga;
    }
}