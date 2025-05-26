CREATE DATABASE piezasyproveedores;
USE piezasyproveedores;
CREATE TABLE proveedores(
    id char(4) PRIMARY KEY,
    nombre VARCHAR(100)
    );

CREATE TABLE piezas(
    codigo INT PRIMARY KEY,
    nombre VARCHAR(100)
    );

CREATE TABLE suministra(
    codigoPieza INT,
    idProveedor CHAR(4),
    PRIMARY KEY (codigoPieza, idProveedor),
    FOREIGN KEY (codigoPieza) REFERENCES piezas(codigo),
    FOREIGN KEY (idProveedor) REFERENCES proveedores(id)
);