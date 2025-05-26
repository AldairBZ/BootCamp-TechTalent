CREATE DATABASE loscientificos;
USE loscientificos;

CREATE TABLE cientificos (
    dni VARCHAR(8) PRIMARY KEY,
    nomApels VARCHAR(255)
);

CREATE TABLE proyectos (
    id CHAR(4) PRIMARY KEY,
    nombre VARCHAR(255),
    horas INT
);

CREATE TABLE asignado_a (
    cientifico VARCHAR(8),
    proyecto CHAR(4),
    PRIMARY KEY(cientifico, proyecto),
    FOREIGN KEY(cientifico) REFERENCES cientificos(dni),
    FOREIGN KEY(proyecto) REFERENCES proyectos(id)
);
