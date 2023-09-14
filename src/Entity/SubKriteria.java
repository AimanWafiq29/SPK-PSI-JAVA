package Entity;

public class SubKriteria {

    private int id;
    private int id_kriteria;
    private String kode;
    private String nama;
    private double bobot;

    public SubKriteria(int id_kriteria, String kode, String nama, double bobot) {
        this.id_kriteria = id_kriteria;
        this.kode = kode;
        this.nama = nama;
        this.bobot = bobot;
    }
    
    public SubKriteria(int id, int id_kriteria, String kode, String nama, double bobot) {
        this.id = id;
        this.id_kriteria = id_kriteria;
        this.kode = kode;
        this.nama = nama;
        this.bobot = bobot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_kriteria() {
        return id_kriteria;
    }

    public void setId_kriteria(int id_kriteria) {
        this.id_kriteria = id_kriteria;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getBobot() {
        return bobot;
    }

    public void setBobot(double bobot) {
        this.bobot = bobot;
    }


}
