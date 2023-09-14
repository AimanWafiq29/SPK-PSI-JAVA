package Service;

import Entity.Kriteria;
import Repository.KriteriaRepository;
import java.util.ArrayList;

public class KriteriaServiceImpl implements KriteriaService {

    private KriteriaRepository kriteriaRepository;

    public KriteriaServiceImpl(KriteriaRepository KriteriaRepository) {
        this.kriteriaRepository = KriteriaRepository;
    }

    @Override
    public ArrayList<Kriteria> showKriteria() {
        return this.kriteriaRepository.getAll();
    }

    @Override
    public boolean addKriteria(Kriteria kriteria) {
        return this.kriteriaRepository.add(kriteria);
    }

    @Override
    public boolean removeKriteria(int id) {
        return this.kriteriaRepository.remove(id);
    }

    @Override
    public boolean editKriteria(Kriteria kriteria) {
        return this.kriteriaRepository.edit(kriteria);
    }

    @Override
    public String namaKriteria(int id) {
        return this.kriteriaRepository.findId(id);
    }

    @Override
    public int idKriteria(String nama) {
        return this.kriteriaRepository.findNama(nama);
    }
}
