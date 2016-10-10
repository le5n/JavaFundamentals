package homeworkEight.taskOne;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertEquals;

public class DataBaseTest {
    private String URL = "jdbc:mysql://localhost:3306/testdatabase?serverTimezone=UTC";
    private String name = "root";
    private String password = "root";
    DataBase dataBase = new DataBase(URL, name, password);

    @Test
    public void connectionAlive() throws Exception {
        Connection connection = dataBase.setConnection();
        assertEquals(false, connection.isClosed());
    }

    @Test
    public void editUser() throws Exception {
        //boolean actual = dataBase.editName("veryNewUser", 2);
       // assertEquals(true, actual);
    }
}