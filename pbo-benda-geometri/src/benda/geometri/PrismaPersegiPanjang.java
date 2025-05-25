package benda.geometri;

public class PrismaPersegiPanjang extends PersegiPanjang implements BangunRuang {
    protected double tinggiPrisma;
    protected double volume;
    protected double luasPermukaan;

    public PrismaPersegiPanjang(double panjang, double lebar, double tinggiPrisma) {
        super(panjang, lebar);
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        
    }

    @Override
    public double hitungVolume() {
        return hitungLuas() * tinggiPrisma;
    }

    @Override
    public double hitungLuasPermukaan() {
        return 2 * hitungLuas() + 2 * (panjang + lebar) * tinggiPrisma;
    }

    public double getVolumePrismaPersegiPanjang() {
        return hitungVolume();
    }

    public double getLuasPermukaanPrismaPersegiPanjang() {
        return hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Prisma Persegi Panjang";
    }
}