# ap-lab8

## Overview
At the moment, the app contains:
- The Database singleton that can successfully connect to a PostgreSQL database
- The Artist, Album and Chart entity classes used for creating the ArtistDAO, AlbumDAO and ChartDAO interfaces
- The ArtistController, AlbumController and ChartController classes that implement ArtistDAO, AlbumDAO and ChartDAO, respectively, with the required overwritten methods
- The Lab8 main class that uses JavaFaker in order to 
  - insert 10 random artists into the **artists** table
  - insert 20 random albums into the **albums** table using the previous artists
  - insert the previous albums into the **charts** table and giving them a orderNumber (descending from 20 to 1)
- The bits of code that do the inserting in Lab8.java have been commented in order to not overload the database tables and to maintain id integrity

## Optional
The tasks are:
- Create the necessary table(s) in order to store *charts* in the database (a chart contains some albums in a specific order).
- Create an object-oriented model of the data managed by the Java application. You should have the classes *Artist*, *Album*, *Chart*.
- Generate random data and insert it into the database. You may consider using a [fake data generator](https://github.com/DiUS/java-faker). (Or you may import real data ...)
- Display the ranking of the artists, considering their positions in the charts.
- (*) For additional points, you may consider generating suggestive HTML reports, using [FreeMarker](https://freemarker.apache.org/) or other reporting tool. 

## Compulsory
The tasks are:
- Create a database having the name MusicAlbums using any RDBMS (Oracle, Postgres, MySql, Java DB, etc.)
- Create a user with the name *dba* and the password *sql*
- Create the following tables (this example uses Java DB SQL Dialect):

```
create table artists(
    id integer not null generated always as identity (start with 1, increment by 1),
    name varchar(100) not null,
    country varchar(100),
    primary key (id)
);
create table albums(
    id integer not null generated always as identity (start with 1, increment by 1),
    name varchar(100) not null,
    artist_id integer not null references artists on delete restrict,
    release_year integer,
    primary key (id)
);
```

- Add the *database driver* to the project libraries.
- Create the *singleton* class *Database* that manages a connection to the database.
- Create the *DAO* class *ArtistController*, having the methods *create(String name, String country)* and *findByName(String name)*.
- Create the *DAO* class *AlbumController*, having the methods *create(String name, int artistId, int releaseYear)* and *findByArtist(int artistId)*.
- Implement a simple test using your classes.
