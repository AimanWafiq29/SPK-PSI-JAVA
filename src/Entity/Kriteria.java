package Entity;

public class Kriteria {

    private int id;
    private String kode;
    private String nama;
    private String jenis;

    public Kriteria(String kode, String nama, String jenis) {
        this.kode = kode;
        this.nama = nama;
        this.jenis = jenis;
    }

    public Kriteria(int id, String kode, String nama, String jenis) {
        this.id = id;
        this.kode = kode;
        this.nama = nama;
        this.jenis = jenis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

}
