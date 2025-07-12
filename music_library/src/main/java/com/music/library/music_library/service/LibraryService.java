package com.music.library.music_library.service;

import java.util.List;
import java.util.Optional;

import com.music.library.music_library.dto.GenreDTO;
import com.music.library.music_library.dto.SongDTO;

public interface LibraryService {

    
   List<SongDTO> findAllSongsByGenre(String name);

    Optional<SongDTO> findSongById(long id);

    List<SongDTO> findAllSongs();

    List<GenreDTO> findAllGenres();

    void addSong(SongDTO song);

    void addGenre(GenreDTO genre);

}
