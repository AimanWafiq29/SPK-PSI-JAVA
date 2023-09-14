package Repository;

import Entity.Kriteria;
import java.util.ArrayList;

public interface KriteriaRepository {

    ArrayList<Kriteria> getAll();

    boolean add(Kriteria kriteria);

    boolean remove(int id);

    boolean edit(Kriteria kriteria);

    String findId(int id);

    int findNama(String nama);
}
