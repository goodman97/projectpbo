package benda.geometri;

public class TemberengLingkaran extends JuringLingkaran {
    protected double taliBusur;
    protected double luas;
    protected double keliling;

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
        double sudutRad = Math.toRadians(sudut);
        double luasJuring = (sudutRad / 2) * Math.pow(jariJari, 2);
        double luasSegitiga = 0.5 * Math.pow(jariJari, 2) * Math.sin(sudutRad);
        luas = luasJuring - luasSegitiga;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        keliling = super.panjangBusur + taliBusur;
        return keliling;
    }    
}
