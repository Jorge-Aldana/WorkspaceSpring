package com.music.library.music_library.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

public class GenreDTO {

    private long id;
    @NotBlank(message = "{genre.name.notblank}")
    private String name;
    private List<String> songTitles;

    public GenreDTO() {
    }

    public GenreDTO(String name) {
        this.name = name;
    }

    public GenreDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSongTitles() {
        return songTitles;
    }
    public void setSongTitles(List<String> songTitles) {
        this.songTitles = songTitles;
    }

}
