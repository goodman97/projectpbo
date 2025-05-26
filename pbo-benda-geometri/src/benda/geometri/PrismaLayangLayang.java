package benda.geometri;

public class PrismaLayangLayang extends LayangLayang{
    protected double tinggiPrisma;
    protected double volume;
    protected double luasPermukaan;

    public PrismaLayangLayang(double diagonal1, double diagonal2, double sisiPanjang, double sisiPendek, double tinggiPrisma) {
        super(diagonal1, diagonal2, sisiPanjang, sisiPendek);
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Prisma Layang-Layang";
    }
    
    public double hitungVolume() {
        return hitungLuas() * tinggiPrisma;
    }

    public double hitungLuasPermukaan() {
        return 2 * hitungLuas() + 2 * (sisiPanjang + sisiPendek) * tinggiPrisma;
    }
}
