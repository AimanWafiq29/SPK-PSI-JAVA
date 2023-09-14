package Service;

import Entity.Alternatif;
import java.util.ArrayList;

public interface AlternatifService {

    ArrayList<Alternatif> showAlternatif();

    boolean addAlternatif(Alternatif alternatif);

    boolean removeAlternatif(int id);
    
    boolean editAlternatif(Alternatif alternatif);
    
    int getLastAddedIdAlternatif();

}
