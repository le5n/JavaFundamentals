package homeworkEight.taskOne;

import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.assertEquals;

public class DataBaseTest {
    private String URL = "jdbc:mysql://localhost:3306/testdatabase?serverTimezone=UTC";
    private String name = "root";
    private String password = "root";

    @Test
    public void connectionAlive() throws Exception {
        DataBase dataBase = new DataBase(URL,name,password);
        Connection connection = dataBase.setConnection();
        assertEquals(false, connection.isClosed());
    }
}