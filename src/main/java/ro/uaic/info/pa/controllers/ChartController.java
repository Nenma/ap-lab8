package ro.uaic.info.pa.controllers;

import ro.uaic.info.pa.Database;
import ro.uaic.info.pa.dao.ChartDAO;
import ro.uaic.info.pa.model.Artist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChartController implements ChartDAO {

    private Database database = Database.getInstance();

    public ChartController() {}

    @Override
    public List<Artist> getArtistsByOrder() {
        List<Artist> artists = new ArrayList<Artist>();
        Connection conn = database.getConn();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ar.name, ar.country FROM charts c \n" +
                                                    "\tJOIN albums al ON c.album_id = al.id\n" +
                                                    "\tJOIN artists ar ON al.artist_id = ar.id\n" +
                                                    "\tORDER BY c.order_nr ASC;");
            while (rs.next()) {
                artists.add(new Artist(rs.getString("name"), rs.getString("country")));
            }
            rs.close();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return artists;
    }

    @Override
    public boolean create(int albumId, int orderNumber) {
        Connection conn = database.getConn();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO charts(album_id, order_nr) VALUES(?, ?)");
            stmt.setInt(1, albumId);
            stmt.setInt(2, orderNumber);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return true;
    }
}
