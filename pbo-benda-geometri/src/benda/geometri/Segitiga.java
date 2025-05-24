package benda.geometri;

public class Segitiga implements BangunDatar {
    protected double alas;
    protected double tinggi;

    public Segitiga(double alas, double tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    @Override
    public double hitungLuas() {
        return 0.5 * alas * tinggi;
    }


    @Override
    public double hitungKeliling() {
        double sisiMiring = Math.sqrt(Math.pow(alas / 2, 2) + Math.pow(tinggi, 2));
        return alas + 2 * sisiMiring;
    }


    @Override
    public String getNama() {
        return "Segitiga";
    }
}
