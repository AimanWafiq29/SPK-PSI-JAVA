package Repository;

import Entity.SubKriteria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SubKriteriaRepositoryImpl implements SubKriteriaRepository {

    private Connection conn;

    public SubKriteriaRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public ArrayList<SubKriteria> getAll() {
        ArrayList<SubKriteria> subKriteriaList = new ArrayList<>();
        String sql = "SELECT * FROM tbl_SubKriteria";
        try (Statement statement = conn.createStatement(); ResultSet resultset = statement.executeQuery(sql)) {
            while (resultset.next()) {
                int id = resultset.getInt("id_SubKriteria");
                int id_Kriteria = resultset.getInt("id_Kriteria");
                String kode = resultset.getString("kode_SubKriteria");
                String nama = resultset.getString("nama_SubKriteria");
                double bobot = resultset.getDouble("bobot_SubKriteria");
                SubKriteria subKriteria = new SubKriteria(id, id_Kriteria, kode, nama, bobot);
                subKriteriaList.add(subKriteria);
            }
            resultset.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return subKriteriaList;
    }

    @Override
    public ArrayList<SubKriteria> getById(int id) {
        ArrayList<SubKriteria> subKriteriaList = new ArrayList<>();
        String sql = "SELECT * FROM tbl_SubKriteria WHERE id_kriteria=" + id;
        try (Statement statement = conn.createStatement(); ResultSet resultset = statement.executeQuery(sql)) {
            while (resultset.next()) {
                int id_subKriteria = resultset.getInt("id_SubKriteria");
                int id_Kriteria = resultset.getInt("id_Kriteria");
                String kode = resultset.getString("kode_SubKriteria");
                String nama = resultset.getString("nama_SubKriteria");
                double bobot = resultset.getDouble("bobot_SubKriteria");
                SubKriteria subKriteria = new SubKriteria(id_subKriteria, id_Kriteria, kode, nama, bobot);
                subKriteriaList.add(subKriteria);
            }
            resultset.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return subKriteriaList;
    }

    @Override
    public boolean add(SubKriteria subKriteria) {
        String sql = "INSERT INTO tbl_subKriteria (id_Kriteria, kode_subKriteria, nama_subKriteria, bobot_subKriteria) VALUES (?,?,?,?)";
        boolean berhasil = false;
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, subKriteria.getId_kriteria());
            statement.setString(2, subKriteria.getKode());
            statement.setString(3, subKriteria.getNama());
            statement.setDouble(4, subKriteria.getBobot());

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
        String sql = "DELETE FROM tbl_subKriteria WHERE id_SubKriteria = ?";
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
    public boolean edit(SubKriteria subKriteria) {
        String sql = "UPDATE tbl_subKriteria SET id_Kriteria = ?, Kode_SubKriteria = ?, nama_SubKriteria = ?, bobot_SubKriteria = ? WHERE id_subKriteria = ?";
        boolean berhasil = false;
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, subKriteria.getId_kriteria());
            statement.setString(2, subKriteria.getKode());
            statement.setString(3, subKriteria.getNama());
            statement.setDouble(4, subKriteria.getBobot());
            statement.setInt(5, subKriteria.getId());
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

}
