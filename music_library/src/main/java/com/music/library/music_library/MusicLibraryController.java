package com.music.library.music_library;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.music.library.music_library.dto.GenreDTO;
import com.music.library.music_library.dto.SongDTO;
import com.music.library.music_library.service.LibraryService;

@RestController
@RequestMapping("/api/v1/music-library")
public class MusicLibraryController {

    @Autowired
	private LibraryService libraryService;

	@GetMapping(produces = "application/json", path="/songs")
	public List<SongDTO> getSongs() {
		return libraryService.findAllSongs();
	}
	@GetMapping("/song/{id}")
	public Optional<SongDTO> getSong(@PathVariable("id") long id) {
         return libraryService.findSongById(id);
	}	
	@PostMapping(path="/post-add-song", consumes = "application/json", produces = "application/json")
	public ResponseEntity<SongDTO> postAddSong(@RequestBody SongDTO song) {
		libraryService.addSong(song);
		return ResponseEntity.ok(song);
	}
    @GetMapping("/songs-by-genre")
    public List<SongDTO> getSongsByGenre(@RequestParam("name") String name) {
        return libraryService.findAllSongsByGenre(name);
    }
    @GetMapping(produces = "application/json",path = "/genres")
    public List<GenreDTO> getGenres() {
        return libraryService.findAllGenres();
    }
    @PostMapping(path="/post-add-genre", consumes = "application/json", produces = "application/json")
    public void addGenre(@RequestBody GenreDTO genre) {
        libraryService.addGenre(genre);
    }

	
	

}
