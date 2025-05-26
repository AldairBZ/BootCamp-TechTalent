CREATE DATABASE Ej12;
USE Ej12;

CREATE TABLE profesores (
    dni VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido1 VARCHAR(100) NOT NULL,
    apellido2 VARCHAR(100),
    direccion VARCHAR(255),
    titulo VARCHAR(100),
    gana DECIMAL(10,2) NOT NULL,
    UNIQUE(nombre, apellido1, apellido2)
);

CREATE TABLE cursos (
    cod_curso VARCHAR(10) PRIMARY KEY,
    nombre_curso VARCHAR(100) NOT NULL UNIQUE,
    dni_profesor VARCHAR(10),
    maximo_alumnos INT,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    num_horas INT NOT NULL,
    FOREIGN KEY (dni_profesor) REFERENCES profesores(dni)
);

CREATE TABLE alumnos (
    dni VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido1 VARCHAR(100) NOT NULL,
    apellido2 VARCHAR(100),
    direccion VARCHAR(255),
    sexo ENUM('M','H') NOT NULL, 
    fecha_nacimiento DATE,
    curso VARCHAR(10) NOT NULL,
    FOREIGN KEY (curso) REFERENCES cursos(cod_curso)
);