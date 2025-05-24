package benda.geometri;

public class PrismaSegitiga extends Segitiga implements BangunRuang {
    protected double tinggiPrisma;

    public PrismaSegitiga(double alas, double tinggiSegitiga, double tinggiPrisma) {
        super(alas, tinggiSegitiga);
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public double hitungVolume() {
        return hitungLuas() * tinggiPrisma;
    }

    @Override
    public double hitungLuasPermukaan() {
        double sisiMiring = Math.sqrt(Math.pow(alas / 2, 2) + Math.pow(tinggi, 2));
        return 2 * hitungLuas() + (alas + 2 * sisiMiring) * tinggiPrisma;
    }



    @Override
    public String getNama() {
        return "Prisma Segitiga";
    }
}
