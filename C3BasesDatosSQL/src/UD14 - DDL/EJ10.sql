CREATE DATABASE losgrandesalmacenes;
USE losgrandesalmacenes;

CREATE TABLE cajero(
    codigo INT PRIMARY KEY,
    nomApels VARCHAR(255)
    );
CREATE TABLE productos(
    codigo INT PRIMARY KEY,
    nombre VARCHAR(100),
    precio INT
    );
CREATE TABLE maquinas_Registradoras(
    codigo INT PRIMARY KEY,
    piso INT
    );

CREATE TABLE venta(
    cajero INT,
    maquina INT,
    producto INT,
    PRIMARY KEY(cajero, maquina, producto),
    FOREIGN KEY(cajero) REFERENCES cajero(codigo),
    FOREIGN KEY(maquina) REFERENCES maquinas_registradoras(codigo),
    FOREIGN KEY(producto) REFERENCES productos(codigo)
    );