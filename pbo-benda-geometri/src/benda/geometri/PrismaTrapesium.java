package benda.geometri;

public class PrismaTrapesium extends Trapesium {
    protected double tinggiPrisma;
    protected double volume;
    protected double luasPermukaan;

    public PrismaTrapesium(double atas, double bawah, double tinggiAlas, double sisiMiring, double tinggiPrisma) {
        super(atas, bawah, tinggiAlas, sisiMiring);
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public String getNama() {
        return "Prisma Trapesium";
    }

    public double hitungVolume() {
        return hitungLuas() * tinggiPrisma;
    }

    public double hitungLuasPermukaan() {
        return 2 * hitungLuas() + hitungKeliling() * tinggiPrisma;
    }
}
