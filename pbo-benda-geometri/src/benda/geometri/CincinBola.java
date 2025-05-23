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
        return (4.0 / 3.0) * Math.PI * (Math.pow(jariJari, 3) - Math.pow(jariJariDalam, 3));
    }

    @Override
    public double hitungLuasPermukaan() {
        return 4 * Math.PI * (Math.pow(jariJari, 2) + Math.pow(jariJariDalam, 2));
    }
}