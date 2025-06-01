package benda.ruang;

import benda.datar.Persegi;

public class PrismaPersegi extends Persegi{
    protected double tinggiPrisma;
    protected double volume;
    protected double luasPermukaan;

    public PrismaPersegi(double sisi, double tinggiPrisma) {
        super(sisi);
        this.tinggiPrisma = tinggiPrisma;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public String getNama() {
        return "Prisma Persegi";
    }

    public double hitungVolume() {
        volume = super.luas * tinggiPrisma;
        return volume;
    }

    public double hitungVolume(double newSisi, double tinggiPrisma) {
        volume = Math.pow(newSisi, 2) * tinggiPrisma;
        return volume;
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = 2 * super.luas + 4 * sisi * tinggiPrisma;
        return luasPermukaan;
    }

    public double hitungLuasPermukaan(double newSisi, double tinggiPrisma) {
        luasPermukaan = 4 * (newSisi * tinggiPrisma) + 2 * (Math.pow(newSisi, 2));
        return luasPermukaan;
    }
}
