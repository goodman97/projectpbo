package benda.geometri;

public class Bola extends Lingkaran {
    protected double volume;
    protected double luasPermukaan;

    public Bola(double jariJari) {
        super(jariJari);
    }

    @Override
    public String getNama() {
        return "Bola";
    }

    protected double hitungVolume() {
        return volume;
    }
    protected double hitungLuasPermukaan() {
        return luasPermukaan;
    }
}
