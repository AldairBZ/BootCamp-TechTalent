CREATE TABLE Libro (
    ClaveLibro INT,
    Titulo VARCHAR(255),
    Idioma VARCHAR(50),
    Formato VARCHAR(50),
    ClaveEditorial INT,
    PRIMARY KEY (ClaveLibro)
);

CREATE TABLE Tema (
    ClaveTema INT,
    Nombre VARCHAR(100),
    PRIMARY KEY (ClaveTema)
);

CREATE TABLE Autor (
    ClaveAutor INT,
    Nombre VARCHAR(100),
    PRIMARY KEY (ClaveAutor)
);

CREATE TABLE Editorial (
    ClaveEditorial INT,
    Nombre VARCHAR(100),
    Direccion VARCHAR(255),
    Telefono VARCHAR(20),
    PRIMARY KEY (ClaveEditorial)
);

CREATE TABLE Ejemplar (
    ClaveEjemplar INT,
    ClaveLibro INT,
    NumeroOrden INT,
    Edicion VARCHAR(50),
    Ubicacion VARCHAR(100),
    Categoria VARCHAR(50),
    PRIMARY KEY (ClaveEjemplar),
    FOREIGN KEY (ClaveLibro) REFERENCES Libro(ClaveLibro)
);

CREATE TABLE Socio (
    ClaveSocio INT,
    Nombre VARCHAR(100),
    Direccion VARCHAR(255),
    Telefono VARCHAR(20),
    Categoria VARCHAR(50),
    PRIMARY KEY (ClaveSocio)
);

CREATE TABLE Prestamo (
    ClaveSocio INT,
    ClaveEjemplar INT,
    NumeroOrden INT,
    Fecha_prestamo DATE,
    Fecha_devolucion DATE,
    Notas TEXT,
    FOREIGN KEY (ClaveSocio) REFERENCES Socio(ClaveSocio),
    FOREIGN KEY (ClaveEjemplar) REFERENCES Ejemplar(ClaveEjemplar)
);

CREATE TABLE Trata_sobre (
    ClaveLibro INT,
    ClaveTema INT,
    FOREIGN KEY (ClaveLibro) REFERENCES Libro(ClaveLibro),
    FOREIGN KEY (ClaveTema) REFERENCES Tema(ClaveTema)
);

CREATE TABLE Escrito_por (
    ClaveLibro INT,
    ClaveAutor INT,
    FOREIGN KEY (ClaveLibro) REFERENCES Libro(ClaveLibro),
    FOREIGN KEY (ClaveAutor) REFERENCES Autor(ClaveAutor)
);