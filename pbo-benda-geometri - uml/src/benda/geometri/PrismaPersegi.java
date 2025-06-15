package benda.geometri;

public class PrismaPersegi extends Persegi{
    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    public PrismaPersegi(double sisi, double tinggiPrisma) {
        super(sisi);
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public String getNama() {
        return "Prisma Persegi";
    }

    public double hitungVolume() {
        return volume;
    }

    public double hitungLuasPermukaan() {
        return luasPermukaan;
    }
}
