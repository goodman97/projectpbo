package benda.geometri;

public class PrismaPersegiPanjang extends PersegiPanjang{
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
    public String getNama() {
        return "Prisma Persegi Panjang";
    }

    public double hitungVolume() {
        volume = super.luas * tinggiPrisma;
        return volume;
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = 2 * super.luas + 2 * (panjang + lebar) * tinggiPrisma;
        return luasPermukaan;
    }
}