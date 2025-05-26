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
        return hitungLuas() * tinggiPrisma;
    }

    public double hitungLuasPermukaan() {
        return 2 * hitungLuas() + 2 * (panjang + lebar) * tinggiPrisma;
    }    
}
