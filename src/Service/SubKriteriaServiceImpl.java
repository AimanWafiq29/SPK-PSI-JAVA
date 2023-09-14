package Service;

import Entity.SubKriteria;
import Repository.SubKriteriaRepository;
import java.util.ArrayList;

public class SubKriteriaServiceImpl implements SubKriteriaService {

    private SubKriteriaRepository subKriteriaRepository;

    public SubKriteriaServiceImpl(SubKriteriaRepository subKriteriaRepository) {
        this.subKriteriaRepository = subKriteriaRepository;
    }

    @Override
    public ArrayList<SubKriteria> showSubKriteria() {
        return this.subKriteriaRepository.getAll();
    }

    @Override
    public ArrayList<SubKriteria> showByIdSubKriteria(int id) {
        return this.subKriteriaRepository.getById(id);
    }

    @Override
    public boolean addSubKriteria(SubKriteria subKriteria) {
        return this.subKriteriaRepository.add(subKriteria);
    }

    @Override
    public boolean removeSubKriteria(int id) {
        return this.subKriteriaRepository.remove(id);
    }

    @Override
    public boolean editSubKriteria(SubKriteria subKriteria) {
        return this.subKriteriaRepository.edit(subKriteria);
    }

}
