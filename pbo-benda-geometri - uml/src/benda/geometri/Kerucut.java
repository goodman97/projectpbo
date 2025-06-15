package benda.geometri;

public class Kerucut extends Lingkaran{
    protected double tinggiKerucut;
    protected double volume;
    protected double luasPermukaan;

    public Kerucut(double jariJari, double tinggi) {
        super(jariJari);
        this.tinggiKerucut = tinggiKerucut;
    }

    @Override
    public String getNama() {
        return "Kerucut";
    }

    public double hitungVolume() {
        return volume;
    }

    public double hitungLuasPermukaan() {
        return luasPermukaan;
    }
}
