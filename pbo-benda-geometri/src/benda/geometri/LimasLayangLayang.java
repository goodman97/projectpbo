package benda.geometri;

public class LimasLayangLayang extends LayangLayang implements BangunRuang {
    protected double tinggiLimas;
    protected double volume;
    protected double luasPermukaan;

    public LimasLayangLayang(double diagonal1, double diagonal2, double sisiPanjang, double sisiPendek, double tinggiLimas) {
        super(diagonal1, diagonal2, sisiPanjang, sisiPendek);
        this.tinggiLimas = tinggiLimas;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }

    @Override
    public double hitungVolume() {
        return (1.0 / 3.0) * hitungLuas() * tinggiLimas;
    }

    @Override
    public double hitungLuasPermukaan() {
        double luasTegakPanjang = 0.5 * sisiPanjang * tinggiLimas;
        double luasTegakPendek = 0.5 * sisiPendek * tinggiLimas;
        return hitungLuas() + 2 * luasTegakPanjang + 2 * luasTegakPendek;
    }
    @Override
    public String getNama() {
        return "Limas Layang-Layang";
    }
}
