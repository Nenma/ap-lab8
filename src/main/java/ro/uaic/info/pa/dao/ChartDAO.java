package ro.uaic.info.pa.dao;

import ro.uaic.info.pa.model.Artist;

import java.util.List;

public interface ChartDAO {

    List<Artist> getArtistsByOrder();
    boolean create(int albumId, int orderNumber);

}
