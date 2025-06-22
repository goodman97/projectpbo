package ruang;

import datar.PersegiPanjang;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LimasPersegiPanjang extends PersegiPanjang  {
    private double tinggiLimas;
    private double volume;
    private double luasPermukaan;

    public LimasPersegiPanjang(double panjang, double lebar, double tinggiLimas) {
        super(panjang, lebar);
        this.tinggiLimas = tinggiLimas;
    }

    @Override
    public String getNama() {
        return "Limas Persegi Panjang";
    }

    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.luas * tinggiLimas;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double luasSegitigaPanjang = 0.5 * panjang * Math.sqrt(Math.pow(lebar / 2, 2) + Math.pow(tinggiLimas, 2));
        double luasSegitigaLebar = 0.5 * lebar * Math.sqrt(Math.pow(panjang / 2, 2) + Math.pow(tinggiLimas, 2));
        luasPermukaan = super.luas + 2 * luasSegitigaPanjang + 2 * luasSegitigaLebar;
        return luasPermukaan;
    }    

    public double hitungVolume(double newPanjang, double newLebar, double newTinggiLimas) {
        volume = (1.0 / 3.0) * newPanjang * newLebar * newTinggiLimas;
        return volume; 
    }

    public double hitungLuasPermukaan(double newPanjang, double newLebar, double newTinggiLimas) {
        double luasSegitigaPanjang = 0.5 * newPanjang * Math.sqrt(Math.pow(newLebar / 2, 2) + Math.pow(newTinggiLimas, 2));
        double luasSegitigaLebar = 0.5 * newLebar * Math.sqrt(Math.pow(newPanjang / 2, 2) + Math.pow(newTinggiLimas, 2));
        luasPermukaan = newPanjang * newLebar + 2 * luasSegitigaPanjang + 2 * luasSegitigaLebar;
        return luasPermukaan;
    }   

    public void prosesInputDanValidasi() {
    Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai panjang, lebar, dan tinggi? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan panjang baru: ");
                        double newPanjang = inp.nextDouble();
                        System.out.print("Masukkan lebar baru: ");
                        double newLebar = inp.nextDouble();
                        System.out.print("Masukkan tinggi baru: ");
                        double newTinggiLimas = inp.nextDouble();
                        inp.nextLine();

                        if (newPanjang <= 0 || newLebar <= 0 || newTinggiLimas <= 0) {
                            System.out.println("Panjang, lebar, dan tinggi harus lebih dari nol.\n");
                            continue;
                        }
                        volume = hitungVolume(newPanjang, newLebar, newTinggiLimas);
                        luasPermukaan = hitungLuasPermukaan(newPanjang, newLebar, newTinggiLimas);
                        System.out.printf("\nVolume Limas Baru: %.2f\n", volume);
                        System.out.printf("Luas Permukaan Limas Baru: %.2f\n", luasPermukaan);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid. Silakan masukkan angka yang benar.");
                        inp.nextLine(); // Clear the invalid input
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan masukkan Y atau N.");
            }
        }
    }
    
    public double getTinggiLimas() {
        return tinggiLimas;
    }

}