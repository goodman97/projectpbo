package benda.geometri;

public class TemberengBola extends Bola {
    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public TemberengBola(double jariJari, double tinggi) {
        super(jariJari);
        this.tinggi = tinggi;
    }

    @Override
    public String getNama() {
        return "Tembereng Bola";
    }

    @Override
    protected double hitungVolume() {
        return volume;    
    }

    @Override
    public double hitungLuasPermukaan() {
        return luasPermukaan; 
    }
}
