package benda.geometri;

public class PrismaTrapesium extends Trapesium implements BangunRuang {
    protected double tinggiPrisma;

    public PrismaTrapesium(double atas, double bawah, double tinggiAlas, double sisiMiring, double tinggiPrisma) {
        super(atas, bawah, tinggiAlas, sisiMiring);
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public double hitungVolume() {
        return hitungLuas() * tinggiPrisma;
    }

    @Override
    public double hitungLuasPermukaan() {
        return 2 * hitungLuas() + hitungKeliling() * tinggiPrisma;
    }

    public double getVolumePrismaTrapesium() {
        return hitungVolume();
    }

    public double getLuasPermukaanPrismaTrapesium() {
        return hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Prisma Trapesium";
    }
}