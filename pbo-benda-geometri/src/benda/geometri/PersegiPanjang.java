package benda.geometri;

public class PersegiPanjang implements BangunDatar {
    protected double panjang;
    protected double lebar;

    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    public double hitungLuas() {
        return panjang * lebar;
    }



    @Override
    public double hitungKeliling() {
        return 2 * (panjang + lebar);
    }

    @Override
    public String getNama() {
        return "Persegi Panjang";
    }
}
