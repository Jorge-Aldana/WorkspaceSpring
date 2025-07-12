package com.music.library.music_library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.music.library.music_library.core.Genre;
import com.music.library.music_library.core.Song;
import com.music.library.music_library.dao.LibraryDao;
import com.music.library.music_library.dto.GenreDTO;
import com.music.library.music_library.dto.SongDTO;

@Service
public class LibraryServiceImp implements LibraryService {

    @Autowired
    @Qualifier("libraryDaoJPAReposImp")
    private LibraryDao libraryDao;    
    
    @Autowired
    private LibraryMapper libraryMapper;

    @Override
    @Transactional
    public void addSong(SongDTO song) {
        Genre genre = libraryDao.addGenre(new Genre(song.getGenreName()));
        Song newSong = libraryMapper.toEntity(song, genre);
        libraryDao.addSong(newSong);
    }

    @Override
    public List<SongDTO> findAllSongsByGenre(String name) {
        return libraryDao.findAllSongsByGenre(name).stream()
                .map(libraryMapper::toDTO)
                .toList();
    }

    @Override
    public Optional<SongDTO> findSongById(long id) {
        return libraryDao.findSongById(id)
                .map(libraryMapper::toDTO);
    }

    @Override
    public List<SongDTO> findAllSongs() {
        return libraryDao.findAllSongs().stream()
                .map(libraryMapper::toDTO)
                .toList();
    }

    @Override
    public List<GenreDTO> findAllGenres() {
        return libraryDao.findAllGenres().stream()
                .map(libraryMapper::toDTO)
                .toList();
    }

    @Override
    @Transactional
    public void addGenre(GenreDTO genre) {
        libraryDao.addGenre(libraryMapper.toEntity(genre));
    }

}
