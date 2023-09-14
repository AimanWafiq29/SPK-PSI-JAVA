package Repository;

import Entity.SubKriteria;
import java.util.ArrayList;

public interface SubKriteriaRepository {

    ArrayList<SubKriteria> getAll();

    ArrayList<SubKriteria> getById(int id);

    boolean add(SubKriteria subKriteria);

    boolean remove(int id);

    boolean edit(SubKriteria subKriteria);

}
