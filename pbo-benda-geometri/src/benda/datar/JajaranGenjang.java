package benda.datar;

import benda.geometri.BangunDatar;

public class JajaranGenjang extends BangunDatar{
    protected double alas;
    protected double tinggi;
    protected double sisiMiring;
    protected double luas;
    protected double keliling;
    
    public JajaranGenjang(double alas, double tinggi, double sisiMiring) {
        this.alas = alas;
        this.tinggi = tinggi;
        this.sisiMiring = sisiMiring;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    @Override
    public String getNama() {
        return "Jajaran Genjang";
    }
    
    @Override
    public double hitungLuas() {
        luas = alas * tinggi;
        return luas;
    }
    
    @Override
    public double hitungKeliling() {
        keliling = alas * 2 + sisiMiring * 2;
        return keliling;
    }
    
}
