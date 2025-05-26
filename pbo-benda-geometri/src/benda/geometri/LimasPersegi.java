package benda.geometri;

public class LimasPersegi extends Persegi{
    protected double tinggiLimas;
    protected double volume;
    protected double luasPermukaan;

    public LimasPersegi(double sisi, double tinggiLimas) {
        super(sisi);
        this.tinggiLimas = tinggiLimas;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
        
    }

    @Override
    public String getNama() {
        return "Limas Persegi";
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * hitungLuas() * tinggiLimas;
    }

    public double hitungLuasPermukaan() {
        double luasSegitiga = 0.5 * sisi * Math.sqrt(Math.pow((sisi / 2), 2) + Math.pow(tinggiLimas, 2));
        return hitungLuas() + 4 * luasSegitiga;
    }    
}
