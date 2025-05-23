package benda.geometri;

public class Persegi implements BangunDatar {
    protected double sisi;

    public Persegi(double sisi) {
        this.sisi = sisi;
    }

    @Override
    public double hitungLuas() {
        return sisi * sisi;
    }

    public double getLuasPersegi() {
        return hitungLuas();
    }

    @Override
    public double hitungKeliling() {
        return 4 * sisi;
    }

    public double getKelilingPersegi() {
        return hitungKeliling();
    }

    @Override
    public String getNama() {
        return "Persegi";
    }
}