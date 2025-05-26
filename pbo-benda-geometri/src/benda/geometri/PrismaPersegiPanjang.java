package benda.geometri;

public class PrismaPersegiPanjang extends PersegiPanjang implements BangunRuang {
    protected double tinggiPrisma;
    protected double volume;
    protected double luasPermukaan;

    public PrismaPersegiPanjang(double panjang, double lebar, double tinggiPrisma) {
        super(panjang, lebar);
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public double hitungVolume() {
        volume = hitungLuas() * tinggiPrisma;
        return volume;
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaan = 2 * hitungLuas() + 2 * (panjang + lebar) * tinggiPrisma;
        return luasPermukaan;
    }

    @Override
    public String getNama() {
        return "Prisma Persegi Panjang";
    }
}