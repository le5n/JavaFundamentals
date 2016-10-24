package homeworkEight.taskOne;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

class DataBase {
    private String URL;
    private String name;
    private String password;
    private Connection connection;

    DataBase(String URL, String name, String password) {
        this.URL = URL;
        this.name = name;
        this.password = password;
        setConnection();
    }

    private Connection setConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, name, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    List<Integer> getIds() {
        List<Integer> ids = new ArrayList<>();
        String prepSt = "SELECT id FROM testdatabase.users;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(prepSt)) {
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
            // TODO: 15.10.2016 return List<User>
            while (resultIds.next()) {
                switch (column) {
                    case "userName":
                        names.add(resultIds.getString(2));
                        break;
                    case "password":
                        names.add(resultIds.getString(3));
                        break;
                    default:
                        Logger.getLogger("getUsers").info("no such column detected");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return names;
    }

    boolean editName(int id, String newUserName) {
        String prepStatement = "UPDATE users SET userName = '" + newUserName + "' WHERE id =" + id;
        // TODO: 15.10.2016 to prepare statement to static
//        String prepStatement = "UPDATE users SET userName = ? WHERE id = ?";
        return execute(prepStatement);
    }

    boolean editPassword(int id, String newPassword) {
        String prepStatement = "UPDATE users SET password = '" + newPassword + "' WHERE id =" + id;
        return execute(prepStatement);
    }

    boolean deleteTable(String tableName) {
        // TODO: 15.10.2016 to prepare statement
        String prepStatement = "drop table " + tableName + ";";
        return execute(prepStatement);
    }

    private boolean execute(String prepStatement) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(prepStatement)) {
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    StringBuilder getNote(int id) {
        // TODO: 15.10.2016 to prepare statement to static
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
