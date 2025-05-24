package benda.geometri;

public class PrismaPersegiPanjang extends PersegiPanjang implements BangunRuang {
    protected double tinggiPrisma;

    public PrismaPersegiPanjang(double panjang, double lebar, double tinggiPrisma) {
        super(panjang, lebar);
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public double hitungVolume() {
        return hitungLuas() * tinggiPrisma;
    }

    @Override
    public double hitungLuasPermukaan() {
        return 2 * hitungLuas() + 2 * (panjang + lebar) * tinggiPrisma;
    }


    @Override
    public String getNama() {
        return "Prisma Persegi Panjang";
    }
}
