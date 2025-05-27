CREATE DATABASE EstacionesMeteorologicas;
USE EstacionesMeteorologicas;

CREATE TABLE Estación (
    Identificador INT PRIMARY KEY,
    Latitud DECIMAL(8,6),
    Longitud DECIMAL(8,6),
    Altitud INT
);

CREATE TABLE Muestra (
    IdentificadorEstacion INT,
    Fecha DATE,
    Temperatura_minima DECIMAL(5,2),
    Temperatura_maxima DECIMAL(5,2),
    Precipitaciones DECIMAL(5,2),
    Humedad_minima DECIMAL(5,2),
    Humedad_maxima DECIMAL(5,2),
    Velocidad_viento_minima DECIMAL(5,2),
    Velocidad_viento_maxima DECIMAL(5,2),
    FOREIGN KEY (IdentificadorEstacion) REFERENCES Estación(Identificador)
);
