DROP TABLE IF EXISTS song;
DROP TABLE IF EXISTS genre;
-- Crear tabla de géneros
CREATE TABLE genre (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

-- Crear tabla de canciones
CREATE TABLE song (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(200) NOT NULL,
    artista VARCHAR(100),
    genre_id BIGINT,
    FOREIGN KEY (genre_id) REFERENCES genre(id)
);
