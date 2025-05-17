package jenisdatar;
import interfaces.BangunDatar;

public class PersegiPanjang implements BangunDatar{
    private double panjang;
    private double lebar;

    
    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    public double hitungLuas() {
        return  panjang * lebar;
    }

    @Override
    public double hitungKeliling() {
        return 2 * (panjang + lebar);
    }   
}