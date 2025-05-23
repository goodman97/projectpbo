package benda.geometri;

public class LimasSegitiga extends Segitiga implements BangunRuang {
    protected double tinggiLimas;

    public LimasSegitiga(double alas, double tinggiSegitiga, double tinggiLimas) {
        super(alas, tinggiSegitiga);
        this.tinggiLimas = tinggiLimas;
    }

    @Override
    public double hitungVolume() {
        return (1.0 / 3.0) * hitungLuas() * tinggiLimas;
    }

    @Override
    public double hitungLuasPermukaan() {
        double sisiMiring = Math.sqrt(Math.pow(alas / 2, 2) + Math.pow(tinggiLimas, 2));
        double luasTegak = 0.5 * alas * sisiMiring;
        return hitungLuas() + 3 * luasTegak;
    }

    public double getVolumeLimasSegitiga() {
        return hitungVolume();
    }

    public double getLuasPermukaanLimasSegitiga() {
        return hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Limas Segitiga";
    }
}