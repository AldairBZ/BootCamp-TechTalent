CREATE DATABASE losdirectores;
USE losdirectores;

CREATE TABLE despachos (
    numero INT PRIMARY KEY,
    capacidad INT
);

CREATE TABLE directores (
    dni VARCHAR(8) PRIMARY KEY,
    nomApels VARCHAR(50),
    dniJefe VARCHAR(8),
    despacho INT,
    FOREIGN KEY (dniJefe) REFERENCES directores(dni),  
    FOREIGN KEY (despacho) REFERENCES despachos(numero)
);
