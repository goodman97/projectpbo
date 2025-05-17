package jenisdatar;
import interfaces.BangunDatar;

public class Segitiga implements BangunDatar{
    private double alas;
    private double tinggi;

    
    public Segitiga(double alas, double tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    @Override
    public double hitungLuas() {
        return  0.5 * alas * tinggi;
    }

    @Override
    public double hitungKeliling() {
        return 3 * alas;
    }   
}