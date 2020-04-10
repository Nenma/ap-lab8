package ro.uaic.info.pa.controllers;

import ro.uaic.info.pa.Database;
import ro.uaic.info.pa.dao.AlbumDAO;
import ro.uaic.info.pa.model.Album;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlbumController implements AlbumDAO {

    private Database database = Database.getInstance();

    public AlbumController() {}

    @Override
    public Album findByArtist(int artistId) {
        Connection conn = database.getConn();
        PreparedStatement stmt = null;
        Album album = new Album();
        try {
            stmt = conn.prepareStatement("SELECT * FROM albums WHERE artist_id = ?");
            stmt.setInt(1, artistId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                album.setName(rs.getString("name"));
                album.setArtistId(rs.getInt("artist_id"));
                album.setReleaseYear(rs.getInt("release_year"));
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return album;
    }

    @Override
    public boolean create(String name, int artistId, int releaseYear) {
        Connection conn = database.getConn();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO albums(name, artist_id, release_year) VALUES(?, ?, ?)");
            stmt.setString(1, name);
            stmt.setInt(2, artistId);
            stmt.setInt(3, releaseYear);
            stmt.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return true;
    }
}
