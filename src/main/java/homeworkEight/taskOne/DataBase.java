package homeworkEight.taskOne;

import java.sql.*;
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

    ResultSet getInfo(String param, String dataBase) {
        ResultSet set = null;
        String prepStatement = "SELECT * FROM testdatabase";
        try (PreparedStatement preparedStatement = setConnection().prepareStatement(prepStatement)) {
            set = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger("getInfo").info("cannot get information from db");
        }
      return set;
    }


}
