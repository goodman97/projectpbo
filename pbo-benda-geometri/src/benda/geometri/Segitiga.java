package benda.geometri;

public class Segitiga extends BangunDatar {
    protected double alas;
    protected double tinggiSegitiga;
    protected double luas;
    protected double keliling;

    public Segitiga(double alas, double tinggiSegitiga) {
        this.alas = alas;
        this.tinggiSegitiga = tinggiSegitiga;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    @Override
    public String getNama() {
        return "Segitiga";
    }

    public double hitungLuas() {
        luas =  0.5 * alas * tinggiSegitiga;
        return luas;
    }

    public double hitungKeliling() {
        double sisiMiring = Math.sqrt(Math.pow(alas / 2, 2) + Math.pow(tinggiSegitiga, 2));
        keliling = alas + 2 * sisiMiring;
        return keliling;
    }
}