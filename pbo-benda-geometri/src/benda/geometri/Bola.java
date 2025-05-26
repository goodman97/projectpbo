package benda.geometri;

public class Bola extends Lingkaran{
    protected double volume;
    protected double luasPermukaan;

    public Bola(double jariJari) {
        super(jariJari);
        this.volume =  hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Bola";
    }

    public double hitungVolume() {
        volume = (4.0 / 3.0) * super.luas * jariJari;
        return volume;
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = super.keliling * 2;
        return luasPermukaan;
    }
}