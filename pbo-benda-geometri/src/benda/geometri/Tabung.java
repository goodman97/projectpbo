package benda.geometri;

public class Tabung extends Lingkaran implements BangunRuang {
    protected double tinggi;

    public Tabung(double jariJari, double tinggi) {
        super(jariJari);
        this.tinggi = tinggi;
    }

    @Override
    public double hitungVolume() {
        return super.hitungLuas() * tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {
        return 2 * Math.PI * jariJari * (jariJari + tinggi);
    }



    @Override
    public String getNama() {
        return "Tabung";
    }
}
