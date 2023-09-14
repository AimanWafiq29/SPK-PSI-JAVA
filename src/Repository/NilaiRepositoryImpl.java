package Repository;

import Entity.Kriteria;
import Entity.Nilai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NilaiRepositoryImpl implements NilaiRepository {

    private Connection conn;

    public NilaiRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public ArrayList<Nilai> getAll() {

        ArrayList<Nilai> nilaiList = new ArrayList<>();
        String sql = "SELECT * FROM tbl_nilai";
        try (Statement statement = conn.createStatement(); ResultSet resultset = statement.executeQuery(sql)) {
            while (resultset.next()) {
                int id = resultset.getInt("id_Nilai");
                int id_Alternatif = resultset.getInt("id_Alternatif");
                int id_Kriteria = resultset.getInt("id_Kriteria");
                int id_Subkriteria = resultset.getInt("id_SubKriteria");
                Nilai nilai = new Nilai(id, id_Alternatif, id_Kriteria, id_Subkriteria);
                nilaiList.add(nilai);
            }
            resultset.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nilaiList;

    }

    @Override
    public boolean add(Nilai nilai) {
        String sql = "INSERT INTO tbl_nilai (id_Alternatif, id_Kriteria, id_SubKriteria) VALUES (?, ?, ?)";
        boolean berhasil = false;
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, nilai.getId_Alternatif());
            statement.setInt(2, nilai.getId_Kriteria());
            statement.setInt(3, nilai.getId_SubKriteria());
            int rowsAffected = statement.executeUpdate();

            // Jika ada baris yang terpengaruh oleh penambahan, berarti berhasil
            if (rowsAffected > 0) {
                berhasil = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return berhasil;
    }

    @Override
    public boolean remove(int id) {
        String sql = "DELETE FROM tbl_nilai WHERE id_nilai = ?";
        boolean berhasil = false;
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();

            // Jika ada baris yang terpengaruh oleh penambahan, berarti berhasil
            if (rowsAffected > 0) {
                berhasil = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return berhasil;
    }

    @Override
    public boolean edit(Nilai nilai) {
        String sql = "UPDATE tbl_nilai SET id_Alternatif = ?, id_Kriteria = ?, id_subKriteria = ?  WHERE id_nilai = ?";

        boolean berhasil = false;
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, nilai.getId_Alternatif());
            statement.setInt(2, nilai.getId_Kriteria());
            statement.setInt(3, nilai.getId_SubKriteria());
            statement.setInt(4, nilai.getId());

            int rowsAffected = statement.executeUpdate();

            // Jika ada baris yang terpengaruh oleh penambahan, berarti berhasil
            if (rowsAffected > 0) {
                berhasil = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return berhasil;
    }

    @Override
    public ArrayList<Nilai> getByid(int id) {
        ArrayList<Nilai> nilaiList = new ArrayList<>();
        String sql = "SELECT * FROM `tbl_nilai` WHERE id_Nilai=" + id;
        System.out.println(sql);
        try (Statement statement = conn.createStatement(); ResultSet resultset = statement.executeQuery(sql)) {
            while (resultset.next()) {
                int id_Nilai = resultset.getInt("id_Nilai");
                int id_Alternatif = resultset.getInt("id_Alternatif");
                int id_Kriteria = resultset.getInt("id_Kriteria");
                int id_Subkriteria = resultset.getInt("id_SubKriteria");
                Nilai nilai = new Nilai(id_Nilai, id_Alternatif, id_Kriteria, id_Subkriteria);
                nilaiList.add(nilai);
            }
            resultset.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nilaiList;
    }

    @Override
    public ArrayList<Nilai> getNilaiByAlternatifId(int id) {
        ArrayList<Nilai> nilaiList = new ArrayList<>();
        String sql = "SELECT * FROM `tbl_nilai` WHERE id_Alternatif=" + id;
        System.out.println(sql);
        try (Statement statement = conn.createStatement(); ResultSet resultset = statement.executeQuery(sql)) {
            while (resultset.next()) {
                int id_Nilai = resultset.getInt("id_Nilai");
                int id_Alternatif = resultset.getInt("id_Alternatif");
                int id_Kriteria = resultset.getInt("id_Kriteria");
                int id_Subkriteria = resultset.getInt("id_SubKriteria");
                Nilai nilai = new Nilai(id_Nilai, id_Alternatif, id_Kriteria, id_Subkriteria);
                nilaiList.add(nilai);
            }
            resultset.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();    
        }
        return nilaiList;
    }
}
