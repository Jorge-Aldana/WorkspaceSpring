package com.music.library.music_library.core;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;    
    private String titulo;    
    private String artista;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Genre genre;

    public Song() {
        // Default constructor for JPA
    }

    public Song(long id, String titulo, String artista, Genre genre) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.genre = genre;
    }

    public Song(String titulo, String artista, Genre genre) {
        this.titulo = titulo;
        this.artista = artista;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    
}
