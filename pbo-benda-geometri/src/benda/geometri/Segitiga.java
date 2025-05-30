package benda.geometri;

public class Segitiga extends BangunDatar {
    protected double alas;
    protected double tinggi;
    protected double luas;
    protected double keliling;

    public Segitiga(double alas, double tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    @Override
    public String getNama() {
        return "Segitiga";
    }

    @Override
    public double hitungLuas() {
        luas =  0.5 * alas * tinggi;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        double sisiMiring = Math.sqrt(Math.pow(alas / 2, 2) + Math.pow(tinggi, 2));
        keliling = alas + 2 * sisiMiring;
        return keliling;
    }
}