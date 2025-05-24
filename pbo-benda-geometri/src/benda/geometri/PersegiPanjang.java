package benda.geometri;

public class PersegiPanjang implements BangunDatar {
    protected double panjang;
    protected double lebar;
    protected double luas;
    protected double keliling;

    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
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
