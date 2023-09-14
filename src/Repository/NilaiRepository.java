package Repository;

import Entity.Nilai;
import java.util.ArrayList;

public interface NilaiRepository {

    ArrayList<Nilai> getAll();

    boolean add(Nilai nilai);

    boolean remove(int id);

    boolean edit(Nilai nilai);

    ArrayList<Nilai> getByid(int id);

    ArrayList<Nilai> getNilaiByAlternatifId(int id);
}
