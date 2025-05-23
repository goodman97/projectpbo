package benda.geometri;

public class PrismaLayangLayang extends LayangLayang implements BangunRuang {
    protected double tinggiPrisma;

    public PrismaLayangLayang(double diagonal1, double diagonal2, double sisiPanjang, double sisiPendek, double tinggiPrisma) {
        super(diagonal1, diagonal2, sisiPanjang, sisiPendek);
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public double hitungVolume() {
        return hitungLuas() * tinggiPrisma;
    }

    @Override
    public double hitungLuasPermukaan() {
        return 2 * hitungLuas() + 2 * (sisiPanjang + sisiPendek) * tinggiPrisma;
    }

    public double getVolumePrismaLayangLayang() {
        return hitungVolume();
    }

    public double getLuasPermukaanPrismaLayangLayang() {
        return hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Prisma Layang-Layang";
    }
}