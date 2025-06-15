package benda.geometri;

public class Tabung extends Lingkaran{
    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public Tabung(double jariJari, double tinggi) {
        super(jariJari);
        this.tinggi = tinggi;
    }
    
    @Override
    public String getNama() {
        return "Tabung";
    }

    public double hitungVolume() {
        return volume;
    }

    public double hitungLuasPermukaan() {
        return luasPermukaan;
    }
}
