package jenisdatar;
import interfaces.BangunDatar;

public class Trapesium implements BangunDatar{
    private double atas;
    private double bawah;
    private double tinggi;
    private double sisiMiring;

    public Trapesium(double atas, double bawah, double tinggi, double sisiMiring){
        this.atas = atas;
        this.bawah = bawah;
        this.tinggi = tinggi;
        this.sisiMiring = sisiMiring;
    }
    
    @Override
    public double hitungLuas(){
        return 0.5 * (atas + bawah) * tinggi;
    }

    @Override
    public double hitungKeliling(){
        return atas + bawah + (2 * sisiMiring);
    }
}
