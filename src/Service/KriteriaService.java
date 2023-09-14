package Service;

import Entity.Kriteria;
import java.util.ArrayList;

public interface KriteriaService {

    ArrayList<Kriteria> showKriteria();

    boolean addKriteria(Kriteria kriteria);

    boolean removeKriteria(int id);

    boolean editKriteria(Kriteria kriteria);
    
    String namaKriteria(int id);
    
    int idKriteria(String nama);
}
