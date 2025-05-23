package benda.geometri;

public class Kerucut extends Lingkaran implements BangunRuang {
    protected double tinggi;
    protected double volume;
    protected double luasPermukaan;

    public Kerucut(double jariJari, double tinggi) {
        super(jariJari);
        this.tinggi = tinggi;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Kerucut";
    }

    @Override
    public double hitungVolume() {
        return (1.0 / 3.0) * super.hitungLuas() * tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {
        double s = Math.sqrt(Math.pow(jariJari, 2) + Math.pow(tinggi, 2));
        return Math.PI * jariJari * (jariJari + s);
    }
}