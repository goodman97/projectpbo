package benda.geometri;

public class BelahKetupat implements BangunDatar{
    protected double diagonal1;
    protected double diagonal2;
    protected double sisi;
    protected double luas;
    protected double keliling;
    
    public BelahKetupat(double diagonal1, double diagonal2, double sisi) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisi = sisi;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }
    
    @Override
    public double hitungLuas() {
        return 0.5 * diagonal1 * diagonal2;
    }
    
    @Override
    public double hitungKeliling() {
        return sisi * 4;
    }
    
    @Override
    public String getNama() {
        return "Belah Ketupat";
    }    
}