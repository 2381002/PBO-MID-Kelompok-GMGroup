package rumahTangga.repositories;

import org.springframework.stereotype.Component;
import rumahTangga.config.Database;
import rumahTangga.entities.anggotaKeluarga;
import rumahTangga.entities.resepMakanan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
public class resepMakananRepositoryDbImpl implements resepMakananRepository{
    private Database database;

    public resepMakananRepositoryDbImpl(Database database) {
        this.database = database;
    }

    @Override
    public ArrayList<resepMakanan> getAll() {
        Connection connection = database.getConnection();
        String sqlStatement = "SELECT * FROM resep_makanan";
        ArrayList<resepMakanan> resepMakananList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                resepMakanan resep = new resepMakanan();
                Integer id = resultSet.getInt(1);
                String nama = resultSet.getString(2);
                String deskripsi = resultSet.getString(3);
                resep.setId(id);
                resep.setNama(nama);
                resep.setDeskripsi(deskripsi);
                resepMakananList.add(resep);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resepMakananList;
    }

    @Override
    public void add(resepMakanan resep) {
        String sqlStatement = "INSERT INTO resep_makanan(nama, deskripsi) values(?,?)";
        Connection conn = database.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
            preparedStatement.setString(1, resep.getNama());
            preparedStatement.setString(2, resep.getDeskripsi());

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

        String sqlStatement = "DELETE FROM resep_makanan WHERE id = ?";
        Connection conn = database.getConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
            preparedStatement.setInt(1, id);

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
    public Boolean edit(resepMakanan resep) {
        String sqlStatement = "UPDATE resep_makanan set nama = ?, deskripsi = ? WHERE id = ?";
        Connection conn = database.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
            preparedStatement.setString(1, resep.getNama());
            preparedStatement.setString(2, resep.getDeskripsi());
            preparedStatement.setInt(3, resep.getId());

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