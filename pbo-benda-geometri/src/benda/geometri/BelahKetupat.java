package benda.geometri;

public class BelahKetupat implements BendaGeometri{
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
    public String getNama() {
        return "Belah Ketupat";
    }
    
    public double hitungLuas() {
        luas = 0.5 * diagonal1 * diagonal2;
        return luas;
    }
    
    public double hitungKeliling() {
        keliling = sisi * 4;
        return keliling;
    }    
}