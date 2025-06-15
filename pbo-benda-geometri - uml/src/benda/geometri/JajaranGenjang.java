package benda.geometri;

public class JajaranGenjang extends BangunDatar{
    protected double alas;
    protected double tinggi;
    protected double sisiMiring;
    protected double luas;
    protected double keliling;
    
    public JajaranGenjang(double alas, double tinggi, double sisiMiring) {
        this.alas = alas;
        this.tinggi = tinggi;
        this.sisiMiring = sisiMiring;
    }

    @Override
    public String getNama() {
        return "Jajaran Genjang";
    }
    
    @Override
    public double hitungLuas(){
        return luas;
    }
    
    @Override
    public double hitungKeliling(){
        return keliling;
    }
}
