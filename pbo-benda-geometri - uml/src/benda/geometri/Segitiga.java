package benda.geometri;

public class Segitiga extends BangunDatar {
    protected double alas;
    protected double tinggiSegitiga;
    protected double luas;
    protected double keliling;

    public Segitiga(double alas, double tinggiSegitiga) {
        this.alas = alas;
        this.tinggiSegitiga = tinggiSegitiga;
    }

    @Override
    public String getNama() {
        return "Segitiga";
    }

    public double hitungLuas() {
        return luas;
    }

    public double hitungKeliling() {
        return keliling;
    }
}