package benda.geometri;

public class LayangLayang extends BangunDatar{
    protected double diagonal1;
    protected double diagonal2;
    protected double sisiPanjang;
    protected double sisiPendek;
    protected double luas;
    protected double keliling;

    public LayangLayang(double diagonal1, double diagonal2, double sisiPanjang, double sisiPendek) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisiPanjang = sisiPanjang;
        this.sisiPendek = sisiPendek;
    }

    @Override
    public String getNama() {
        return "Layang-Layang";
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