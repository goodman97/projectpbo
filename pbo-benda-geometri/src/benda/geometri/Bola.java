package benda.geometri;

public class Bola extends Lingkaran implements BangunRuang {
    protected double volume;
    protected double luasPermukaan;

    public Bola(double jariJari) {
        super(jariJari);
        this.volume =  hitungVolume();
        this.luasPermukaan =  hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Bola";
    }

    @Override
    public double hitungVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(jariJari, 3);
    }

    @Override
    public double hitungLuasPermukaan() {
        return 4 * Math.PI * Math.pow(jariJari, 2);
    }
}