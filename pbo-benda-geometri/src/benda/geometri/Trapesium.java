package benda.geometri;

public class Trapesium implements BendaGeometri{
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
        luas = (atas + bawah)/2 * tinggi;
        return luas ;
    }    

    public double hitungKeliling() {
        keliling =  atas + bawah + (2 * sisiMiring);
        return keliling ;
    }    
}