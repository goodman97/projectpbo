package benda.geometri;

public class PrismaSegitiga extends Segitiga{
    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    public PrismaSegitiga(double alas, double tinggiSegitiga, double tinggiPrisma) {
        super(alas, tinggiSegitiga);
        this.tinggiPrisma = tinggiPrisma;
    }
   
    @Override
    public String getNama() {
        return "Prisma Segitiga";
    }

    public double hitungVolume() {
        return  volume;
    }
    public double hitungLuasPermukaan() {
        return luasPermukaan;
    }
}
