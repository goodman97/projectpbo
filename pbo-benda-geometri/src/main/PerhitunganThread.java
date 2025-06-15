package main;

public class PerhitunganThread extends Thread {
    private Runnable proses;
    private String namaProses;

    public PerhitunganThread(Runnable proses, String namaProses) {
        this.proses = proses;
        this.namaProses = namaProses;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread " + namaProses + " mulai...");
            proses.run();
            System.out.println("Thread " + namaProses + " selesai.\n");
        } catch (Exception e) {
            System.err.println("Error in thread " + namaProses + ": " + e.getMessage());
        }
    }
}
