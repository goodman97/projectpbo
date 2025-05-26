package benda.geometri;

public class CincinBola extends Bola {
    protected double jariJariDalam;
    protected double volume;
    protected double luasPermukaan;

    public CincinBola(double jariJariLuar, double jariJariDalam) {
        super(jariJariLuar);
        this.jariJariDalam = jariJariDalam;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
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
