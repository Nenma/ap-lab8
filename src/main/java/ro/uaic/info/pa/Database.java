package ro.uaic.info.pa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private final String url = "jdbc:postgresql://localhost/MusicAlbums";
    private final String user = "dba";
    private final String password = "sql";
    private Connection conn;
    private static Database instance;

    private Database() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully!");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConn() {
        return conn;
    }

}
