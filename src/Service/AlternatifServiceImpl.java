package Service;

import Config.Database;
import Entity.Alternatif;
import Entity.Nilai;
import Repository.AlternatifRepository;
import Repository.NilaiRepository;
import Repository.NilaiRepositoryImpl;
import java.sql.Connection;
import java.util.ArrayList;

public class AlternatifServiceImpl implements AlternatifService {

    private AlternatifRepository alternatifRepositpty;

    public AlternatifServiceImpl(AlternatifRepository alternatifRepositpty) {
        this.alternatifRepositpty = alternatifRepositpty;
    }

    @Override
    public ArrayList<Alternatif> showAlternatif() {
        return alternatifRepositpty.getAll();
    }

    @Override
    public boolean addAlternatif(Alternatif alternatif) {
        return alternatifRepositpty.add(alternatif);
    }

    @Override
    public boolean removeAlternatif(int id) {
        
        Connection conn = Database.getConnection();
        // Dapatkan daftar nilai yang terkait dengan ID alternatif yang akan dihapus
        NilaiRepository nilaiRepository = new NilaiRepositoryImpl(conn);
        
        NilaiService nilaiService = new NilaiServiceImpl(nilaiRepository);
        
        ArrayList<Nilai> nilaiList = nilaiRepository.getNilaiByAlternatifId(id);

        // Hapus nilai-nilai tersebut menggunakan metode removeNilai dalam nilaiService
        for (Nilai nilai : nilaiList) {
            nilaiService.removeNilai(nilai.getId());
        }

        // Setelah menghapus semua nilai terkait, hapus data alternatif itu sendiri
        return alternatifRepositpty.remove(id);
    }

    @Override
    public boolean editAlternatif(Alternatif alternatif) {
        return alternatifRepositpty.edit(alternatif);
    }

    @Override
    public int getLastAddedIdAlternatif() {
        return alternatifRepositpty.getLastAddedId();
    }

}
