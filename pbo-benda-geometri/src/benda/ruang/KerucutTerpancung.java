package benda.geometri;

public class KerucutTerpancung extends Kerucut {
    protected double jariJariAtas;
    protected double volume;
    protected double luasPermukaan;

    public KerucutTerpancung(double jariJariBawah, double jariJariAtas, double tinggi) {
        super(jariJariBawah, tinggi);
        this.jariJariAtas = jariJariAtas;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Kerucut Terpancung";
    }
    
    @Override
    public double hitungVolume() {
        return (1.0 / 3.0) * Math.PI * tinggi * (Math.pow(jariJari, 2) + Math.pow(jariJariAtas, 2) + jariJari * jariJariAtas);
    }

    @Override
    public double hitungLuasPermukaan() {
        double s = Math.sqrt(Math.pow((jariJari - jariJariAtas), 2) + Math.pow(tinggi, 2));
        return Math.PI * (jariJari + jariJariAtas) * s + Math.PI * Math.pow(jariJari, 2) + Math.PI * Math.pow(jariJariAtas, 2);
    }   
}