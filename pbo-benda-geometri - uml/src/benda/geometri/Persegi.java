package benda.geometri;

public class Persegi extends BangunDatar{
    protected double sisi;
    protected double luas;
    protected double keliling;

    public Persegi(double sisi) {
        this.sisi = sisi;
    }
    
    @Override
    public String getNama() {
        return "Persegi";
    }

    @Override
    public double hitungLuas() {
        return keliling;
    }

    @Override
    public double hitungKeliling() {
        return luas;
    }
}