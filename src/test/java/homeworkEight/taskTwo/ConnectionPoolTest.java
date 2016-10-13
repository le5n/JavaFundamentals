package homeworkEight.taskTwo;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class ConnectionPoolTest {
    static private String pathToConfig = "D:\\Программы\\JavaFundamentals\\src\\test\\resources\\db.properties";
    static private ConnectionPool connectionPool;

    @BeforeClass
    public static void init() {
        connectionPool = new ConnectionPool(pathToConfig);
    }

    @Test
    public void connectionTest() throws Exception {
        Collection<Book> books;

        try (Connection connection = connectionPool.getConnection();
        Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM library.`anti-utopias`;")){
            books = new ArrayList<>();
            while (resultSet.next()){
                books.add(
                        new Book(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3)
                        ));
            }
        }
        System.out.println(books);
        Assert.assertTrue(books.contains(new Book(1,"1984","George Orwell")));
    }
}