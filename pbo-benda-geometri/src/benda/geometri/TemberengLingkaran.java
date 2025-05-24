package benda.geometri;

public class TemberengLingkaran extends JuringLingkaran {
    protected double taliBusur;

    public TemberengLingkaran(double jariJari, double sudut) {
        super(jariJari, sudut);
        double sudutRad = Math.toRadians(sudut);
        this.taliBusur = 2 * jariJari * Math.sin(sudutRad / 2); // dihitung sekali di awal
    }



    @Override
    public double hitungLuas() {
        double sudutRad = Math.toRadians(sudut);
        double luasJuring = (sudutRad / 2) * Math.pow(jariJari, 2);
        double luasSegitiga = 0.5 * Math.pow(jariJari, 2) * Math.sin(sudutRad);
        return luasJuring - luasSegitiga;
    }

    @Override
    public double hitungKeliling() {
        double sudutRad = Math.toRadians(sudut);
        double panjangBusur = sudutRad * jariJari;
        return panjangBusur + taliBusur;
    }

    @Override
    public String getNama() {
        return "Tembereng Lingkaran";
    }
}
