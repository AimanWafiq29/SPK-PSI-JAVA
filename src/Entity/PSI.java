package Entity;

public class PSI {

    String Alternatif;
    String namaKriteria[];
    double bobotKriteria[];

    public PSI(String Alternatif, double[] bobotKriteria) {
        this.Alternatif = Alternatif;
        this.bobotKriteria = bobotKriteria;
    }

    public PSI(String Alternatif, String[] namaKriteria) {
        this.Alternatif = Alternatif;
        this.namaKriteria = namaKriteria;
    }

    public String getAlternatif() {
        return Alternatif;
    }

    public void setAlternatif(String Alternatif) {
        this.Alternatif = Alternatif;
    }

    public double[] getBobotKriteria() {
        return this.bobotKriteria;
    }

    public double getBobotKriteria(int index) {
        return this.bobotKriteria[index];
    }

    public void setBobotKriteria(double[] Kriteria) {
        this.bobotKriteria = Kriteria;
    }

    public String[] getNamaKriteria() {
        return this.namaKriteria;
    }

    public String getNamaKriteria(int index) {
        return this.namaKriteria[index];
    }

    public void setBobotKriteria(String[] Kriteria) {
        this.namaKriteria = Kriteria;
    }

}
