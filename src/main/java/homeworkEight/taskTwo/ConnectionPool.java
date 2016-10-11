package homeworkEight.taskTwo;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private BlockingQueue<Connection> connectionQueue;
    private BlockingQueue<Connection> givenAwayConQueue;

    @SneakyThrows
    private ConnectionPool() {

        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\Программы\\JavaFundamentals\\src\\test\\resources\\db.properties"));

        Class.forName(properties.getProperty("driver"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        int poolSize = Integer.parseInt(properties.getProperty("poolSize", "5"));

            givenAwayConQueue = new ArrayBlockingQueue<>(poolSize);
            connectionQueue = new ArrayBlockingQueue<>(poolSize);

            for (int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url, user, password);
                PooledConnection pooledConnection = new PooledConnection(connection);
                connectionQueue.add(pooledConnection);
            }


    }
    public void dispose() {
        clearConnectionQueue();
    }

    private void clearConnectionQueue() {
        try {
            closeConnectionsQueue(givenAwayConQueue);
            closeConnectionsQueue(connectionQueue);

        } catch (SQLException e) {

// logger.log(Level.ERROR, "Error closing the connection.", e);

        }
    }
    public Connection takeConnection() throws ConnectionPoolException {

        Connection connection = null;

        try {
            connection = connectionQueue.take();
            givenAwayConQueue.add(connection);
        } catch (InterruptedException e) {
            throw new ConnectionPoolException(
                    "Error connecting to the data source.", e);
        }

        return connection;

    }

    public void closeConnection(Connection con, Statement st, ResultSet rs) {
        try {
            con.close();

        } catch (SQLException e) {
// logger.log(Level.ERROR, "Connection isn't return to thepool.");
        }

        try {
            rs.close();

        } catch (SQLException e) {
// logger.log(Level.ERROR, "ResultSet isn't closed.");
        }

        try {
            st.close();
        } catch (SQLException e) {
// logger.log(Level.ERROR, "Statement isn't closed.");
        }
    }

    public void closeConnection(Connection con, Statement st) {

        try {

            con.close();

        } catch (SQLException e) {

// logger.log(Level.ERROR, "Connection isn't return to thepool.");
        }
        try {
            st.close();
        } catch (SQLException e) {
// logger.log(Level.ERROR, "Statement isn't closed.");
        }
    }

    private void closeConnectionsQueue(BlockingQueue<Connection> queue) throws SQLException {
        Connection connection;

        while ((connection = queue.poll()) != null) {
            if (!connection.getAutoCommit()) {
                connection.commit();
            }
            ((PooledConnection) connection).reallyClose();
        }
    }
}
