package com.music.library.music_library.dao.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.library.music_library.core.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
