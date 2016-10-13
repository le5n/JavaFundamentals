package homeworkEight.taskTwo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

 class ConnectionPool {
    private BlockingQueue<Connection> connectionQueue;


    public ConnectionPool(String pathToConfig) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(pathToConfig));
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException|IOException e) {
            e.printStackTrace();
        }
        String url = properties.getProperty("url");
        int poolSize = Integer.parseInt(properties.getProperty("poolSize"));

        connectionQueue = new ArrayBlockingQueue<>(poolSize);

        for (int i = 0; i < poolSize; i++) {
            try {
                connectionQueue.add(new PooledConnection(DriverManager.getConnection(url, properties), this));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = connectionQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return connection;
    }
    void acceptConnection (PooledConnection connection){
        connectionQueue.offer(connection);
    }

    public void useAndDelete() {
        try {
            Connection connection;

            while ((connection = connectionQueue.poll()) != null) {
                if (!connection.getAutoCommit()) {
                    connection.commit();
                }
                ((PooledConnection) connection).reallyClose();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
