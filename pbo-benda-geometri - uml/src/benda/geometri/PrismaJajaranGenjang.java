package benda.geometri;

public class PrismaJajaranGenjang extends JajaranGenjang{
    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    public PrismaJajaranGenjang(double alas, double tinggiAlas, double sisiMiring, double tinggiPrisma) {
        super(alas, tinggiAlas, sisiMiring);
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public String getNama() {
        return "Prisma Jajaran Genjang";
    }
    
    public double hitungVolume() {
        return volume;
    }

    public double hitungLuasPermukaan() {
        return luasPermukaan;
    }
}
