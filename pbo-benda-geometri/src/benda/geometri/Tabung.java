package benda.geometri;

public class Tabung extends Lingkaran{
    protected double tinggi;

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
