package rumahTangga.repositories;

import org.springframework.stereotype.Component;
import rumahTangga.config.Database;
import rumahTangga.entities.anggotaKeluarga;
import rumahTangga.entities.inventarisRumah;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
public class InventarisRumahRepositoryImpl implements InventarisRumahRepository {

    private Database database;

    public InventarisRumahRepositoryImpl(Database database) {
        this.database = database;
    }

    @Override
    public ArrayList<inventarisRumah> getAll() {
        Connection connection = database.getConnection();
        String sqlStatement = "SELECT * FROM inventaris_rumah";
        ArrayList<inventarisRumah> inventarisRumahArrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                inventarisRumah rumah = new inventarisRumah();
                Integer id = resultSet.getInt(1);
                String nama = resultSet.getString(2);
                Integer jumlah= resultSet.getInt(3);

                rumah.setId(id);
                rumah.setNama(nama);
                rumah.setJumlah(jumlah);
                inventarisRumahArrayList.add(rumah);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return inventarisRumahArrayList;
    }

    @Override
    public void add(inventarisRumah rumah) {
        String sqlStatement = "INSERT INTO inventaris_rumah(nama, jumlah) values(?,?)";
        Connection conn = database.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
            preparedStatement.setString(1, rumah.getNama());
            preparedStatement.setInt(2, rumah.getJumlah());


            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected > 0) {
                System.out.println("Insert successful !");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Boolean remove(Integer id) {

        String sqlStatement = "DELETE FROM inventaris_rumah WHERE id = ?";
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
    public Boolean edit(inventarisRumah rumah) {
        String sqlStatement = "UPDATE anggota_keluarga set nama = ?, jumlah = ? WHERE id = ?";
        Connection conn = database.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
            preparedStatement.setString(1, rumah.getNama());
            preparedStatement.setInt(2, rumah.getJumlah());
            preparedStatement.setInt(3, rumah.getId());

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