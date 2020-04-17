package ro.uaic.info.pa;

import com.github.javafaker.Faker;
import ro.uaic.info.pa.controllers.AlbumController;
import ro.uaic.info.pa.controllers.ArtistController;
import ro.uaic.info.pa.controllers.ChartController;

import java.util.Random;

public class Lab8 {

    public static void main(String[] args) {
        Faker faker = new Faker();
        Random rand = new Random();

        ArtistController artistController = new ArtistController();

        /* Commented in order to not overload table and maintain id integrity

        // Insert 10 random artists
        // (due to previous tests, they have been generated with ids between 11 and 20)
        for (int i = 0; i < 10; ++i) {
            artistController.create(faker.artist().name(), faker.country().name());
        }

         */

        AlbumController albumController = new AlbumController();

        /* Commented for the same reasons

        // Insert 20 random albums of the previous artists (with ids between 11 and 20)
        // in the years between 1951 and 2020
        // (due to previous tests, they have been generated with ids between 5 and 24)
        for (int i = 0; i < 20; ++i) {
            albumController.create(faker.funnyName().name(), rand.nextInt(10) + 11, rand.nextInt(70) + 1951);
        }

         */

        ChartController chartController = new ChartController();

        /* Commented for the same reasons

        // Inserting previous albums into charts table (with ids between 5 and 24)
        // and reverse order numbers in order to showcase the getArtistsByOrder()
        // method
        for (int i = 0; i < 20; ++i) {
            chartController.create(5 + i, 20 - i);
        }

         */

        System.out.println("This is the artists' top:");
        chartController.getArtistsByOrder().forEach(System.out::println);

    }
}
