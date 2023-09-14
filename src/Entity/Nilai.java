package Entity;

public class Nilai {

    private int id;
    private int id_Alternatif;
    private int id_Kriteria;
    private int id_SubKriteria;

    public Nilai(int id_Alternatif, int id_Kriteria, int id_SubKriteria) {
        this.id = id;
        this.id_Alternatif = id_Alternatif;
        this.id_Kriteria = id_Kriteria;
        this.id_SubKriteria = id_SubKriteria;
    }

    public Nilai(int id, int id_Alternatif, int id_Kriteria, int id_SubKriteria) {
        this.id = id;
        this.id_Alternatif = id_Alternatif;
        this.id_Kriteria = id_Kriteria;
        this.id_SubKriteria = id_SubKriteria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Alternatif() {
        return id_Alternatif;
    }

    public void setId_Alternatif(int id_Alternatif) {
        this.id_Alternatif = id_Alternatif;
    }

    public int getId_Kriteria() {
        return id_Kriteria;
    }

    public void setId_Kriteria(int id_Kriteria) {
        this.id_Kriteria = id_Kriteria;
    }

    public int getId_SubKriteria() {
        return id_SubKriteria;
    }

    public void setId_SubKriteria(int id_SubKriteria) {
        this.id_SubKriteria = id_SubKriteria;
    }

}
