package jenisdatar;
import interfaces.BangunDatar;

public class BelahKetupat implements BangunDatar {
    private double sisi;
    private double d1;
    private double d2;

    public BelahKetupat(double sisi, double d1, double d2){
        this.sisi = sisi;
        this.d1 = d1;
        this.d2 = d2;
    }
    
    @Override
    public double hitungLuas(){
        return (d1 * d2) / 2;
    }

    @Override
    public double hitungKeliling(){
        return 4 * sisi ;
    }
}