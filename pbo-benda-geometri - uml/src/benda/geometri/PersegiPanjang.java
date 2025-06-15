package benda.geometri;

public class PersegiPanjang extends BangunDatar{
    protected double panjang;
    protected double lebar;
    protected double luas;
    protected double keliling;

    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    public String getNama() {
        return "Persegi Panjang";
    }

    @Override
    public double hitungLuas() {
        return luas;
    }

    @Override
    public double hitungKeliling() {
        return keliling;
    }
}
