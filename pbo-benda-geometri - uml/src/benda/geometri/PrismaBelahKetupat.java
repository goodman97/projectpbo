package benda.geometri;

public class PrismaBelahKetupat extends BelahKetupat{
    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;
    

    public PrismaBelahKetupat(double tinggiPrisma, double diagonal1, double diagonal2, double sisi) {
        super(diagonal1, diagonal2, sisi);
        this.tinggiPrisma = tinggiPrisma;
    }
    
    @Override
    public String getNama() {
        return "Prisma Belah Ketupat";
    }

    public double hitungVolume() {
        return volume; 
    }

    public double hitungLuasPermukaan() {
        return luasPermukaan;
    }
}