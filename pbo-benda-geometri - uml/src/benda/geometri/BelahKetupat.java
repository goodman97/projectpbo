package benda.geometri;

public class BelahKetupat extends BangunDatar{
    protected double diagonal1;
    protected double diagonal2;
    protected double sisi;
    protected double luas;
    protected double keliling;
    
    public BelahKetupat(double diagonal1, double diagonal2, double sisi) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisi = sisi;
    }
    
    @Override
    public String getNama() {
        return "Belah Ketupat";
    }
    
    public double hitungLuas() {
        return luas;
    }
    
    public double hitungKeliling() {
        return keliling;
    }
}