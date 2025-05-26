package benda.geometri;

public class LimasSegitiga extends Segitiga{
    protected double tinggiLimas;

    public LimasSegitiga(double alas, double tinggiSegitiga, double tinggiLimas) {
        super(alas, tinggiSegitiga);
        this.tinggiLimas = tinggiLimas;
    }

    @Override
    public String getNama() {
        return "Limas Segitiga";
    }
    
    public double hitungVolume() {
        return (1.0 / 3.0) * hitungLuas() * tinggiLimas;
    }

    public double hitungLuasPermukaan() {
        double sisiMiring = Math.sqrt(Math.pow(alas / 2, 2) + Math.pow(tinggiLimas, 2));
        double luasTegak = 0.5 * alas * sisiMiring;
        return hitungLuas() + 3 * luasTegak;
    }
}
