package ruang;

import datar.Lingkaran;

public class Tabung extends Lingkaran{
    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public Tabung(double jariJari, double tinggi) {
        super(jariJari);
        this.tinggi = tinggi;
    }
    
    @Override
    public String getNama() {
        return "Tabung";
    }

    public double hitungVolume() {
        return super.hitungLuas() * tinggi;
    }

    public double hitungLuasPermukaan() {
        return 2 * Math.PI * jariJari * (jariJari + tinggi);
    }
}
