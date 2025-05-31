package benda.geometri;

public class TemberengLingkaran extends JuringLingkaran {
    private double taliBusur;
    protected double luas;
    protected double keliling;

    public TemberengLingkaran(double jariJari, double sudut) {
        super(jariJari, sudut);
        double sudutRad = Math.toRadians(sudut);
        this.taliBusur = 2 * jariJari * Math.sin(sudutRad / 2);
    }

    @Override
    public String getNama() {
        return "Tembereng Lingkaran";
    }

    @Override
    public double hitungLuas() {
        double sudutRad = Math.toRadians(sudut);
        double luasJuring = (sudutRad / 2) * Math.pow(jariJari, 2);
        double luasSegitiga = 0.5 * Math.pow(jariJari, 2) * Math.sin(sudutRad);
        luas = luasJuring - luasSegitiga;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        keliling = super.panjangBusur + taliBusur;
        return keliling;
    }

    public double hitungLuas(double newJarijari){
        
    }

    public double hitungKeliling(double newJarijari){

    }

     public void ProsesPerhitungan(){
        Scanner inp = new Scanner(System.in);
        System.out.print("Apakah ingin mengubah nilai jari-jari Tembereng Lingkarean? (Y/N): ");
        String jawab = inp.nextLine();


        if (jawab.equalsIgnoreCase("Y")) {
            try {
                System.out.print("Masukkan jari-jari baru: ");
                double newJarijari = inp.nextDouble();
                if (newJarijari <= 0) {
                    throw new IllegalArgumentException("Jari-jari harus lebih dari nol.");
                }
                luas = hitungLuas(newJarijari);
                keliling = hitungKeliling(newJarijari);
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("Input jari-jari harus berupa angka.");
            }finally{
                inp.close();
            }
        } else if (jawab.equalsIgnoreCase("N")) {
                luas = hitungLuas();
                keliling = hitungKeliling();
        } else {
            throw new IllegalArgumentException(" Jawaban hanya boleh Y atau N.");
        }
    }

    public double luas() {
        return luas;
    }

    public double keliling() {
        return keliling;
    }
}
