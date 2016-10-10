package homeworkEight.taskOne;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
        boolean actual = dataBase.editName(4, "Mary");
        assertEquals(true, actual);
    }

    @Test
    public void editPassword() throws Exception {
        boolean actual = dataBase.editPassword(1, "newPassword");
        assertEquals(true, actual);
    }

    @Test
    public void information()throws Exception{
        System.out.println(dataBase.getUsers("password"));
    }
    }

