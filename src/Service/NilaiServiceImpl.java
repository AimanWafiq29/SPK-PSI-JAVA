package Service;

import Entity.Nilai;
import Repository.NilaiRepository;
import java.util.ArrayList;

public class NilaiServiceImpl implements NilaiService {

    private NilaiRepository nilaiRepository;

    public NilaiServiceImpl(NilaiRepository nilaiRepository) {
        this.nilaiRepository = nilaiRepository;
    }

    @Override
    public ArrayList<Nilai> showNilai() {
        return this.nilaiRepository.getAll();
    }
    
    @Override
    public ArrayList<Nilai> showNilaiById(int id) {
        return this.nilaiRepository.getByid(id);
    }

    @Override
    public boolean addNilai(Nilai nilai) {
        return this.nilaiRepository.add(nilai);
    }

    @Override
    public boolean removeNilai(int id) {
        return this.nilaiRepository.remove(id);
    }

    @Override
    public boolean editNilai(Nilai nilai) {
        return this.nilaiRepository.edit(nilai);
    }

}
