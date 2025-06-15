package benda.geometri;

public class JuringBola extends Bola {
    private double sudut;
    private double volume;
    private double luasPermukaan;

    public JuringBola(double jariJari, double sudut) {
        super(jariJari);
        this.sudut = sudut;
    }

    @Override
    public String getNama() {
        return "Juring Bola";
    }

    @Override
    protected double hitungVolume() {
        return volume;
    }

    @Override
    protected double hitungLuasPermukaan() {
        return luasPermukaan;
    }
}