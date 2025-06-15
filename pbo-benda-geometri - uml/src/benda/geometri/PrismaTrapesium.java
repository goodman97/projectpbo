package benda.geometri;

public class PrismaTrapesium extends Trapesium {
    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    public PrismaTrapesium(double atas, double bawah, double tinggiAlas, double sisiMiring, double tinggiPrisma) {
        super(atas, bawah, tinggiAlas, sisiMiring);
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public String getNama() {
        return "Prisma Trapesium";
    }

    public double hitungVolume() {
        return volume;
    }

    public double hitungLuasPermukaan() {
        return luasPermukaan;
    }
}
