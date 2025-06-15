package benda.geometri;

public class Trapesium extends BangunDatar{
    protected double atas;
    protected double bawah;
    protected double tinggi;
    protected double sisiMiring;
    protected double luas;
    protected double keliling;

    public Trapesium(double atas, double bawah, double tinggi, double sisiMiring) {
        this.atas = atas;
        this.bawah = bawah;
        this.tinggi = tinggi;
        this.sisiMiring = sisiMiring;
    }
    
    @Override
    public String getNama() {
        return "Trapesium";
    }    

    public double hitungLuas() {
        return luas ;
    }    

    public double hitungKeliling() {
        return keliling ;
    }    
}