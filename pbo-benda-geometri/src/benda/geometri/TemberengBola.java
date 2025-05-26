package benda.geometri;

public class TemberengBola extends Bola {
    protected double tinggi;

    public TemberengBola(double jariJari, double tinggi) {
        super(jariJari);
        this.tinggi = tinggi;
    }

    @Override
    public String getNama() {
        return "Tembereng Bola";
    }

    @Override
    public double hitungVolume() {
        return (1.0 / 6.0) * Math.PI * tinggi * (3 * Math.pow(jariJari, 2) + Math.pow(tinggi, 2));
    }

    @Override
    public double hitungLuasPermukaan() {
        return 2 * Math.PI * jariJari * tinggi;
    }
}
