package benda.geometri;

public class PrismaBelahKetupat extends BelahKetupat implements BangunRuang{
    protected double tinggiPrisma;
    protected double volume;
    protected double luasPermukaan;
    

    public PrismaBelahKetupat(double tinggiPrisma, double diagonal1, double diagonal2, double sisi) {
        super(diagonal1, diagonal2, sisi);
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }
    
    @Override
    public double hitungVolume() {
        return super.hitungLuas() * tinggiPrisma;
    }

    
    @Override
    public double hitungLuasPermukaan() {
        return (super.hitungLuas()*2) + (sisi * tinggiPrisma) * 4;
    }


    
    @Override
    public String getNama() {
        return "Prisma Belah Ketupat";
    }
    
    
}
