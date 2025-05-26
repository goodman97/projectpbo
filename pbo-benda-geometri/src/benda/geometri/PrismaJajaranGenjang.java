package benda.geometri;

public class PrismaJajaranGenjang extends JajaranGenjang{
    protected double tinggiPrisma;

    public PrismaJajaranGenjang(double alas, double tinggiAlas, double sisiMiring, double tinggiPrisma) {
        super(alas, tinggiAlas, sisiMiring);
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public String getNama() {
        return "Prisma Jajaran Genjang";
    }
    
    public double hitungVolume() {
        return hitungLuas() * tinggiPrisma;
    }

    public double hitungLuasPermukaan() {
        return 2 * hitungLuas() + 2 * (alas + sisiMiring) * tinggiPrisma;
    }
}
