package benda.geometri;

public class PrismaPersegi extends Persegi implements BangunRuang {
    protected double tinggiPrisma;

    public PrismaPersegi(double sisi, double tinggiPrisma) {
        super(sisi);
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public double hitungVolume() {
        return hitungLuas() * tinggiPrisma;
    }

    @Override
    public double hitungLuasPermukaan() {
        return 2 * hitungLuas() + 4 * sisi * tinggiPrisma;
    }


    @Override
    public String getNama() {
        return "Prisma Persegi";
    }
}
