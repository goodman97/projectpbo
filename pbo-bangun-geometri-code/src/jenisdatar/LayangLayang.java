package jenisdatar;
import interfaces.BangunDatar;

public class LayangLayang implements BangunDatar {
    private double d1;
    private double d2;
    private double sisi1;
    private double sisi2;
    private double sisi3;
    private double sisi4;

    public LayangLayang(double d1, double d2, double sisi1, double sisi2, double sisi3, double sisi4){
        this.d1 = d1;
        this.d2 = d2;
        this.sisi1 = sisi1;
        this.sisi2 = sisi2;
        this.sisi3 = sisi3;
        this.sisi4 = sisi4;
    }

    @Override
    public double hitungLuas(){
        return 1/2 * d1 * d2;
    }

    @Override
    public double hitungKeliling(){
        return sisi1 + sisi2 + sisi3 + sisi4;
    }
}