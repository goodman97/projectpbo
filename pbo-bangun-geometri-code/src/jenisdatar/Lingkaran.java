package jenisdatar;
import interfaces.BangunDatar;

public class Lingkaran implements BangunDatar{
    private double jariJari;
    protected static final double PHI = 3.14;

    public Lingkaran(double jariJari){
        this.jariJari = jariJari;
    }

    @Override
    public double hitungLuas(){
        return PHI * jariJari;
    }
    
    @Override
    public double hitungKeliling(){
        return 2 * PHI * jariJari;
    }
}
