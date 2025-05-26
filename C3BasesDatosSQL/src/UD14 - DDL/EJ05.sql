CREATE DATABASE losalmacenes;
USE losalmacenes;
CREATE TABLE almacenes(
    codigo INT PRIMARY KEY,
    lugar VARCHAR(100),
    capacidad INT
    );

    CREATE TABLE cajas(
numReferencia char(5) PRIMARY KEY,
    contenido VARCHAR(100),
    valor INT,
    codigoAlmacen INT,
    FOREIGN KEY(codigoAlmacen) REFERENCES almacenes(codigo)
    );