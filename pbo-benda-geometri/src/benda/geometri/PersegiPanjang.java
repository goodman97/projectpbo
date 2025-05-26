package benda.geometri;

public class PersegiPanjang implements BendaGeometri {
    protected double panjang;
    protected double lebar;
    protected double luas;
    protected double keliling;

    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    @Override
    public String getNama() {
        return "Persegi Panjang";
    }

    @Override
    public double hitungLuas() {
        luas =  panjang * lebar;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        keliling = 2 * (panjang + lebar);
        return keliling;
    }
}
