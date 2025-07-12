package com.music.library.music_library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.music.library.music_library.core.Genre;
import com.music.library.music_library.core.Song;
import com.music.library.music_library.dto.GenreDTO;
import com.music.library.music_library.dto.SongDTO;

@Service
public class LibraryMapper {

    public SongDTO toDTO(Song song) {
        SongDTO dto = new SongDTO();
        dto.setId(song.getId());
        dto.setTitle(song.getTitulo());
        dto.setArtist(song.getArtista());
        dto.setGenreName(song.getGenre() != null ? song.getGenre().getName() : null);
        return dto;
    }

    public Optional<SongDTO> toDTO(Optional<Song> song) {
        SongDTO dto = new SongDTO();
        if (song.isPresent()) {
            Song s = song.get();
            dto.setId(s.getId());
            dto.setTitle(s.getTitulo());
            dto.setArtist(s.getArtista());
            dto.setGenreName(s.getGenre() != null ? s.getGenre().getName() : null);
        }
        return Optional.of(dto);
    }

    public Song toEntity(SongDTO dto, Genre genre) {
        return new Song(dto.getTitle(), dto.getArtist(), genre);
    }

    public Genre toEntity(GenreDTO genre) {
        Genre newGenre = new Genre(genre.getName());
        return newGenre;
    }

    public GenreDTO toDTO(Genre genre) {
        GenreDTO dto = new GenreDTO();
        dto.setId(genre.getId());
        dto.setName(genre.getName());
        List<String> songTitles = genre.getSongs().stream()
            .map(Song::getTitulo)
            .toList();
        dto.setSongTitles(songTitles);
        return dto;
    }

}
