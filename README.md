# ap-lab8

## Overview
At the moment, the app contains:
- The Database singleton that can successfully connect to a PostgreSQL database
- The Artist and Album entity classes used for creating the ArtistDAO and AlbumDAO interfaces
- The ArtistController and AlbumController classes that implement ArtistDAO and AlbumDAO, respectively, with the required overwritten methods
- The Lab8 main class that inserts 2 entries into Artists and 2 entries into Albums and calls the implemented methods

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
