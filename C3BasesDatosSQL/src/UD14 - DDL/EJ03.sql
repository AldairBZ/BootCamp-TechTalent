CREATE DATABASE TiendaDeInformatica;
USE TiendaDeInformatica;

CREATE TABLE fabricante (
    codigo INT PRIMARY KEY,
    nombre VARCHAR(20)
);

CREATE TABLE articulos (
    codigo INT PRIMARY KEY,
    nombre VARCHAR(20),
    precio INT,
    codigoFabricante INT,
    FOREIGN KEY (codigoFabricante) REFERENCES fabricante(codigo)
);