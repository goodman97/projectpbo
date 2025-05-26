package benda.geometri;

public class PrismaPersegi extends Persegi{
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
    public String getNama() {
        return "Prisma Persegi";
    }

    public double hitungVolume() {
        return hitungLuas() * tinggiPrisma;
    }

    public double hitungLuasPermukaan() {
        return 2 * hitungLuas() + 4 * sisi * tinggiPrisma;
    }
}
