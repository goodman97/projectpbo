package benda.geometri;

public class PrismaPersegi extends Persegi implements BangunRuang {
    protected double tinggiPrisma;
    protected double volume;
    protected double luasPermukaan;

    public PrismaPersegi(double sisi, double tinggiPrisma) {
        super(sisi);
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public double hitungVolume() {
        return hitungLuas() * tinggiPrisma;
    }

    @Override
    public double hitungLuasPermukaan() {
        return 2 * hitungLuas() + 4 * sisi * tinggiPrisma;
    }

    public double getVolumePrismaPersegi() {
        return hitungVolume();
    }

    public double getLuasPermukaanPrismaPersegi() {
        return hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Prisma Persegi";
    }
}