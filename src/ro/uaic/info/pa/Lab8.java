package ro.uaic.info.pa;

import ro.uaic.info.pa.controllers.AlbumController;
import ro.uaic.info.pa.controllers.ArtistController;
import ro.uaic.info.pa.model.Album;
import ro.uaic.info.pa.model.Artist;

public class Lab8 {

    public static void main(String[] args) {
        ArtistController artistController = new ArtistController();
        AlbumController albumController = new AlbumController();

        artistController.create("3 Sud Est", "Romania");
        artistController.create("Imagine Dragons", "USA");

        albumController.create("Epic", 1, 2018);
        albumController.create("Origins", 2, 2018);

        Artist dragons = artistController.findByName("Imagine Dragons");
        System.out.println(dragons);
        Album epic = albumController.findByArtist(1);
        System.out.println(epic);
    }
}
