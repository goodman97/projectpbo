package benda.geometri;

public class JuringBola extends Bola {
    protected double sudut; // dalam derajat
    protected double volume;
    protected double luasPermukaan;

    public JuringBola(double jariJari, double sudut) {
        super(jariJari);
        this.sudut = sudut;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }
    
    @Override
    public String getNama() {
        return "Juring Bola";
    }
    
    @Override
    public double hitungVolume() {
        return (sudut / 360.0) * super.hitungVolume();
    }

    @Override
    public double hitungLuasPermukaan() {
        return (sudut / 360.0) * super.hitungLuasPermukaan() + Math.PI * Math.pow(jariJari, 2);
    }
}