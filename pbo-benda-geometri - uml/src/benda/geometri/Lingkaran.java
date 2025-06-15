package benda.geometri;

public class Lingkaran extends BangunDatar {
    protected double jariJari;
    protected double luas;
    protected double keliling;

    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }
  
    @Override
    public String getNama() {
        return "Lingkaran";
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