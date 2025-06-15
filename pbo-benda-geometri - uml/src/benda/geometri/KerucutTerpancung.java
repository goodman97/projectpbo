package benda.geometri;

public class KerucutTerpancung extends Kerucut {
    private double jariJariAtas;
    private double volume;
    private double luasPermukaan;

    public KerucutTerpancung(double jariJariBawah, double jariJariAtas, double tinggi) {
        super(jariJariBawah, tinggi);
        this.jariJariAtas = jariJariAtas;
    }

    @Override
    public String getNama() {
        return "Kerucut Terpancung";
    }

    @Override
    public double hitungVolume() {
        return volume;
    }

    @Override
    public double hitungLuasPermukaan() {
        return luasPermukaan;
    }
}
