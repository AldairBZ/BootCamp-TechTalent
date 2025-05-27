-- Crear tabla FABRICANTES
CREATE TABLE FABRICANTES (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL
);

-- Crear tabla ARTICULOS
CREATE TABLE ARTICULOS (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Precio DECIMAL(10,2) NOT NULL,
    Fabricante INT,
    FOREIGN KEY (Fabricante) REFERENCES FABRICANTES(ID)
);

-- Insertar datos en FABRICANTES
INSERT INTO FABRICANTES (Nombre) VALUES 
('Asus'),
('HP'),
('Logitech'),
('Apple');

-- Insertar datos en ARTICULOS
INSERT INTO ARTICULOS (Nombre, Precio, Fabricante) VALUES 
('Portátil ASUS VivoBook', 600, 1),
('Impresora HP LaserJet', 120, 2),
('Ratón Logitech M185', 15, 3),
('Teclado Logitech K380', 35, 3),
('iPhone 13', 899, 4),
('AirPods', 179, 4),
('HP Monitor 24"', 199, 2),
('USB-C Hub', 60, 1);

-- 1.1 Obtener los nombres de los productos
SELECT Nombre 
FROM ARTICULOS;

-- 1.2 Obtener los nombres y precios
SELECT Nombre, Precio 
FROM ARTICULOS;

-- 1.3 Obtener productos con precio <= 200 €
SELECT Nombre 
FROM ARTICULOS
WHERE Precio <= 200;

-- 1.4 Obtener artículos con precio entre 60 y 120 €
SELECT * 
FROM ARTICULOS
WHERE Precio BETWEEN 60 AND 120;

-- 1.5 Obtener nombre y precio en pesetas
SELECT Nombre, Precio * 166.386 AS PrecioEnPesetas 
FROM ARTICULOS;