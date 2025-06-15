package benda.geometri;

public class JuringLingkaran extends Lingkaran{
    protected double sudut;
    protected double luas;
    protected double keliling;
    protected double panjangBusur;
    
    public JuringLingkaran(double jariJari, double sudut) {
        super(jariJari);
        this.sudut = sudut;
    }
    
    @Override
    public String getNama() {
        return "Juring Lingkaran";
    }

    @Override
    public double hitungLuas() {
        luas = (sudut / 360.0) * super.luas;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        panjangBusur = (sudut / 360.0) * super.keliling;
        keliling = 2 * jariJari + panjangBusur;
        return keliling;
    }
}
