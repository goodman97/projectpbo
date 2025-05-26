package benda.geometri;

public class LimasPersegiPanjang extends PersegiPanjang{
    protected double tinggiLimas;

    public LimasPersegiPanjang(double panjang, double lebar, double tinggiLimas) {
        super(panjang, lebar);
        this.tinggiLimas = tinggiLimas;
    }

    @Override
    public String getNama() {
        return "Limas Persegi Panjang";
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * hitungLuas() * tinggiLimas;
    }

    public double hitungLuasPermukaan() {
        double luasSegitigaPanjang = 0.5 * panjang * Math.sqrt(Math.pow(lebar / 2, 2) + Math.pow(tinggiLimas, 2));
        double luasSegitigaLebar = 0.5 * lebar * Math.sqrt(Math.pow(panjang / 2, 2) + Math.pow(tinggiLimas, 2));
        return hitungLuas() + 2 * luasSegitigaPanjang + 2 * luasSegitigaLebar;
    }    
}
