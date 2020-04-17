package ro.uaic.info.pa.controllers;

import ro.uaic.info.pa.Database;
import ro.uaic.info.pa.dao.ArtistDAO;
import ro.uaic.info.pa.model.Artist;

import java.sql.*;

public class ArtistController implements ArtistDAO {

    private Database database = Database.getInstance();

    public ArtistController() {}

    @Override
    public Artist findByName(String name) {
        Connection conn = database.getConn();
        PreparedStatement stmt = null;
        Artist artist = new Artist();
        try {
            stmt = conn.prepareStatement("SELECT * FROM artists WHERE name = ?");
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                artist.setName(rs.getString("name"));
                artist.setCountry(rs.getString("country"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return artist;
    }

    @Override
    public boolean create(String name, String country) {
        Connection conn = database.getConn();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO artists(name, country) VALUES(?, ?)");
            stmt.setString(1, name);
            stmt.setString(2, country);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return true;
    }
}
