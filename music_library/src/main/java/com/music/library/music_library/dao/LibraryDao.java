package com.music.library.music_library.dao;

import java.util.List;
import java.util.Optional;

import com.music.library.music_library.core.Genre;
import com.music.library.music_library.core.Song;

public interface LibraryDao {

    List<Song> findAllSongsByGenre(String name);

    Optional<Song> findSongById(long id);

    List<Song> findAllSongs();

    List<Genre> findAllGenres();

    void addSong(Song song);

    Genre addGenre(Genre genre);


}
