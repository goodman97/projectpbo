package benda.geometri;

public class PrismaBelahKetupat extends BelahKetupat{
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
    public String getNama() {
        return "Prisma Belah Ketupat";
    }

    public double hitungVolume() {
        return super.hitungLuas() * tinggiPrisma;
    }
   
    public double hitungLuasPermukaan() {
        return (super.hitungLuas()*2) + (sisi * tinggiPrisma) * 4;
    }    
}
