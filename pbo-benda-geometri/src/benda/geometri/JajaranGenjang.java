package benda.geometri;

public class JajaranGenjang implements BangunDatar{
    protected double alas;
    protected double tinggi;
    protected double sisiMiring;
    protected double luas;
    protected double keliling;
    
    public JajaranGenjang(double alas, double tinggi, double sisiMiring) {
        this.alas = alas;
        this.tinggi = tinggi;
        this.sisiMiring = sisiMiring;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    @Override
    public String getNama() {
        return "Jajaran Genjang";
    }
    
    @Override
    public double hitungLuas() {
        return alas * tinggi;
    }
    
    @Override
    public double hitungKeliling() {
        return alas * 2 + sisiMiring * 2;
    }
    
}
