package benda.geometri;

public class JuringLingkaran extends Lingkaran{
    protected double sudut;
    protected double luas;
    protected double keliling;
    
    public JuringLingkaran(double jariJari, double sudut) {
        super(jariJari);
        this.sudut = sudut;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }
    
    @Override
    public String getNama() {
        return "Juring Lingkaran";
    }

    @Override
    public double hitungLuas() {
        return (sudut / 360.0) * Math.PI * Math.pow(jariJari, 2);
    }

    @Override
    public double hitungKeliling() {
        double panjangBusur = (sudut / 360.0) * 2 * Math.PI * jariJari;
        return 2 * jariJari + panjangBusur;
    }
}
