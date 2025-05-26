CREATE DATABASE empleados;
USE empleados;

CREATE TABLE departamentos (
    codigo INT PRIMARY KEY,
    nombre VARCHAR(10),
    presupuesto INT
);

CREATE TABLE empleados (
    dni INT PRIMARY KEY,
    nombre VARCHAR(10),
    apellidos VARCHAR(10),
    codigoDepartamento INT,
    FOREIGN KEY (codigoDepartamento) REFERENCES departamentos(codigo)
);
