package rumahTangga.repositories;

import rumahTangga.config.Database;
import rumahTangga.entities.anggotaKeluarga;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class anggotaKeluargaRepositoryDbImpl implements anggotaKeluargaRepository {
    private Database database;

    public anggotaKeluargaRepositoryDbImpl(Database database) {
        this.database = database;
    }

    @Override
    public ArrayList<anggotaKeluarga> getAll() {
        Connection connection = database.getConnection();
        String sqlStatement = "SELECT * FROM anggota_keluarga";
        ArrayList<anggotaKeluarga> anggotaKeluargaList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                anggotaKeluarga anggota = new anggotaKeluarga();
                Integer id = resultSet.getInt(1);
                String nama = resultSet.getString(2);
                Integer keuangan = resultSet.getInt(3);
                String kegiatan = resultSet.getString(4);
                anggota.setId(id);
                anggota.setNama(nama);
                anggota.setKeuangan(keuangan);
                anggota.setKegiatan(kegiatan);
                anggotaKeluargaList.add(anggota);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return anggotaKeluargaList;
    }

    @Override
    public void add(anggotaKeluarga anggota) {
        String sqlStatement = "INSERT INTO anggota_keluarga(nama_anggota, keuangan, kegiatan) values(?,?,?)";
        Connection conn = database.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
            preparedStatement.setString(1, anggota.getNama());
            preparedStatement.setInt(2, anggota.getKeuangan());
            preparedStatement.setString(3, anggota.getKegiatan());

            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected > 0) {
                System.out.println("Insert successful !");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Boolean remove(final Integer id) {
        ArrayList<anggotaKeluarga> tmp=getAll();
        Integer idAnggota = tmp.get(id).getId();
        String sqlStatement = "DELETE FROM anggota_keluarga WHERE id = ?";
        Connection conn = database.getConnection();
        var dbId = idAnggota;
        if (dbId == null) {
            return false;
        }
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
            preparedStatement.setInt(1, dbId);

            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected > 0) {
                System.out.println("Delete successful !");
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean edit(anggotaKeluarga anggota) {
        String sqlStatement = "UPDATE anggota_keluarga set nama_anggota = ?, keuangan = ?, kegiatan = ? WHERE id = ?";
        Connection conn = database.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
            preparedStatement.setString(1, anggota.getNama());
            preparedStatement.setInt(2, anggota.getKeuangan());
            preparedStatement.setString(3, anggota.getKegiatan());
            preparedStatement.setInt(4, anggota.getId());

            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected > 0) {
                System.out.println("Update successful !");
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
