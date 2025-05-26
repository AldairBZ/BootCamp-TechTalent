CREATE DATABASE losinvestigadores;
USE losinvestigadores;

CREATE TABLE facultad(
    codigo INT PRIMARY KEY,
    nombre VARCHAR(100)
    );
CREATE TABLE investigadores(
    dni VARCHAR(8) PRIMARY KEY,
    nomApels VARCHAR(255),
    facultad INT,
    FOREIGN KEY(facultad) REFERENCES facultad(codigo)
    );
CREATE TABLE equipos(
    numSerie CHAR(4) PRIMARY KEY,
    nombre VARCHAR(100),
    facultad INT,
    FOREIGN KEY(facultad) REFERENCES facultad(codigo)
    );
CREATE TABLE reserva(
    dni VARCHAR(8),
    numSerie CHAR(4),
    comienzo DATETIME,
    fin DATETIME,
    PRIMARY KEY(dni, numSerie),
    FOREIGN KEY(dni) REFERENCES investigadores(dni),
    FOREIGN KEY(numSerie) REFERENCES equipos(numSerie)
    );