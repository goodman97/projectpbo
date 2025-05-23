package benda.geometri;

public class LayangLayang implements BangunDatar {
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
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    @Override
    public String getNama() {
        return "Layang-Layang";
    }
    
    @Override
    public double hitungLuas() {
        return 0.5 * diagonal1 * diagonal2;
    }

    @Override
    public double hitungKeliling() {
        return 2 * (sisiPanjang + sisiPendek);
    }    
}