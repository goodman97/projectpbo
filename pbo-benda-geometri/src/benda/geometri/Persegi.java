package benda.geometri;

public class Persegi implements BangunDatar {
    protected double sisi;

    public Persegi(double sisi) {
        this.sisi = sisi;
    }

    @Override
    public double hitungLuas() {
        return sisi * sisi;
    }



    @Override
    public double hitungKeliling() {
        return 4 * sisi;
    }


    @Override
    public String getNama() {
        return "Persegi";
    }
}
