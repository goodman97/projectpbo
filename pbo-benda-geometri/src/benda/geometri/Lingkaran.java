package benda.geometri;

public class Lingkaran implements BangunDatar{
    protected double jariJari;
    
    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    @Override
    public double hitungLuas() {
        return Math.PI * Math.pow(jariJari, 2);
    }

    public double getLuasLingkaran(){
        return hitungLuas();
    }
    
    @Override
    public double hitungKeliling() {
        return Math.PI * jariJari * 2;
    }
    

    @Override
    public String getNama() {
        return "Lingkaran";
    }
    
}
