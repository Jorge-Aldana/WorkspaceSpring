package com.music.library.music_library.dto;

import jakarta.validation.constraints.NotBlank;

public class SongDTO {

    private long id;
    @NotBlank(message = "{song.title.notblank}")
    private String title;
    @NotBlank(message = "{song.artist.notblank}")
    private String artist;
    @NotBlank(message = "{genre.name.notblank}")
    private String genreName;

    public SongDTO() {
    }

    public SongDTO(long id, String title, String artist, String genreName) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.genreName = genreName;
    }

    public SongDTO(String title, String artist, String genreName) {
        this.title = title;
        this.artist = artist;
        this.genreName = genreName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

}
