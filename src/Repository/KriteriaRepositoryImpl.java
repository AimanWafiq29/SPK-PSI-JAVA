package Repository;

import Entity.Kriteria;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KriteriaRepositoryImpl implements KriteriaRepository {

    private Connection conn;

    public KriteriaRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public ArrayList<Kriteria> getAll() {
        ArrayList<Kriteria> kriteriaList = new ArrayList<>();
        String sql = "SELECT * FROM tbl_kriteria";
        try (Statement statement = conn.createStatement(); ResultSet resultset = statement.executeQuery(sql)) {
            while (resultset.next()) {
                int id = resultset.getInt("id_Kriteria");
                String kode = resultset.getString("kode_Kriteria");
                String nama = resultset.getString("nama_Kriteria");
                String jenis = resultset.getString("jenis_Kriteria");
                Kriteria kriteria = new Kriteria(id, kode, nama, jenis);
                kriteriaList.add(kriteria);
            }
            resultset.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kriteriaList;
    }

    @Override
    public boolean add(Kriteria kriteria) {
        String sql = "INSERT INTO tbl_kriteria (kode_kriteria, nama_Kriteria, jenis_Kriteria) VALUES (?, ?, ?)";
        boolean berhasil = false;

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, kriteria.getKode());
            statement.setString(2, kriteria.getNama());
            statement.setString(3, kriteria.getJenis());
            int rowsAffected = statement.executeUpdate();

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
        String sql = "DELETE FROM tbl_Kriteria WHERE id_Kriteria = ?";
        boolean berhasil = false;

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                berhasil = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return berhasil;
    }

    @Override
    public boolean edit(Kriteria kriteria) {
        String sql = "UPDATE tbl_Kriteria SET Kode_Kriteria = ?, Nama_Kriteria = ?, jenis_Kriteria = ? WHERE id_Kriteria = ?";
        boolean berhasil = false;

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, kriteria.getKode());
            statement.setString(2, kriteria.getNama());
            statement.setString(3, kriteria.getJenis());
            statement.setInt(4, kriteria.getId());
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                berhasil = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return berhasil;
    }

    @Override
    public String findId(int id) {
        String sql = "SELECT * FROM tbl_Kriteria WHERE id_Kriteria =" + id;
        String nama = "";
        try (Statement statement = conn.createStatement(); ResultSet resultset = statement.executeQuery(sql)) {
            while (resultset.next()) {
                nama = resultset.getString("nama_kriteria");
            }
            resultset.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nama;
    }

    @Override
    public int findNama(String nama) {
        String sql = "SELECT * FROM tbl_Kriteria WHERE nama_Kriteria =" + nama;
        String result = "";
        int idKriteria = 0;
        try (Statement statement = conn.createStatement(); ResultSet resultset = statement.executeQuery(sql)) {
            while (resultset.next()) {
                result = resultset.getString("id_kriteria");
            }
            resultset.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        idKriteria = Integer.parseInt(result);
        return idKriteria;
    }
}
