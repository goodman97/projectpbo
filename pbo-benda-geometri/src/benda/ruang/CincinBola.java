package benda.ruang;

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
        volume = super.volume - Math.pow(jariJariDalam, 3);
        return volume;
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaan = 4 * Math.PI * (Math.pow(jariJari, 2) + Math.pow(jariJariDalam, 2));
        return luasPermukaan;
    }
}
