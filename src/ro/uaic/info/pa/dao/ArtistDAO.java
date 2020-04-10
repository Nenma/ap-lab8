package ro.uaic.info.pa.dao;

import ro.uaic.info.pa.model.Artist;

public interface ArtistDAO {

    Artist findByName(String name);
    boolean create(String name, String country);

}
