CREATE DATABASE peliculasyseries;
USE peliculasyseries;

CREATE TABLE peliculas(
    codigo INT PRIMARY KEY,
    nombre VARCHAR(10),
    calificacionEdad INT
);

CREATE TABLE salas(
    codigo INT PRIMARY KEY,
    nombre VARCHAR(100),
    codigoPelicula INT,
    FOREIGN KEY(codigoPelicula) REFERENCES peliculas(codigo)
    );