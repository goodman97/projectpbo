package benda.geometri;

public class PrismaJajaranGenjang extends JajaranGenjang implements BangunRuang {
    protected double tinggiPrisma;

    public PrismaJajaranGenjang(double alas, double tinggiAlas, double sisiMiring, double tinggiPrisma) {
        super(alas, tinggiAlas, sisiMiring);
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public double hitungVolume() {
        return hitungLuas() * tinggiPrisma;
    }

    @Override
    public double hitungLuasPermukaan() {
        return 2 * hitungLuas() + 2 * (alas + sisiMiring) * tinggiPrisma;
    }

    public double getVolumePrismaJajaranGenjang() {
        return hitungVolume();
    }

    public double getLuasPermukaanPrismaJajaranGenjang() {
        return hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Prisma Jajaran Genjang";
    }
}