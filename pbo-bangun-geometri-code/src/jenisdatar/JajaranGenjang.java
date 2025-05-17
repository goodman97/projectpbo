package jenisdatar;
import interfaces.BangunDatar;

public class JajaranGenjang implements BangunDatar {
    private double alas;
    private double tinggi;
    private double sisiMiring;

    public JajaranGenjang(double alas, double tinggi, double sisiMiring){
        this.alas = alas;
        this.tinggi = tinggi;
        this.sisiMiring = sisiMiring;
    }
    
    @Override
    public double hitungLuas(){
        return alas * tinggi;
    }

    @Override
    public double hitungKeliling(){
        return 2 * (alas + sisiMiring);
    }
}