package benda.geometri;

public class Persegi implements BendaGeometri {
    protected double sisi;
    protected double luas;
    protected double keliling;

    public Persegi(double sisi) {
        this.sisi = sisi;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }
    
    @Override
    public String getNama() {
        return "Persegi";
    }

    @Override
    public double hitungLuas() {
        keliling =  sisi * sisi;
        return keliling;
    }

    @Override
    public double hitungKeliling() {
        luas = 4 * sisi;
        return luas;
    }
}