package com.music.library.music_library.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.music.library.music_library.core.Genre;
import com.music.library.music_library.core.Song;
import com.music.library.music_library.dao.persistence.GenreRepository;
import com.music.library.music_library.dao.persistence.SongRepository;

@Repository
public class LibraryDaoJPAReposImp implements LibraryDao {

    @Autowired
    private SongRepository songRepository;
    @Autowired
    private GenreRepository genreRepository;


    @Override
    public List<Song> findAllSongsByGenre(String name) {
        return songRepository.findByGenre_Name(name);
    }

    @Override
    public Optional<Song> findSongById(long id) {
        return songRepository.findById(id);
    }

    @Override
    public List<Song> findAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public void addSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public Genre addGenre(Genre genre) {
        return genreRepository.save(genre);
    }

}
