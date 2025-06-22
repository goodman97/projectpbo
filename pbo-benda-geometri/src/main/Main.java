package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import benda.datar.*;
import benda.ruang.*;

public class Main {
    public static void main(String[] args) {
        /*// Input semua nilai terlebih dahulu menggunakan polymorphism
        Lingkaran lingkaran = new Lingkaran(0);
        System.out.println("Input benda geometri: " + lingkaran.getNama());
        lingkaran.prosesInputDanValidasi();

        // Polymorphism - Bola extends Lingkaran
        Lingkaran bola = new Bola(lingkaran.getJariJari());
        System.out.println("\nInput benda geometri: " + bola.getNama());
        bola.prosesInputDanValidasi();

        Lingkaran juringBola = new JuringBola(bola.getJariJari(), 1);
        System.out.println("\nInput benda geometri: " + juringBola.getNama());
        juringBola.prosesInputDanValidasi();

        // Polymorphism - TemberengBola extends Lingkaran
        Lingkaran temberengBola = new TemberengBola(bola.getJariJari(), 1);
        System.out.println("\nInput benda geometri: " + temberengBola.getNama());
        temberengBola.prosesInputDanValidasi();*/

        Segitiga segitiga = new Segitiga(1, 1);
        System.out.println("\nInput benda geometri: " + segitiga.getNama());
        segitiga.prosesInputDanValidasi();
        System.out.println("Luas segitiga: " + segitiga.hitungLuas());
        System.out.println("Keliling segitiga: " + segitiga.hitungKeliling());
        
        LimasSegitiga limasSegitiga = new LimasSegitiga(segitiga.getAlas(), segitiga.getTinggiSegitiga(), 0);
        System.out.println("\nInput benda geometri: " + limasSegitiga.getNama());
        limasSegitiga.prosesInputDanValidasi();
        System.out.println("Volume limas segitiga: " + limasSegitiga.hitungVolume());
        System.out.println("Volume limas segitiga (mengubah alas dan tinggi segitiga): " + limasSegitiga.hitungVolume(limasSegitiga.getNewAlas(), limasSegitiga.getNewTinggiSegitiga(), limasSegitiga.getTinggiLimas()));
        System.out.println("Luas permukaan limas segitiga: " + limasSegitiga.hitungLuasPermukaan());
        System.out.println("Luas permukaan limas segitiga (mengubah alas dan tinggi segitiga): " + limasSegitiga.hitungLuasPermukaan(limasSegitiga.getNewAlas(), limasSegitiga.getNewTinggiSegitiga(), limasSegitiga.getTinggiLimas()));

        PrismaSegitiga prismaSegitiga = new PrismaSegitiga(segitiga.getAlas(), segitiga.getTinggiSegitiga(), 0);
        System.out.println("\nInput benda geometri: " + prismaSegitiga.getNama());
        prismaSegitiga.prosesInputDanValidasi();
        System.out.println("Volume prisma segitiga: " + prismaSegitiga.hitungVolume());
        System.out.println("Volume prisma segitiga (mengubah alas dan tinggi segitiga)" + prismaSegitiga.hitungVolume(prismaSegitiga.getNewAlas(), prismaSegitiga.getNewTinggiSegitiga(), prismaSegitiga.getTinggiPrisma()));
        System.out.println("Luas permukaan prisma segitiga: " + prismaSegitiga.hitungLuasPermukaan());
        System.out.println("Luas permukaan prisma segitiga (mengubah alas dan tinggi segitiga): " + prismaSegitiga.hitungLuasPermukaan(prismaSegitiga.getNewAlas(), prismaSegitiga.getNewTinggiSegitiga(), prismaSegitiga.getTinggiPrisma()));
        
        BelahKetupat belahKetupat = new BelahKetupat(1, 1);
        System.out.println("\nInput benda geometri: " + belahKetupat.getNama());
        belahKetupat.prosesInputDanValidasi();
        System.out.println("Luas belah ketupat: " + belahKetupat.hitungLuas());
        System.out.println("Keliling belah ketupat: " + belahKetupat.hitungKeliling());
        
        LimasBelahKetupat limasBelahKetupat = new LimasBelahKetupat(belahKetupat.getDiagonal1(), belahKetupat.getDiagonal2(), 0);
        System.out.println("\nInput benda geometri: " + limasBelahKetupat.getNama());
        limasBelahKetupat.prosesInputDanValidasi();
        limasBelahKetupat.hitungVolume();
        limasBelahKetupat.hitungVolume(0, 0, 0);
        limasBelahKetupat.hitungLuasPermukaan();
        limasBelahKetupat.hitungLuasPermukaan(0, 0, 0);
        
        PrismaBelahKetupat prismaBelahKetupat = new PrismaBelahKetupat(belahKetupat.getDiagonal1(), belahKetupat.getDiagonal2(), belahKetupat.getSisi());
        System.out.println("\nInput benda geometri: " + prismaBelahKetupat.getNama());
        prismaBelahKetupat.prosesInputDanValidasi(); 
        prismaBelahKetupat.hitungVolume(); 
        prismaBelahKetupat.hitungVolume(0, 0, 0); 
        prismaBelahKetupat.hitungLuasPermukaan(); 
        prismaBelahKetupat.hitungLuasPermukaan(0, 0, 0);
        /*
        // Persegi persegi = new Persegi (0);
        // System.out.println("\nInput benda geometri: " + persegi.getNama());
        // persegi.prosesInputDanValidasi();

        // LimasPersegi limasPersegi = new LimasPersegi(persegi.getSisi(), 1);
        // System.out.println("\nInput benda geometri: " + limasPersegi.getNama());
        // limasPersegi.prosesInputDanValidasi();

        // PersegiPanjang persegiPanjang = new PersegiPanjang(0, 0);
        // System.out.println("\nInput benda geometri: " + persegiPanjang.getNama());
        // persegiPanjang.prosesInputDanValidasi();

        // LimasPersegiPanjang limasPersegiPanjang = new LimasPersegiPanjang(persegiPanjang.getPanjang(), persegiPanjang.getLebar(), 0);
        // System.out.println("\nInput benda geometri: " + limasPersegiPanjang.getNama());
        // limasPersegiPanjang.prosesInputDanValidasi();
        
        // PrismaPersegiPanjang prismaPersegiPanjang = new PrismaPersegiPanjang(persegiPanjang.getPanjang(), persegiPanjang.getLebar(), 0);
        // System.out.println("\nInput benda geometri: " + prismaPersegiPanjang.getNama());
        // prismaPersegiPanjang.prosesInputDanValidasi();*/      

        /*Scanner scanner = new Scanner(System.in);
        List<Runnable> shapes = new ArrayList<>();

        Trapesium Trapesium = new Trapesium(0, 0,0);
        System.out.println("\nInput benda geometri: " + Trapesium.getNama());
        Trapesium.prosesInputDanValidasi();
        System.out.println("Luas :"+ Trapesium.hitungLuas());
        System.out.println("Keliling :"+ Trapesium.hitungKeliling());
        
        while (true) {
            System.out.println("\n=== Kalkulator Geometri ===");
            System.out.println("Pilih opsi:");
            System.out.println("1. Input Belah Ketupat");
            System.out.println("2. Input Trapesium");
            System.out.println("3. Input Persegi Panjang");
            System.out.println("4. Input Prisma Persegi Panjang");
            System.out.println("5. Input Limas Persegi Panjang");
            System.out.println("6. Jalankan Semua Perhitungan (Thread)");
            System.out.println("7. Keluar");
            System.out.print("Masukkan pilihan (1-7): ");
            String choice = scanner.nextLine();

            try {
                int option = Integer.parseInt(choice);
                if (option < 1 || option > 7) {
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-7.");
                    continue;
                }

                switch (option) {
                    case 1:
                        System.out.println("\nInput benda geometri: " + belahKetupat.getNama());
                        belahKetupat.prosesInputDanValidasi();
                        System.out.printf("Luas: %.2f\n", belahKetupat.hitungLuas());
                        System.out.printf("Keliling: %.2f\n", belahKetupat.hitungKeliling());
                        shapes.add(belahKetupat);
                        break;

                    case 2:
                        Trapesium trapesium = new Trapesium(0, 0, 0);
                        System.out.println("\nInput benda geometri: " + trapesium.getNama());
                        trapesium.prosesInputDanValidasi();
                        System.out.printf("Luas: %.2f\n", trapesium.hitungLuas());
                        System.out.printf("Keliling: %.2f\n", trapesium.hitungKeliling());
                        shapes.add(trapesium);
                        break;

                    case 3:
                        PersegiPanjang persegiPanjang = new PersegiPanjang(0, 0);
                        System.out.println("\nInput benda geometri: " + persegiPanjang.getNama());
                        persegiPanjang.prosesInputDanValidasi();
                        System.out.printf("Luas: %.2f\n", persegiPanjang.hitungLuas());
                        System.out.printf("Keliling: %.2f\n", persegiPanjang.hitungKeliling());
                        shapes.add(persegiPanjang);
                        break;

                    case 4:
                        PrismaPersegiPanjang prisma = new PrismaPersegiPanjang(0, 0, 0);
                        System.out.println("\nInput benda geometri: " + prisma.getNama());
                        prisma.prosesInputDanValidasi();
                        System.out.printf("Volume: %.2f\n", prisma.hitungVolume());
                        System.out.printf("Luas Permukaan: %.2f\n", prisma.hitungLuasPermukaan());
                        shapes.add(prisma);
                        break;

                    case 5:
                        LimasPersegiPanjang limas = new LimasPersegiPanjang(0, 0, 0);
                        System.out.println("\nInput benda geometri: " + limas.getNama());
                        limas.prosesInputDanValidasi();
                        System.out.printf("Volume: %.2f\n", limas.hitungVolume());
                        System.out.printf("Luas Permukaan: %.2f\n", limas.hitungLuasPermukaan());
                        shapes.add(limas);
                        break;

                    case 6:
                        if (shapes.isEmpty()) {
                            System.out.println("Belum ada bangun geometri yang diinput.");
                            break;
                        }
                        System.out.println("\nMenjalankan perhitungan untuk semua bangun...");
                        for (Runnable shape : shapes) {
                            if (shape instanceof BelahKetupat) {
                                BelahKetupat b = (BelahKetupat) shape;
                                b.startCalculationThread();
                                try {
                                    b.getThread().join();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } else if (shape instanceof Trapesium) {
                                Trapesium t = (Trapesium) shape;
                                t.startCalculationThread();
                                try {
                                    t.getThread().join();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } else if (shape instanceof PersegiPanjang) {
                                PersegiPanjang p = (PersegiPanjang) shape;
                                p.startCalculationThread();
                                try {
                                    p.getThread().join();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } else if (shape instanceof PrismaPersegiPanjang) {
                                PrismaPersegiPanjang pr = (PrismaPersegiPanjang) shape;
                                pr.startCalculationThread();
                                try {
                                    pr.getThread().join();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } else if (shape instanceof LimasPersegiPanjang) {
                                LimasPersegiPanjang l = (LimasPersegiPanjang) shape;
                                l.startCalculationThread();
                                try {
                                    l.getThread().join();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        shapes.clear(); // Kosongkan daftar setelah perhitungan
                        System.out.println("Semua perhitungan selesai.");
                        break;

                    case 7:
                        System.out.println("Keluar dari program.");
                        scanner.close();
                        return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Pilihan harus berupa angka 1-7.");
            }
        }
        /* LimasBelahKetupat limasBelahKetupat = new LimasBelahKetupat(belahKetupat.getDiagonal1(), belahKetupat.getDiagonal2(), belahKetupat.getSisi(), 0);
        System.out.println("\nInput benda geometri: " + limasBelahKetupat.getNama());
        limasBelahKetupat.prosesInputDanValidasi(); 

        Trapesium trapesium = new Trapesium(0, 0, 0);
        System.out.println("\nInput benda geometri: " + trapesium.getNama());
        trapesium.prosesInputDanValidasi();

        System.out.println("\n=== Memulai Proses Perhitungan Multithreading ===\n");
        
        // Demonstrasi polymorphism dengan array
        Lingkaran[] bentukLingkaran = {lingkaran, bola, juringBola, temberengBola};
        
        System.out.println("=== Demonstrasi Polymorphism ===");
        for (int i = 0; i < bentukLingkaran.length; i++) {
            System.out.println("Bentuk ke-" + (i+1) + ": " + bentukLingkaran[i].getNama());
            System.out.printf("Luas: %.2f\n", bentukLingkaran[i].getLuas());
            System.out.printf("Keliling: %.2f\n", bentukLingkaran[i].getKeliling());
            
            // Method overriding untuk bentuk 3D
            if (bentukLingkaran[i] instanceof Bola) {
                Bola b = (Bola) bentukLingkaran[i];
                System.out.printf("Volume: %.2f\n", b.getVolume());
                System.out.printf("Luas Permukaan: %.2f\n", b.getLuasPermukaan());
            } else if (bentukLingkaran[i] instanceof JuringBola) {
                JuringBola jb = (JuringBola) bentukLingkaran[i];
                System.out.printf("Volume: %.2f\n", jb.getVolume());
                System.out.printf("Luas Permukaan: %.2f\n", jb.getLuasPermukaan());
            } else if (bentukLingkaran[i] instanceof TemberengBola) {
                TemberengBola tb = (TemberengBola) bentukLingkaran[i];
                System.out.printf("Volume: %.2f\n", tb.getVolume());
                System.out.printf("Luas Permukaan: %.2f\n", tb.getLuasPermukaan());
            }
            System.out.println();
        }

        // Proses perhitungan menggunakan thread
        try {
            PerhitunganThread lingkaranThread = new PerhitunganThread(() -> {
                System.out.println("Hitung: " + lingkaran.getNama());
                System.out.printf("Luas Lingkaran: %.2f\n", lingkaran.getLuas());
                System.out.printf("Keliling Lingkaran: %.2f\n", lingkaran.getKeliling());
            }, "Perhitungan Lingkaran");

            PerhitunganThread bolaThread = new PerhitunganThread(() -> {
                System.out.println("Hitung: " + bola.getNama());
                // System.out.printf("Luas Lingkaran (dari Bola): %.2f\n", bola.getLuas());
                // System.out.printf("Keliling Lingkaran (dari Bola): %.2f\n", bola.getKeliling());
                if (bola instanceof Bola) {
                    Bola b = (Bola) bola;
                    System.out.printf("Volume Bola: %.2f\n", b.getVolume());
                    System.out.printf("Luas Permukaan Bola: %.2f\n", b.getLuasPermukaan());
                }
            }, "Perhitungan Bola");

            PerhitunganThread juringBolaThread = new PerhitunganThread(() -> {
                System.out.println("Hitung: " + juringBola.getNama());
                // System.out.printf("Luas Lingkaran (dari Juring): %.2f\n", juringBola.getLuas());
                // System.out.printf("Keliling Lingkaran (dari Juring): %.2f\n", juringBola.getKeliling());
                if (juringBola instanceof JuringBola) {
                    JuringBola jb = (JuringBola) juringBola;
                    System.out.printf("Volume Juring Bola: %.2f\n", jb.getVolume());
                    System.out.printf("Luas Permukaan Juring Bola: %.2f\n", jb.getLuasPermukaan());
                }
            }, "Perhitungan Juring Bola");

            PerhitunganThread temberengBolaThread = new PerhitunganThread(() -> {
                System.out.println("Hitung: " + temberengBola.getNama());
                // System.out.printf("Luas Lingkaran (dari Tembereng): %.2f\n", temberengBola.getLuas());
                // System.out.printf("Keliling Lingkaran (dari Tembereng): %.2f\n", temberengBola.getKeliling());
                if (temberengBola instanceof TemberengBola) {
                    TemberengBola tb = (TemberengBola) temberengBola;
                    System.out.printf("Volume Tembereng Bola: %.2f\n", tb.getVolume());
                    System.out.printf("Luas Permukaan Tembereng Bola: %.2f\n", tb.getLuasPermukaan());
                }
            }, "Perhitungan Tembereng Bola");

            // PerhitunganThread segitigaThread = new PerhitunganThread(() -> {
            //     System.out.println("Hitung: " + segitiga.getNama());
            //     System.out.printf("Luas Segitiga: %.2f\n", segitiga.getLuas());
            //     System.out.printf("Keliling Segitiga: %.2f\n", segitiga.getKeliling());
            // }, "Perhitungan Segitiga");

            // PerhitunganThread limasSegitigaThread = new PerhitunganThread(() -> {
            //     System.out.println("Hitung: " + limasSegitiga.getNama());
            //     System.out.printf("Volume Limas Segitiga: %.2f\n", limasSegitiga.getVolume());
            //     System.out.printf("Luas Permukaan Limas Segitiga: %.2f\n", limasSegitiga.getLuasPermukaan());
            // }, "Perhitungan Limas Segitiga");

            // PerhitunganThread prismaSegitigaThread = new PerhitunganThread(() -> {
            //     System.out.println("Hitung: " + prismaSegitiga.getNama());
            //     System.out.printf("Volume Prisma Segitiga: %.2f\n", prismaSegitiga.getVolume());
            //     System.out.printf("Luas Permukaan Prisma Segitiga: %.2f\n", prismaSegitiga.getLuasPermukaan());
            // }, "Perhitungan Prisma Segitiga");

            // PerhitunganThread persegiThread = new PerhitunganThread(() -> {
            //     System.out.println("Hitung: " + persegi.getNama());
            //     System.out.printf("Luas persegi: %.2f\n", persegi.getLuas());
            //     System.out.printf("Keliling persegi: %.2f\n", persegi.getKeliling());
            // }, "Perhitungan persegi");

            // PerhitunganThread limasPersegiThread = new PerhitunganThread(() -> {
            //     System.out.println("Hitung: " + limasPersegi.getNama());
            //     System.out.printf("Volume Limas Persegi: %.2f\n", limasPersegi.getVolume());
            //     System.out.printf("Luas Permukaan Limas Persegi: %.2f\n", limasPersegi.getLuasPermukaan());
            // }, "Perhitungan Limas Persegi");

            // PerhitunganThread persegiPanjangThread = new PerhitunganThread(() -> {
            //     System.out.println("Hitung: " + persegiPanjang.getNama());
            //     System.out.printf("Luas persegi panjang: %.2f\n", persegiPanjang.getLuas());
            //     System.out.printf("Keliling persegi panjang: %.2f\n", persegiPanjang.getKeliling());
            // }, "Perhitungan persegi panjang");

            // PerhitunganThread limasPersegiPanjangThread = new PerhitunganThread(() -> {
            //     System.out.println("Hitung: " + limasPersegiPanjang.getNama());
            //     System.out.printf("Volume limas persegi panjang: %.2f\n", limasPersegiPanjang.getVolume());
            //     System.out.printf("Luas Permukaan limas persegi panjang: %.2f\n", limasPersegiPanjang.getLuasPermukaan());
            // }, "Perhitungan limas persegi panjang");

            // PerhitunganThread prismaPersegiPanjangThread = new PerhitunganThread(() -> {
            //     System.out.println("Hitung: " + prismaPersegiPanjang.getNama());
            //     System.out.printf("Volume prisma persegi panjang: %.2f\n", prismaPersegiPanjang.getVolume());
            //     System.out.printf("Luas Permukaan prisma persegi panjang: %.2f\n", prismaPersegiPanjang.getLuasPermukaan());
            // }, "Perhitungan prisma persegi panjang");

            // PerhitunganThread belahKetupatThread = new PerhitunganThread(() -> {
            //     System.out.println("Hitung: " + belahKetupat.getNama());
            //     System.out.printf("Luas belah ketupat: %.2f\n", belahKetupat.hitungLuas());
            //     System.out.printf("Keliling belah ketupat: %.2f\n", belahKetupat.hitungKeliling());
            // }, "Perhitungan belah ketupat");

            // PerhitunganThread limasBelahKetupatThread = new PerhitunganThread(() -> {
            //     System.out.println("Hitung: " + limasBelahKetupat.getNama());
            //     System.out.printf("Volume Limas Belah Ketupat: %.2f\n", limasBelahKetupat.getVolume());
            //     System.out.printf("Luas Permukaan Limas Belah Ketupat: %.2f\n", limasBelahKetupat.getLuasPermukaan());
            // }, "Perhitungan Limas Belah Ketupat");

            // PerhitunganThread prismaBelahKetupatThread = new PerhitunganThread(() -> {
            //     System.out.println("Hitung: " + prismaBelahKetupat.getNama());
            //     System.out.printf("Volume Prisma Belah Ketupat: %.2f\n", prismaBelahKetupat.getVolume());
            //     System.out.printf("Luas Permukaan Prisma Belah Ketupat: %.2f\n", prismaBelahKetupat.getLuasPermukaan());
            // }, "Perhitungan Prisma Belah Ketupat");

            PerhitunganThread trapesiumThread = new PerhitunganThread(() -> {
                System.out.println("Hitung: " + trapesium.getNama());
                System.out.printf("Luas trapesium: %.2f\n", trapesium.hitungLuas());
                System.out.printf("Keliling trapesium: %.2f\n", trapesium.hitungKeliling());
            }, "Perhitungan trapesium");

            // Mulai semua thread
            lingkaranThread.start();
            bolaThread.start();
            juringBolaThread.start();
            temberengBolaThread.start();
            // segitigaThread.start();
            // limasSegitigaThread.start();
            // prismaSegitigaThread.start();
            // persegiThread.start();
            // limasPersegiThread.start();
            // persegiPanjangThread.start();
            // limasPersegiPanjangThread.start();
            // prismaPersegiPanjangThread.start();
            // belahKetupatThread.start();
            // limasBelahKetupatThread.start();
            // prismaBelahKetupatThread.start();
            // trapesiumThread.start();

            // Tunggu semua thread selesai
            lingkaranThread.join();
            bolaThread.join();
            juringBolaThread.join();
            temberengBolaThread.join();
            // segitigaThread.join();
            // limasSegitigaThread.join();
            // prismaSegitigaThread.join();
            // persegiThread.join();
            // limasPersegiThread.join();
            // persegiPanjangThread.join();
            // limasPersegiPanjangThread.join();
            // prismaPersegiPanjangThread.join();
            // belahKetupatThread.join();
            // limasBelahKetupatThread.join();
            // prismaBelahKetupatThread.join();
            // trapesiumThread.join();

            System.out.println("\n=== Semua Proses Selesai ===");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Method untuk mendemonstrasikan polymorphism
        System.out.println("\n=== Polymorphism Method Call ===");
        hitungSemuaBentukLingkaran(bentukLingkaran);
    }
    
    // Method statis untuk mendemonstrasikan polymorphism
    public static void hitungSemuaBentukLingkaran(Lingkaran[] bentuk) {
        for (Lingkaran l : bentuk) {
            System.out.println("Menghitung " + l.getNama() + ":");
            System.out.printf("  Luas: %.2f\n", l.getLuas());
            System.out.printf("  Keliling: %.2f\n", l.getKeliling());
            
            // Runtime type checking untuk method khusus
            if (l instanceof TemberengBola) {
                TemberengBola tb = (TemberengBola) l;
                System.out.printf("  Volume (Tembereng): %.2f\n", tb.getVolume());
                System.out.printf("  Luas Permukaan (Tembereng): %.2f\n", tb.getLuasPermukaan());
            } else if (l instanceof JuringBola) {
                JuringBola jb = (JuringBola) l;
                System.out.printf("  Volume (Juring): %.2f\n", jb.getVolume());
                System.out.printf("  Luas Permukaan (Juring): %.2f\n", jb.getLuasPermukaan());
            } else if (l instanceof Bola) {
                Bola b = (Bola) l;
                System.out.printf("  Volume (Bola): %.2f\n", b.getVolume());
                System.out.printf("  Luas Permukaan (Bola): %.2f\n", b.getLuasPermukaan());
            }
            System.out.println();
        }*/
    }
}