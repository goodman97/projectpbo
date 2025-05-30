package benda.geometri;

public class Lingkaran extends BangunDatar {
    protected double jariJari;
    protected double luas;
    protected double keliling;

    public Lingkaran(double jariJari) {
        if (jariJari <= 0) {
            throw new IllegalArgumentException("❌ Jari-jari harus lebih dari nol.");
        }
        this.jariJari = jariJari;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    @Override
    public String getNama() {
        return "Lingkaran";
    }

    @Override
    public double hitungLuas() {
        this.luas = Math.PI * Math.pow(jariJari, 2);
        return this.luas;
    }

    public double hitungLuas(double newJariJari) {
        return Math.PI * Math.pow(newJariJari, 2);
    }

    @Override
    public double hitungKeliling() {
        this.keliling = 2 * Math.PI * jariJari;
        return this.keliling;
    }

    public double hitungKeliling(double newJariJari) {
        return 2 * Math.PI * newJariJari;
    }
}