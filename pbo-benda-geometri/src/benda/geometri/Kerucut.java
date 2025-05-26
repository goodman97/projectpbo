package benda.geometri;

public class Kerucut extends Lingkaran{
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

    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.hitungLuas() * tinggi;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double s = Math.sqrt(Math.pow(jariJari, 2) + Math.pow(tinggi, 2));
        luasPermukaan = Math.PI * jariJari * (jariJari + s);
        return luasPermukaan;
    }
}