package Service;

import Entity.SubKriteria;
import java.util.ArrayList;

public interface SubKriteriaService {

    ArrayList<SubKriteria> showSubKriteria();

    public ArrayList<SubKriteria> showByIdSubKriteria(int id);

    boolean addSubKriteria(SubKriteria subKriteria);

    boolean removeSubKriteria(int id);

    boolean editSubKriteria(SubKriteria subKriteria);

}
