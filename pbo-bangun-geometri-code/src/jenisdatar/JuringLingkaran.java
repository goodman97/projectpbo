package jenisdatar;
import interfaces.BangunDatar;

public class JuringLingkaran {
    private double sudut;

    public JuringLingkaran
(double sudut){
        this.sudut = sudut;
    }

    public double hitungLuas(){
        return sudut/360 * hitungLuas();
    }
}
