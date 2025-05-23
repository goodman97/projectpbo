package benda.geometri;

public class PrismaBelahKetupat extends BelahKetupat implements BangunRuang{
    private double tinggiPrisma;

    public PrismaBelahKetupat(double tinggiPrisma, double diagonal1, double diagonal2, double sisi) {
        super(diagonal1, diagonal2, sisi);
        this.tinggiPrisma = tinggiPrisma;
    }
    
    @Override
    public double hitungVolume() {
        return super.hitungLuas() * tinggiPrisma;
    }

    public double getVolumePrismaBelahKetupat(){
        return hitungVolume();
    }
    
    @Override
    public double hitungLuasPermukaan() {
        return (super.hitungLuas()*2) + (sisi * tinggiPrisma) * 4;
    }

    public double getLuasPermukaanBelahKetupat(){
        return hitungLuasPermukaan();
    }
    
    @Override
    public String getNama() {
        return "Prisma Belah Ketupat";
    }
    
    
}