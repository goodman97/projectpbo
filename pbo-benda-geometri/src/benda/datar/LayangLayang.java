package benda.datar;

import benda.geometri.BangunDatar;

public class LayangLayang extends BangunDatar{
    protected double diagonal1;
    protected double diagonal2;
    protected double sisiPanjang;
    protected double sisiPendek;
    protected double luas;
    protected double keliling;

    public LayangLayang(double diagonal1, double diagonal2, double sisiPanjang, double sisiPendek) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisiPanjang = sisiPanjang;
        this.sisiPendek = sisiPendek;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    @Override
    public String getNama() {
        return "Layang-Layang";
    }
    
    @Override
    public double hitungLuas() {
        luas = 0.5 * diagonal1 * diagonal2;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        keliling =  2 * (sisiPanjang + sisiPendek);
        return keliling;
    }    
}