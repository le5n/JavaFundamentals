package homeworkEight.taskOne;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertEquals;

public class DataBaseTest {
    private String URL = "jdbc:mysql://localhost:3306/testdatabase?serverTimezone=UTC";
    private String name = "root";
    private String password = "root";
    private DataBase dataBase = new DataBase(URL, name, password);


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
    public void getLine() throws Exception{
        String actual = dataBase.getNote(1).toString();
        String expected = "1 newUser newPassword";
        assertEquals(actual,expected);
    }
}

