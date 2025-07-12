-- Insertar algunos géneros
INSERT INTO genre (name) VALUES ('Rock');
INSERT INTO genre (name) VALUES ('Pop');
INSERT INTO genre (name) VALUES ('Jazz');

-- Insertar algunas canciones
INSERT INTO song (titulo, artista, genre_id) VALUES ('Bohemian Rhapsody', 'Queen', 1);
INSERT INTO song (titulo, artista, genre_id) VALUES ('Billie Jean', 'Michael Jackson', 2);
INSERT INTO song (titulo, artista, genre_id) VALUES ('Take Five', 'Dave Brubeck', 3);
