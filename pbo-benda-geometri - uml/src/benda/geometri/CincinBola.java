package benda.geometri;

public class CincinBola extends Bola {
    private double jariJariDalam;
    private double volume;
    private double luasPermukaan;

    public CincinBola(double jariJariLuar, double jariJariDalam) {
        super(jariJariLuar);
        this.jariJariDalam = jariJariDalam;
    }

    @Override
    public String getNama() {
        return "Cincin Bola";
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
