package benda.geometri;

public class TemberengLingkaran extends JuringLingkaran{
    private double taliBusur;
    private double luas;
    private double keliling;

    public TemberengLingkaran(double jariJari, double sudut) {
        super(jariJari, sudut);
        double sudutRad = Math.toRadians(sudut);
        this.taliBusur = 2 * jariJari * Math.sin(sudutRad / 2);
    }

    @Override
    public String getNama() {
        return "Tembereng Lingkaran";
    }

    @Override
    public double hitungLuas() {
        return luas;
    }

    @Override
    public double hitungKeliling() {
        return keliling;
    }
}
