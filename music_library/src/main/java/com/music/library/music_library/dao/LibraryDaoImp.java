package com.music.library.music_library.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.music.library.music_library.core.Genre;
import com.music.library.music_library.core.Song;

@Repository
public class LibraryDaoImp implements LibraryDao {

    private List<Song> songs; // Assuming a collection to hold songs
    private List<Genre> genres;

    public LibraryDaoImp() {
        // Initialize the collection, e.g., using an ArrayList or HashSet
        this.songs = new java.util.ArrayList<>();
        this.genres = new java.util.ArrayList<>();        
    }

    @Override
    public List<Song> findAllSongsByGenre(String name) {
        // Implementation to find songs by genre
        System.out.println("Finding songs in genre: " + name);
        for (Genre genre : genres) {
            if (genre.getName().equalsIgnoreCase(name)) {
                return genre.getSongs();
            }
        }
        return java.util.Collections.emptyList();
    }

    @Override
    public Optional<Song> findSongById(long id) {
        // Implementation to find a song by its ID
        for (Song song : songs) {
            if (song.getId() == id) {
                return Optional.of(song);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Song> findAllSongs() {
        // Implementation to find all songs
        return songs;
    }

    @Override
    public void addSong(Song song) {
        // Implementation to add a Song object directly
        System.out.println("Adding song: " + song.getTitulo() + " by " + song.getArtista());
        songs.add(song);
        if (song.getGenre() != null) {
            // If the song has a genre, ensure it's added to the genre's song list
            Genre genre = song.getGenre();
            if (!genres.contains(genre)) {
                genres.add(genre); // Add genre if not already present
            }
            genre.getSongs().add(song); // Add the song to the genre's song list
        }
    }

    @Override
    public Genre addGenre(Genre genre) {
        // Implementation to add a Genre object directly
        System.out.println("Adding genre: " + genre.getName());
        genres.add(genre);
        genre.getSongs().forEach(song -> {
            song.setGenre(genre); // Set the genre for each song in the genre
            addSong(song); // Add the song to the collection
        });
        return genre; // Return the added genre
    }

    @Override
    public List<Genre> findAllGenres() {
        // Implementation to find all genres
        return genres;
    }

    

}
