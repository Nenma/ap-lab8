package ro.uaic.info.pa.dao;

import ro.uaic.info.pa.model.Album;

public interface AlbumDAO {

    Album findByArtist(int artistId);
    boolean create(String name, int artistId, int releaseYear);

}
