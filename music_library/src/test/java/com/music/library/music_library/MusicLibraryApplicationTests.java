package com.music.library.music_library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.music.library.music_library.dto.GenreDTO;
import com.music.library.music_library.dto.SongDTO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MusicLibraryApplicationTests {

	@LocalServerPort
    private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	private String getBaseUrl() {
        return "http://localhost:" + port + "/api/v1/music-library";
    }

	@Test
    public void testGetSongs() {
		ResponseEntity<SongDTO[]> response = testRestTemplate.getForEntity(getBaseUrl() + "/songs", SongDTO[].class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		SongDTO[] songs = response.getBody();
		assertNotNull(songs);
		assertTrue(songs.length > 0);
	}

    @Test
    public void testGetSong() {
        ResponseEntity<SongDTO> response = testRestTemplate.getForEntity(getBaseUrl() + "/song/1", SongDTO.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        SongDTO song = response.getBody();
        assertNotNull(song);
        assertEquals("Bohemian Rhapsody", song.getTitle());
        assertEquals("Queen", song.getArtist());
    }

	@Test
	public void testPostAddSong() {
		SongDTO newSong = new SongDTO("Buscando tus besos", "Rubby Perez", "Vallenato");

		ResponseEntity<SongDTO> response = testRestTemplate.postForEntity(getBaseUrl() + "/post-add-song", newSong, SongDTO.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		SongDTO addedSong = response.getBody();
		assertNotNull(addedSong);
		assertEquals("Buscando tus besos", addedSong.getTitle());
		assertEquals("Rubby Perez", addedSong.getArtist());
	}

	@Test
	public void testGetSongsByGenre() {
		ResponseEntity<SongDTO[]> response = testRestTemplate.getForEntity(getBaseUrl() + "/songs-by-genre?name=Rock", SongDTO[].class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		SongDTO[] songs = response.getBody();
		assertNotNull(songs);
		assertTrue(songs.length > 0);
		for (SongDTO song : songs) {
			assertEquals("Rock", song.getGenreName());
		}
	}

	@Test
	public void testGetGenres() {
		ResponseEntity<GenreDTO[]> response = testRestTemplate.getForEntity(getBaseUrl() + "/genres", GenreDTO[].class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		GenreDTO[] genres = response.getBody();
		assertNotNull(genres);
		assertTrue(genres.length > 0);
		Stream.of(genres)
			.forEach(genre -> {
				assertNotNull(genre.getName());
				assertNotNull(genre.getSongTitles());
			});		
	}

	@Test
	public void testPostAddGenre() {
		GenreDTO newGenre = new GenreDTO("Pop-Vallenato");
		ResponseEntity<Void> response = testRestTemplate.postForEntity(getBaseUrl() + "/post-add-genre", newGenre, Void.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
		ResponseEntity<GenreDTO[]> genreResponse = testRestTemplate.getForEntity(getBaseUrl() + "/genres", GenreDTO[].class);
		assertEquals(HttpStatus.OK, genreResponse.getStatusCode());
		GenreDTO[] genres = genreResponse.getBody();
		assertNotNull(genres);
		boolean genreFound = Stream.of(genres)
			.anyMatch(genre -> "Pop-Vallenato".equals(genre.getName()));
		
		assertTrue(genreFound, "New genre should be present in the list");
	}

	

	

	

}
