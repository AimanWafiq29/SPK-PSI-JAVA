package Service;

import Entity.Nilai;
import java.util.ArrayList;

public interface NilaiService {

    ArrayList<Nilai> showNilai();
    
    ArrayList<Nilai> showNilaiById(int id);

    boolean addNilai(Nilai nilai);

    boolean removeNilai(int id);

    boolean editNilai(Nilai nilai);
}
