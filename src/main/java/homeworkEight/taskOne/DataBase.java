package homeworkEight.taskOne;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

class DataBase {
    private String URL;
    private String name;
    private String password;

    DataBase(String URL, String name, String password) {
        this.URL = URL;
        this.name = name;
        this.password = password;
    }

    Connection setConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = DriverManager.getConnection(URL, name, password);
        return connection;
    }

    List<Integer> getIds() {
        List<Integer> ids = new ArrayList<>();
        String prepSt = "SELECT id FROM testdatabase.users;";
        try (PreparedStatement preparedStatement = setConnection().prepareStatement(prepSt)) {
            ResultSet resultIds = preparedStatement.executeQuery();
            while (resultIds.next()) {
                ids.add(resultIds.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }

    List<String> getUsers(String column) {
        List<String> names = new ArrayList<>();
        String prepSt = "SELECT * FROM testdatabase.users;";
        try (PreparedStatement preparedStatement = setConnection().prepareStatement(prepSt)) {
            ResultSet resultIds = preparedStatement.executeQuery();
            while (resultIds.next()) {
                if (column.equals("userName"))
                    names.add(resultIds.getString(2));
                else if (column.equals("password"))
                    names.add(resultIds.getString(3));
                else
                    Logger.getLogger("getUsers").info("no such column detected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return names;
    }

    boolean editName(int id, String newUserName) {
        String prepStatement = "UPDATE users SET userName = '" + newUserName + "' WHERE id =" + id;
        return execute(prepStatement);
    }

    boolean editPassword(int id, String newPassword) {
        String prepStatement = "UPDATE users SET password = '" + newPassword + "' WHERE id =" + id;
        return execute(prepStatement);
    }

    boolean deleteTable(String tableName) {
        String prepStatement = "drop table " + tableName + ";";
        return execute(prepStatement);
    }

    private boolean execute(String prepStatement) {
        try (PreparedStatement preparedStatement = setConnection().prepareStatement(prepStatement)) {
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    StringBuilder getNote(int id) {
        String prepStatement = "select * from testdatabase.users where id=" + id + ";";
        StringBuilder line = new StringBuilder();
        try (PreparedStatement preparedStatement = setConnection().prepareStatement(prepStatement)) {
            ResultSet resultSet = preparedStatement.executeQuery(prepStatement);
            while (resultSet.next()) {
                line.append(resultSet.getInt(1)).append(" ");
                line.append(resultSet.getString(2)).append(" ");
                line.append(resultSet.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return line;
    }


}
