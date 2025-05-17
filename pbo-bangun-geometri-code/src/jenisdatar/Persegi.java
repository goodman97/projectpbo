package jenisdatar;
import interfaces.BangunDatar;

public class Persegi implements BangunDatar{
    private double sisi;

    
    public Persegi(double sisi) {
        this.sisi = sisi;
    }

    @Override
    public double hitungLuas() {
        return  Math.pow(sisi, 2);
    }

    @Override
    public double hitungKeliling() {
        return 4 * sisi;
    }   
}