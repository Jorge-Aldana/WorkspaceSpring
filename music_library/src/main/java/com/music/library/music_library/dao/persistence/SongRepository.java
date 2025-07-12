package com.music.library.music_library.dao.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.library.music_library.core.Song;

public interface SongRepository extends JpaRepository<Song, Long> {

    List<Song> findByGenre_Name(String name);

}
