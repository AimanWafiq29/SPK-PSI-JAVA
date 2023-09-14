package Entity;

public class Alternatif {

    private int id;
    private String kode;
    private String nama;

    public Alternatif(String kode, String nama) {
        this.id = id;
        this.kode = kode;
        this.nama = nama;
    }
    
    public Alternatif(int id, String kode, String nama) {
        this.id = id;
        this.kode = kode;
        this.nama = nama;
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

    
}
