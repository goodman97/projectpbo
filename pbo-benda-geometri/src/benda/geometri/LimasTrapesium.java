package benda.geometri;

public class LimasTrapesium extends Trapesium implements BangunRuang {
    protected double tinggiLimas;

    public LimasTrapesium(double atas, double bawah, double tinggiAlas, double sisiMiring, double tinggiLimas) {
        super(atas, bawah, tinggiAlas, sisiMiring);
        this.tinggiLimas = tinggiLimas;
    }

    @Override
    public double hitungVolume() {
        return (1.0 / 3.0) * hitungLuas() * tinggiLimas;
    }

    @Override
    public double hitungLuasPermukaan() {
        // Luas permukaan = luas alas + jumlah luas sisi tegak (sisi tegak diasumsikan segitiga)
        double luasSegitiga = 0.5 * hitungKeliling() * tinggiLimas / 4;
        return hitungLuas() + 4 * luasSegitiga;
    }

    public double getVolumeLimasTrapesium() {
        return hitungVolume();
    }

    public double getLuasPermukaanLimasTrapesium() {
        return hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Limas Trapesium";
    }
}