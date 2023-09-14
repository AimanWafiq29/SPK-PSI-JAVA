package Repository;

import Entity.Alternatif;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlternatifRepositoryImpl implements AlternatifRepository {

    private Connection conn;

    public AlternatifRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public ArrayList<Alternatif> getAll() {
        ArrayList<Alternatif> alternatifList = new ArrayList<>();
        String sql = "SELECT * FROM tbl_alternatif";
        try (Statement statement = conn.createStatement(); ResultSet resultset = statement.executeQuery(sql)) {
            while (resultset.next()) {
                int id = resultset.getInt("id_Alternatif");
                String kode = resultset.getString("kode_Alternatif");
                String nama = resultset.getString("nama_Alternatif");
                Alternatif alternatif = new Alternatif(id, kode, nama);
                alternatifList.add(alternatif);
            }
            resultset.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alternatifList;
    }

    @Override
    public boolean add(Alternatif alternatif) {
        String sql = "INSERT INTO tbl_alternatif (kode_Alternatif, nama_Alternatif) VALUES (?, ?)";
        boolean berhasil = false; // Inisialisasi dengan false

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, alternatif.getKode());
            statement.setString(2, alternatif.getNama());
            int rowsAffected = statement.executeUpdate();

            // Jika ada baris yang terpengaruh oleh penambahan, berarti berhasil
            if (rowsAffected > 0) {
                berhasil = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return berhasil; // Mengembalikan true jika berhasil, false jika gagal
    }

    @Override
    public boolean remove(int id) {
        String sql = "DELETE FROM tbl_alternatif WHERE id_Alternatif = ?";
        boolean berhasil = false; // Inisialisasi dengan false

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();

            // Jika ada baris yang terpengaruh oleh penghapusan, berarti berhasil
            if (rowsAffected > 0) {
                berhasil = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return berhasil; // Mengembalikan true jika berhasil, false jika gagal
    }

    @Override
    public boolean edit(Alternatif alternatif) {
        String sql = "UPDATE tbl_alternatif SET Kode_Alternatif = ?, Nama_Alternatif = ? WHERE id_Alternatif = ?";
        boolean berhasil = false; // Inisialisasi dengan false

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, alternatif.getKode());
            statement.setString(2, alternatif.getNama());
            statement.setInt(3, alternatif.getId());
            int rowsAffected = statement.executeUpdate();

            // Jika ada baris yang terpengaruh oleh pengeditan, berarti berhasil
            if (rowsAffected > 0) {
                berhasil = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return berhasil; // Mengembalikan true jika berhasil, false jika gagal
    }

    @Override
    public int getLastAddedId() {
        int lastId = 0;
        String sql = "SELECT LAST_INSERT_ID()";
        try (Statement statement = conn.createStatement(); ResultSet resultset = statement.executeQuery(sql)) {
            while (resultset.next()) {
                lastId = resultset.getInt(1);
            }
            resultset.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lastId;
    }

}
