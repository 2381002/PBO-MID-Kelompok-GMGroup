package rumahTangga.repositories;

import org.springframework.stereotype.Component;
import rumahTangga.config.Database;
import rumahTangga.entities.RumahTangga;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class RumahTanggaRepositoryDbImpl implements RumahTanggaRepository {
    private final Database database;

    public RumahTanggaRepositoryDbImpl(final Database database) {
        this.database = database;
    }

    @Override
    public RumahTangga[] getAll() {
        Connection connection = database.getConnection();
        String sqlStatement = "SELECT * FROM todos";
        List<RumahTangga> rumahTanggaList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                RumahTangga rumahTangga = new RumahTangga();
                Integer id = resultSet.getInt(1);
                String todo = resultSet.getString(2);
                rumahTangga.setId(id);
                rumahTangga.setTodo(todo);
                rumahTanggaList.add(rumahTangga);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rumahTanggaList.toArray(RumahTangga[]::new);
    }

    @Override
    public void add(final RumahTangga rumahTangga) {
        String sqlStatement = "INSERT INTO todos(todo) values(?)";
        Connection conn = database.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
            preparedStatement.setString(1, rumahTangga.getTodo());

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
        String sqlStatement = "DELETE FROM todos WHERE id = ?";
        Connection conn = database.getConnection();
        var dbId = getDbId(id);
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

    private Integer getDbId(final Integer id) {
        RumahTangga[] rumahTanggas = getAll();
        Long countElement = Arrays.stream(rumahTanggas).filter(Objects::nonNull).count();
        if (countElement.intValue() == 0) {
            return null;
        }
        var dbId = rumahTanggas[id - 1].getId();
        return dbId;
    }

    @Override
    public Boolean edit(final RumahTangga rumahTangga) {
        String sqlStatement = "UPDATE todos set todo = ? WHERE id = ?";
        Connection conn = database.getConnection();
        var dbId = getDbId(rumahTangga.getId());
        if (dbId == null) {
            return false;
        }
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
            preparedStatement.setString(1, rumahTangga.getTodo());
            preparedStatement.setInt(2, dbId);

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