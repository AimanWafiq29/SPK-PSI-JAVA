package Repository;

import Entity.Alternatif;
import java.util.ArrayList;

public interface AlternatifRepository {

    ArrayList<Alternatif> getAll();

    int getLastAddedId();

    boolean add(Alternatif alternatif);

    boolean remove(int id);

    boolean edit(Alternatif alternatif);

}
