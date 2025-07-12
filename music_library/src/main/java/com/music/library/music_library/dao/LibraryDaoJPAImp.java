package com.music.library.music_library.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.music.library.music_library.core.Genre;
import com.music.library.music_library.core.Song;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class LibraryDaoJPAImp implements LibraryDao {

    // Assuming you have a JPA EntityManager injected here
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Genre addGenre(Genre genre) {
        // Implementation to add a genre object using JPA
        return entityManager.merge(genre);
    }

    @Override
    public void addSong(Song song) {
        // Implementation to add a song object using JPA
        entityManager.persist(song);
    }

    @Override
    public List<Song> findAllSongsByGenre(String name) {
        // Implementation to find songs by genre using JPA
        return entityManager.createQuery("SELECT s FROM Song s WHERE s.genre.name = :name", Song.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public Optional<Song> findSongById(long id) {
        // Implementation to find a song by its ID using JPA
        Song song = entityManager.find(Song.class, id);
        return Optional.ofNullable(song);
    }

    @Override
    public List<Song> findAllSongs() {
        // Implementation to find all songs using JPA
        return entityManager.createQuery("SELECT s FROM Song s", Song.class).getResultList();
    }

    @Override
    public List<Genre> findAllGenres() {
        // Implementation to find all genres using JPA
        return entityManager.createQuery("SELECT g FROM Genre g", Genre.class).getResultList();
    }

}
