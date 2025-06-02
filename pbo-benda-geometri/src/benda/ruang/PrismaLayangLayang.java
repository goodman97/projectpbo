package benda.ruang;

import benda.datar.LayangLayang;

public class PrismaLayangLayang extends LayangLayang{
    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    public PrismaLayangLayang(double diagonal1, double diagonal2, double sisiPanjang, double sisiPendek, double tinggiPrisma) {
        super(diagonal1, diagonal2, sisiPanjang, sisiPendek);
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public String getNama() {
        return "Prisma Layang-Layang";
    }
    
    public double hitungVolume() {
        volume = super.luas * tinggiPrisma;
        return volume;
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = 2 * super.luas + 2 * (sisiPanjang + sisiPendek) * tinggiPrisma;
        return luasPermukaan;
    }


}